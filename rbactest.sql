/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : localhost:3306
 Source Schema         : rbactest

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 27/07/2020 20:09:32
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for per_role
-- ----------------------------
DROP TABLE IF EXISTS `per_role`;
CREATE TABLE `per_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pid` int(0) NULL DEFAULT NULL COMMENT '权限id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `pid`(`pid`) USING BTREE,
  INDEX `rid2`(`rid`) USING BTREE,
  CONSTRAINT `pid` FOREIGN KEY (`pid`) REFERENCES `permissions` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `rid2` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of per_role
-- ----------------------------
INSERT INTO `per_role` VALUES (1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `per_role` VALUES (5, 1, 2, 1, 0, NULL, NULL);
INSERT INTO `per_role` VALUES (6, 2, 2, 1, 0, NULL, NULL);
INSERT INTO `per_role` VALUES (7, 3, 2, 1, 0, NULL, NULL);
INSERT INTO `per_role` VALUES (8, 4, 2, 1, 0, NULL, NULL);
INSERT INTO `per_role` VALUES (9, 5, 2, 1, 0, NULL, NULL);
INSERT INTO `per_role` VALUES (10, 1, 1, 1, 1, '2020-07-27 09:36:24', '2020-07-27 09:36:24');
INSERT INTO `per_role` VALUES (11, 2, 1, 1, 1, '2020-07-27 09:36:24', '2020-07-27 09:36:24');
INSERT INTO `per_role` VALUES (12, 1, 1, 1, 1, '2020-07-27 09:37:37', '2020-07-27 09:37:37');
INSERT INTO `per_role` VALUES (13, 2, 1, 1, 1, '2020-07-27 09:37:37', '2020-07-27 09:37:37');
INSERT INTO `per_role` VALUES (14, 3, 1, 1, 1, '2020-07-27 09:37:37', '2020-07-27 09:37:37');
INSERT INTO `per_role` VALUES (15, 1, 1, 1, 1, '2020-07-27 09:37:40', '2020-07-27 09:37:40');
INSERT INTO `per_role` VALUES (16, 2, 1, 1, 1, '2020-07-27 09:37:40', '2020-07-27 09:37:40');
INSERT INTO `per_role` VALUES (17, 1, 1, 1, 0, '2020-07-27 09:38:16', '2020-07-27 09:38:16');
INSERT INTO `per_role` VALUES (18, 1, 3, 1, 0, '2020-07-27 09:42:12', '2020-07-27 09:42:12');
INSERT INTO `per_role` VALUES (19, 3, 3, 1, 0, '2020-07-27 09:42:12', '2020-07-27 09:42:12');
INSERT INTO `per_role` VALUES (20, 4, 3, 1, 0, '2020-07-27 09:42:12', '2020-07-27 09:42:12');

-- ----------------------------
-- Table structure for permissions
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '权限名',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '访问路径',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of permissions
-- ----------------------------
INSERT INTO `permissions` VALUES (1, '查询用户列表', 'user/querylist', 1, 0, NULL, NULL);
INSERT INTO `permissions` VALUES (2, '添加用户', 'user/adduser', 1, 0, NULL, NULL);
INSERT INTO `permissions` VALUES (3, '删除用户', 'user/removeuser', 1, 0, NULL, NULL);
INSERT INTO `permissions` VALUES (4, '修改用户', 'user/updateuser', 1, 0, NULL, NULL);
INSERT INTO `permissions` VALUES (5, '修改权限', 'user/mange', 1, 0, NULL, NULL);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色类型',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES (1, '普通员工', 1, 0, '2020-07-26 03:11:37', '2020-07-26 03:11:37');
INSERT INTO `role` VALUES (2, '经理', 1, 0, '2020-07-26 03:12:49', '2020-07-26 03:12:49');
INSERT INTO `role` VALUES (3, '总经理', 1, 0, '2020-07-27 09:40:58', '2020-07-27 09:40:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `age` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '年龄',
  `pwd` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '电子邮箱',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 8 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'wzh', '18', '123456', '504522387@qq.com', 1, 0, '2020-07-25 03:18:08', '2020-07-26 11:58:43');
INSERT INTO `user` VALUES (2, 'scf', '18', '12345', '15860920528@163.com', 1, 1, NULL, '2020-07-25 08:41:35');
INSERT INTO `user` VALUES (3, 'qwe', '18', '123', '504522387@qq.com', 1, 1, '2020-07-25 09:20:38', '2020-07-25 09:20:38');
INSERT INTO `user` VALUES (4, 'super', '18', '123', '504522387@qq.com', 1, 0, '2020-07-25 09:20:38', '2020-07-25 09:20:38');
INSERT INTO `user` VALUES (5, NULL, NULL, NULL, NULL, 1, 1, '2020-07-26 12:13:48', '2020-07-26 12:13:48');
INSERT INTO `user` VALUES (6, '老王', '123', '12345', '123451@qq.com', 1, 1, '2020-07-26 12:16:06', '2020-07-26 12:16:33');
INSERT INTO `user` VALUES (7, '老大', '29', '1235', '1234567@qq.com', 1, 0, '2020-07-27 09:41:23', '2020-07-27 09:42:41');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role`  (
  `id` int(0) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uid` int(0) NULL DEFAULT NULL COMMENT '用户id',
  `rid` int(0) NULL DEFAULT NULL COMMENT '角色id',
  `version` int(0) NULL DEFAULT 1 COMMENT '乐观锁',
  `deleted` int(0) NULL DEFAULT 0 COMMENT '逻辑删除',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `uid`(`uid`) USING BTREE,
  INDEX `rid`(`rid`) USING BTREE,
  CONSTRAINT `rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES (1, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `user_role` VALUES (3, 4, 2, 1, 0, NULL, NULL);
INSERT INTO `user_role` VALUES (4, 1, 2, 1, 1, NULL, NULL);
INSERT INTO `user_role` VALUES (5, 1, 1, 1, 1, NULL, NULL);
INSERT INTO `user_role` VALUES (6, 1, 1, 1, 1, '2020-07-27 08:48:47', '2020-07-27 08:48:47');
INSERT INTO `user_role` VALUES (7, 1, 2, 1, 1, '2020-07-27 08:48:47', '2020-07-27 08:48:47');
INSERT INTO `user_role` VALUES (8, 1, 1, 1, 1, '2020-07-27 08:48:59', '2020-07-27 08:48:59');
INSERT INTO `user_role` VALUES (9, 1, 1, 1, 1, '2020-07-27 08:49:22', '2020-07-27 08:49:22');
INSERT INTO `user_role` VALUES (10, 1, 2, 1, 1, '2020-07-27 08:49:22', '2020-07-27 08:49:22');
INSERT INTO `user_role` VALUES (11, 1, 1, 1, 1, '2020-07-27 08:49:56', '2020-07-27 08:49:56');
INSERT INTO `user_role` VALUES (12, 1, 1, 1, 1, '2020-07-27 09:15:21', '2020-07-27 09:15:21');
INSERT INTO `user_role` VALUES (13, 1, 2, 1, 1, '2020-07-27 09:15:21', '2020-07-27 09:15:21');
INSERT INTO `user_role` VALUES (14, 1, 1, 1, 1, '2020-07-27 09:15:29', '2020-07-27 09:15:29');
INSERT INTO `user_role` VALUES (15, 1, 1, 1, 1, '2020-07-27 09:20:21', '2020-07-27 09:20:21');
INSERT INTO `user_role` VALUES (16, 1, 2, 1, 1, '2020-07-27 09:20:21', '2020-07-27 09:20:21');
INSERT INTO `user_role` VALUES (17, 1, 1, 1, 0, '2020-07-27 09:20:32', '2020-07-27 09:20:32');
INSERT INTO `user_role` VALUES (18, 7, 3, 1, 0, '2020-07-27 09:41:30', '2020-07-27 09:41:30');

SET FOREIGN_KEY_CHECKS = 1;
