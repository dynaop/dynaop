/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50162
Source Host           : localhost:3306
Source Database       : dynaop

Target Server Type    : MYSQL
Target Server Version : 50162
File Encoding         : 65001

Date: 2014-01-19 23:08:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_login`
-- ----------------------------
DROP TABLE IF EXISTS `t_login`;
CREATE TABLE `t_login` (
  `ID` varchar(64) NOT NULL DEFAULT '' COMMENT 'key',
  `USERNAME` varchar(80) NOT NULL COMMENT '用户名',
  `PASSWORD` varchar(50) NOT NULL COMMENT '登陆密码',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_login
-- ----------------------------
INSERT INTO `t_login` VALUES ('1324567890', 'ivan', 'ivan');
INSERT INTO `t_login` VALUES ('6c2d68cb-75dd-4847-a39a-55025bb95b14', 'alice', 'alice');

-- ----------------------------
-- Table structure for `t_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `ID` varchar(64) NOT NULL DEFAULT '' COMMENT 'key',
  `LONGIN_ID` varchar(64) NOT NULL,
  `USERNAME` varchar(80) NOT NULL COMMENT '用户名称',
  `EMAIL` varchar(100) DEFAULT '' COMMENT 'Email address',
  `QQ` varchar(40) DEFAULT '' COMMENT 'QQ',
  `DEPT_ID` varchar(20) DEFAULT '' COMMENT '所在部门ID',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('888be5cc-30bf-4b10-81de-4ab61b161353', '6c2d68cb-75dd-4847-a39a-55025bb95b14', 'alice', '', '', null);
INSERT INTO `t_userinfo` VALUES ('dsfrtweer', '1324567890', 'ivanhuang', 'huangjianghua81@163.com', '', '');
