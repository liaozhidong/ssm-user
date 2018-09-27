/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : luoyuluoyu

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-09-27 15:09:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) DEFAULT NULL COMMENT '用户名称',
  `password` varchar(32) DEFAULT NULL COMMENT '密码',
  `birthday` datetime DEFAULT NULL COMMENT '生日',
  `sex` char(1) DEFAULT NULL COMMENT '性别',
  `address` varchar(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('27', 'admin', 'admin', '2018-09-15 00:00:00', '1', '河南郑州');
INSERT INTO `user` VALUES ('28', 'zuidaima', '111111', '2018-09-15 00:00:00', '1', 'zuidaima@qq.com');
INSERT INTO `user` VALUES ('76', 'jitamin ', '123', '2018-09-21 11:09:00', '1', '广州');
INSERT INTO `user` VALUES ('77', 'admin@qq.com', '123', '2018-09-21 11:09:00', '1', '广州');
