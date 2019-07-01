/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : xueshengguanli

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-01-14 15:07:34
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nam` varchar(100) CHARACTER SET utf8 NOT NULL,
  `sex` varchar(100) CHARACTER SET utf8 NOT NULL,
  `zhuanye` varchar(100) CHARACTER SET utf8 NOT NULL,
  `banji` varchar(100) CHARACTER SET utf8 NOT NULL,
  `xuehao` varchar(100) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '范秉洋', '男', '软件工程', '1703', '541713460307');
INSERT INTO `student` VALUES ('2', '程佩', '男', '软件工程', '1703', '541713460305');
INSERT INTO `student` VALUES ('3', '金东雨', '男', '软件工程', '1703', '541713460313');
INSERT INTO `student` VALUES ('4', '陈元', '男', '软件工程', '1703', '541713460304');
INSERT INTO `student` VALUES ('11', '大白', '男', '计算机', '1801', '123456');
INSERT INTO `student` VALUES ('12', '小红', '女', '经济管理', '1802', '123789');
