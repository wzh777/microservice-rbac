package com.bosssoft.util;

/**
 * @author 吴志鸿
 * @date 2020/7/26
 * @description
 */
@FunctionalInterface
public interface ColaBeanUtilsCallBack<S, T> {
    void callBack(S t, T s);
}
