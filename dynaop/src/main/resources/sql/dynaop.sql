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

-- ----------------------------
-- Table structure for `t_menu`
-- ----------------------------
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE `t_menu` (
  `ID` varchar(64) NOT NULL COMMENT 'logic id',
  `MENU_ID` varchar(64) NOT NULL COMMENT 'menu''s id',
  `PARENT_ID` varchar(64) DEFAULT NULL COMMENT 'menu''s parent id',
  `MENU_NAME` varchar(40) DEFAULT NULL COMMENT 'menu''s name',
  `MENU_NAME_ZH` varchar(20) DEFAULT NULL COMMENT 'menu''s chinese name',
  `MENU_URI` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`ID`,`MENU_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='system''s menu';

-- ----------------------------
-- Records of t_menu
-- ----------------------------
INSERT INTO `t_menu` VALUES ('1', '01000', null, 'Task Management', '任务管理', null);
INSERT INTO `t_menu` VALUES ('10', '03001', '03000', 'User Infomation', '用户信息', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('11', '03002', '03000', 'Common Set', '通用设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('12', '03003', '03000', 'Task Set', '任务设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('13', '03004', '03000', 'Role Set', '角色设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('14', '03005', '03000', 'Team Set', '团队设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('2', '01001', '01000', 'Task List', '任务列表', '/mission/misList.action');
INSERT INTO `t_menu` VALUES ('3', '01002', '01000', 'Create Task', '创建任务', '/mission/turn2mission.action');
INSERT INTO `t_menu` VALUES ('4', '01003', '01000', 'Task Template', '任务模板', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('5', '02000', null, 'Team Management', '团队管理', null);
INSERT INTO `t_menu` VALUES ('6', '02001', '02000', 'Current Team List', '当前团队列表', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('7', '02002', '02000', 'All Team List', '所有团队列表', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('8', '02003', '02000', 'Team Management', '团队管理', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('9', '03000', null, 'User Center', '用户设置', null);

-- ----------------------------
-- Table structure for `t_mission_current`
-- ----------------------------
DROP TABLE IF EXISTS `t_mission_current`;
CREATE TABLE `t_mission_current` (
  `ID` varchar(64) NOT NULL COMMENT '自动配置',
  `MISSION_ID` varchar(64) NOT NULL COMMENT '任务ID',
  `CURR_STATE` tinyint(30) NOT NULL COMMENT '当前任务的状态',
  `CURR_EXECUTOR` varchar(64) NOT NULL COMMENT '当前任务执行者的ID',
  `CURR_TIME` datetime NOT NULL COMMENT '执行到当前处理状态的时间点',
  PRIMARY KEY (`ID`),
  KEY `miscur_1` (`MISSION_ID`) USING BTREE,
  CONSTRAINT `misinfo_ibfk_1` FOREIGN KEY (`MISSION_ID`) REFERENCES `t_mission_info` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务当前的执行状态';

-- ----------------------------
-- Table structure for `t_mission_grade`
-- ----------------------------
DROP TABLE IF EXISTS `t_mission_grade`;
CREATE TABLE `t_mission_grade` (
  `ID` varchar(64) NOT NULL COMMENT '自动配置',
  `MISSION_ID` varchar(64) NOT NULL COMMENT '任务ID',
  `FATHER_ID` varchar(64) NOT NULL COMMENT '任务的父ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务的父子等级表';

-- ----------------------------
-- Table structure for `t_mission_history`
-- ----------------------------
DROP TABLE IF EXISTS `t_mission_history`;
CREATE TABLE `t_mission_history` (
  `ID` varchar(64) NOT NULL COMMENT '自动ID，完全拷贝t_mission_current的ID',
  `MISSION_ID` varchar(64) NOT NULL COMMENT '任务ID',
  `MISSION_STATE` tinyint(30) NOT NULL COMMENT '当时的任务状态',
  `EXECUTOR` varchar(64) NOT NULL COMMENT '当时的任务执行人',
  `EXEC_TIME` datetime NOT NULL COMMENT '但是任务的执行更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='记录任务的执行过程表历史表';

-- ----------------------------
-- Table structure for `t_mission_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_mission_info`;
CREATE TABLE `t_mission_info` (
  `ID` varchar(100) NOT NULL COMMENT 'Mission''s id',
  `MISSION_NAME` varchar(100) NOT NULL COMMENT 'Mission''s name',
  `DESCR` varchar(500) DEFAULT NULL COMMENT 'Describe the misson',
  `PLAN_TIME` int(10) DEFAULT NULL COMMENT 'How long the mission task according to plan',
  `TIME_UNIT` tinyint(1) DEFAULT NULL COMMENT 'man day or man hour',
  `START_TIME` datetime NOT NULL COMMENT 'Misson start time',
  `END_TIME` datetime DEFAULT NULL COMMENT 'Mission end time',
  `MISSION_LEVEL` tinyint(2) NOT NULL COMMENT 'Misson level',
  `CREATOR` varchar(64) NOT NULL COMMENT 'Which user''s id create this mission.',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recording mission''s information';

-- ----------------------------
-- Table structure for `t_property`
-- ----------------------------
DROP TABLE IF EXISTS `t_property`;
CREATE TABLE `t_property` (
  `NAME_EN` varchar(30) NOT NULL,
  `STATES` varchar(30) NOT NULL,
  `NAME_ZH` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='初始化系统内部状态标识等属性';

-- ----------------------------
-- Records of t_property
-- ----------------------------
INSERT INTO `t_property` VALUES ('misson_level', '1', '轻');
INSERT INTO `t_property` VALUES ('misson_level', '2', '重');
INSERT INTO `t_property` VALUES ('misson_level', '3', '缓');
INSERT INTO `t_property` VALUES ('misson_level', '4', '急');
INSERT INTO `t_property` VALUES ('mission_state', '1', '创建');
INSERT INTO `t_property` VALUES ('mission_state', '2', '有效');
INSERT INTO `t_property` VALUES ('mission_state', '3', '无效');
INSERT INTO `t_property` VALUES ('mission_state', '4', '等待');
INSERT INTO `t_property` VALUES ('mission_state', '5', '完成');
INSERT INTO `t_property` VALUES ('time_unit', '1', '人天');
INSERT INTO `t_property` VALUES ('time_unit', '2', '人时');

-- ----------------------------
-- Table structure for `t_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
`id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`info`  tinytext CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL ,
`createtime`  datetime NOT NULL ,
PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='日志记录';