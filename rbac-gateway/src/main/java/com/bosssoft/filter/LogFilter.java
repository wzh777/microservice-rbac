package com.bosssoft.filter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


/**
 * @author 吴志鸿
 * @date 2020/7/23
 * @description
 */
@Component
public class LogFilter implements GlobalFilter, Ordered {

    /**
     * 日志
     */
    private final static Logger logger = LoggerFactory.getLogger(LogFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        String method = request.getMethodValue();
        if (HttpMethod.POST.matches(method)) {
            return DataBufferUtils.join(exchange.getRequest().getBody())
                    .flatMap(dataBuffer -> {
                        byte[] bytes = new byte[dataBuffer.readableByteCount()];
                        dataBuffer.read(bytes);
                        String bodyString = new String(bytes, StandardCharsets.UTF_8);
                        logtrace(exchange, bodyString);
                        exchange.getAttributes().put("POST_BODY", bodyString);
                        DataBufferUtils.release(dataBuffer);
                        Flux<DataBuffer> cachedFlux = Flux.defer(() -> {
                            DataBuffer buffer = exchange.getResponse().bufferFactory()
                                    .wrap(bytes);
                            return Mono.just(buffer);
                        });

                        ServerHttpRequest mutatedRequest = new ServerHttpRequestDecorator(
                                exchange.getRequest()) {
                            @Override
                            public Flux<DataBuffer> getBody() {
                                return cachedFlux;
                            }
                        };
                        return chain.filter(exchange.mutate().request(mutatedRequest)
                                .build());
                    });

        }else if (HttpMethod.GET.matches(method)) {
            Map m = request.getQueryParams();
            logtrace(exchange, m.toString());

        }
        return chain.filter(exchange);
    }

    private void logtrace(ServerWebExchange exchange, String param) {
        ServerHttpRequest serverHttpRequest = exchange.getRequest();
        String path = serverHttpRequest.getURI().getPath();
        String method = serverHttpRequest.getMethodValue();
        InetSocketAddress localAddress = serverHttpRequest.getLocalAddress();
        HttpHeaders headers = serverHttpRequest.getHeaders();
        StringBuilder accessLog = new StringBuilder();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        accessLog.append(localAddress).append(" - - ");
        accessLog.append("[").append(format).append("] ");
        accessLog.append("\"").append(method).append(" ").append(path).append("\" ");
        accessLog.append(headers.get("User-Agent")).append(" ");
        accessLog.append("{").append(param).append("} ");
        FileOutputStream fos = null;
        try {
            fos  = new FileOutputStream("D://log/access-log.log",true);
            fos.write(accessLog.toString().getBytes());
            String huanhang = System.getProperty("line.separator");
            fos.write(huanhang.getBytes());
        } catch (IOException e) {
            logger.info("exception",e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    logger.info("exception",e);
                }
            }
        }
    }


    @Override
    public int getOrder() {
        return 0;
    }
}
