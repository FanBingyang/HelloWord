/*
Navicat MySQL Data Transfer

Source Server         : 本地
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : qqchat

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2019-01-14 15:10:04
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for friend_list
-- ----------------------------
DROP TABLE IF EXISTS `friend_list`;
CREATE TABLE `friend_list` (
  `name` varchar(100) NOT NULL,
  `friendname` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of friend_list
-- ----------------------------
INSERT INTO `friend_list` VALUES ('路人甲', '2222');
INSERT INTO `friend_list` VALUES ('2222', '路人甲');
INSERT INTO `friend_list` VALUES ('范秉洋', '路人甲');
INSERT INTO `friend_list` VALUES ('路人甲', '范秉洋');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `sex` varchar(100) NOT NULL,
  `age` varchar(3) NOT NULL,
  `qianming` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('102400', '范秉洋', '111', '男', '12', '啦啦啦');
INSERT INTO `user` VALUES ('102401', '路人甲', '111', '男', '14', '嗯哼');
INSERT INTO `user` VALUES ('102485', '111', '1', '男', '1', '啦啦啦');
INSERT INTO `user` VALUES ('102453', '11', '11', '男', '11', '11');
INSERT INTO `user` VALUES ('102418', '2222', '111', '男', '12', 'aaaaaaa');
