/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : luoyuluoyu

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2018-09-27 15:08:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for items
-- ----------------------------
DROP TABLE IF EXISTS `items`;
CREATE TABLE `items` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL COMMENT '商品名称',
  `price` float(10,1) NOT NULL COMMENT '商品定价',
  `detail` text COMMENT '商品描述',
  `pic` varchar(64) DEFAULT NULL COMMENT '商品图片',
  `createtime` datetime NOT NULL COMMENT '生产日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of items
-- ----------------------------
INSERT INTO `items` VALUES ('7', '32', '234.0', '娃哈哈', '9e9dbe58-ac4f-495f-9d4e-d50951f4c02d.jpg', '2018-09-25 14:09:00');
INSERT INTO `items` VALUES ('8', '43', '234.0', '娃哈哈', '294f1f46-d792-4ef3-a3e5-d75c2526acb8.jpg', '2018-09-05 14:09:00');
INSERT INTO `items` VALUES ('11', '32', '234.0', '娃哈哈', 'e1d9197d-e88c-49d3-9057-e298a64133ac.jpg', '2018-09-19 14:09:00');
