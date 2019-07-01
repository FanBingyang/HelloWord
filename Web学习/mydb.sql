/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : mydb

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-01-14 15:17:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `price` double(50,0) DEFAULT NULL,
  `pnum` int(50) DEFAULT NULL,
  `category` varchar(50) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(200) CHARACTER SET utf8 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', '轻量级JavaEE', '10', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('2', 'Java Web整合开发王者归来', '20', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('3', 'javaweb', '34', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('4', 'Javascript', '78', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('5', '深入浅出学java', '45', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('6', '数据结构（C++版）', '45', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('7', '高等数学', '56', '20', '不知道', '好书');
INSERT INTO `book` VALUES ('8', 'jsp从入门到放弃', '75', '20', '不知道', '好书');

-- ----------------------------
-- Table structure for emp
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `id` int(11) NOT NULL,
  `name` varchar(100) CHARACTER SET gbk DEFAULT NULL,
  `gender` varchar(10) CHARACTER SET utf8 DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `salsry` float(10,2) DEFAULT NULL,
  `entry_date` date DEFAULT NULL,
  `resume` text CHARACTER SET utf8,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('1', '1', '1', '2010-10-10', '1000.00', '2010-10-10', '111');
INSERT INTO `emp` VALUES ('2', '程佩', '2', '2017-09-01', '100.00', '2017-09-01', '222');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `username` varchar(255) CHARACTER SET utf8 NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 NOT NULL,
  `email` varchar(255) CHARACTER SET utf8 NOT NULL,
  `birthday` varchar(255) CHARACTER SET utf8 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('aaa', '111', '111', '2018-08-06');
INSERT INTO `users` VALUES ('tom', '123', 'aaa@163.com', '2018/10/10');

-- ----------------------------
-- Table structure for zhanghu
-- ----------------------------
DROP TABLE IF EXISTS `zhanghu`;
CREATE TABLE `zhanghu` (
  `name` varchar(255) CHARACTER SET utf8 NOT NULL,
  `money` double NOT NULL,
  `id` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of zhanghu
-- ----------------------------
INSERT INTO `zhanghu` VALUES ('aaa', '1000', '1');
INSERT INTO `zhanghu` VALUES ('bbb', '1100', '2');
INSERT INTO `zhanghu` VALUES ('ccc', '2000', '3');
