/*
Navicat MySQL Data Transfer

Source Server         : 本地_copy
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : pethospital

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-05-20 11:57:08
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for client
-- ----------------------------
DROP TABLE IF EXISTS `client`;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_name` varchar(50) DEFAULT NULL,
  `client_sex` varchar(50) DEFAULT NULL,
  `client_tel` varchar(50) DEFAULT NULL,
  `client_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='客户表';

-- ----------------------------
-- Records of client
-- ----------------------------
INSERT INTO `client` VALUES ('1', '金东雨', '男', '12345678911', '河南扶沟');

-- ----------------------------
-- Table structure for client_pet
-- ----------------------------
DROP TABLE IF EXISTS `client_pet`;
CREATE TABLE `client_pet` (
  `client_id` int(20) DEFAULT NULL,
  `pet_id` int(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of client_pet
-- ----------------------------

-- ----------------------------
-- Table structure for ill
-- ----------------------------
DROP TABLE IF EXISTS `ill`;
CREATE TABLE `ill` (
  `pet_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `pet_kind` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `client_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `vet_name` varchar(50) CHARACTER SET utf8 NOT NULL,
  `vet_major` varchar(50) CHARACTER SET utf8 NOT NULL,
  `illness` varchar(200) CHARACTER SET utf8 NOT NULL,
  `tim` varchar(50) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of ill
-- ----------------------------
INSERT INTO `ill` VALUES ('tom', '猫', '金东雨', '张三', '骨科', '右后腿骨折', '2019-5-17');

-- ----------------------------
-- Table structure for pet
-- ----------------------------
DROP TABLE IF EXISTS `pet`;
CREATE TABLE `pet` (
  `pet_id` int(11) NOT NULL AUTO_INCREMENT,
  `pet_name` varchar(50) DEFAULT NULL,
  `pet_kind` varchar(50) DEFAULT NULL,
  `pet_bir` varchar(50) DEFAULT NULL,
  `client_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`pet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='宠物表';

-- ----------------------------
-- Records of pet
-- ----------------------------
INSERT INTO `pet` VALUES ('1', 'tom', '猫', '2018-02-12', '1');
INSERT INTO `pet` VALUES ('2', 'jerry', '鼠', '2018-02-13', '1');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `user_address` varchar(50) DEFAULT NULL,
  `user_sex` varchar(20) DEFAULT NULL,
  `user_age` int(20) DEFAULT NULL,
  `user_tel` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='工作人员表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'fby', '000', '河南郑州', '男', '21', '12345678900');
INSERT INTO `user` VALUES ('2', 'xxx', '111', '河南', '男', '20', '11111111111');
INSERT INTO `user` VALUES ('3', 'xyz', '000', '河南', '女', '18', '222255555555');
INSERT INTO `user` VALUES ('4', '123', '000', '河南', '女', '20', '222222333333');
INSERT INTO `user` VALUES ('5', '567', '000', '河南', '男', '22', '3333333344');
INSERT INTO `user` VALUES ('6', 'lyx', '000', '河南', '男', '20', '9999999999');

-- ----------------------------
-- Table structure for vet
-- ----------------------------
DROP TABLE IF EXISTS `vet`;
CREATE TABLE `vet` (
  `vet_id` int(11) NOT NULL AUTO_INCREMENT,
  `vet_name` varchar(20) DEFAULT NULL,
  `vet_sex` varchar(20) DEFAULT NULL,
  `vet_age` varchar(20) DEFAULT NULL,
  `vet_tel` varchar(20) DEFAULT NULL,
  `vet_major` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`vet_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='医生表';

-- ----------------------------
-- Records of vet
-- ----------------------------
INSERT INTO `vet` VALUES ('1', '张三', '男', '30', '12345678910', '骨科');
INSERT INTO `vet` VALUES ('2', '小美', '女', '20', '12345678910', '护理');
