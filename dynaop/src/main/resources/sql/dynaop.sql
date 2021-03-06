/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50519
Source Host           : localhost:3306
Source Database       : taskrole

Target Server Type    : MYSQL
Target Server Version : 50519
File Encoding         : 65001

Date: 2014-04-01 13:20:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_info`;
CREATE TABLE `t_info` (
  `id` varchar(64) NOT NULL,
  `info` tinytext NOT NULL,
  `createtime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_info
-- ----------------------------

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
INSERT INTO `t_login` VALUES ('1', 'ivan', '1');

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
INSERT INTO `t_menu` VALUES ('10', '03001', '03000', 'User List', '用户列表', '/userinfo/turn2userlist.action');
INSERT INTO `t_menu` VALUES ('11', '03002', '03000', 'Common Set', '通用设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('12', '03003', '03000', 'Task Set', '任务设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('13', '03004', '03000', 'Role Set', '角色设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('14', '03005', '03000', 'Team Set', '团队设置', 'http://www.baidu.com');
INSERT INTO `t_menu` VALUES ('15', '04000', null, 'RoleSet', '角色设置', null);
INSERT INTO `t_menu` VALUES ('16', '04001', '04000', 'Create Role', '创建角色', '/role/turn2role.action');
INSERT INTO `t_menu` VALUES ('17', '04002', '04000', 'Role List', '角色列表', '/role/rolelist.action');
INSERT INTO `t_menu` VALUES ('18', '04003', '04000', 'Role Store', '角色库', '/role/trun2stroe.action');
INSERT INTO `t_menu` VALUES ('19', '05000', null, 'Organization', '组织机构管理', null);
INSERT INTO `t_menu` VALUES ('2', '01001', '01000', 'Task List', '任务列表', '/mission/mislist.action');
INSERT INTO `t_menu` VALUES ('20', '05001', '05000', 'Create Organization', '创建组织架构', '/organize/turn2org.action');
INSERT INTO `t_menu` VALUES ('21', '05002', '05000', 'Organization List', '组织机构列表', '/organize/orglist.action');
INSERT INTO `t_menu` VALUES ('22', '04004', '04000', 'set default role', '设置默认角色', '/role/turn2roleset.action');
INSERT INTO `t_menu` VALUES ('23', '06000', null, 'Permission Manage', '权限管理', null);
INSERT INTO `t_menu` VALUES ('24', '06001', '06000', 'Create Permission', '创建权限', '/permission/turn2per.action');
INSERT INTO `t_menu` VALUES ('25', '06002', '06000', 'Permission List', '权限列表', '/permission/perlist.action');
INSERT INTO `t_menu` VALUES ('26', '01004', '01000', 'priority set', '任务优先级设置', '/mission/turn2priority.action');
INSERT INTO `t_menu` VALUES ('27', '01005', '01000', 'priority list', '任务优先级列表', '/mission/prilist.action');
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
  `CREATOR` varchar(64) NOT NULL COMMENT '创建者的ID',
  PRIMARY KEY (`ID`),
  KEY `miscur_1` (`MISSION_ID`) USING BTREE,
  CONSTRAINT `misinfo_ibfk_1` FOREIGN KEY (`MISSION_ID`) REFERENCES `t_mission_info` (`ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='任务当前的执行状态';

-- ----------------------------
-- Records of t_mission_current
-- ----------------------------
INSERT INTO `t_mission_current` VALUES ('03371ee5-31bc-4e6f-9e74-6f80f6aac3f2', '4613613b-47da-4199-8309-81eb083ba34d', '1', '(瀹屾垚鐢ㄦ埛鐨勮鑹蹭互鍙婃潈闄愬悗琛ュ厖瀹屾暣)', '2014-02-23 22:30:34', '');
INSERT INTO `t_mission_current` VALUES ('07de50f1-e699-40ae-8e22-a075ade0361d', '42bc3a87-4665-427f-b2b8-43c10fd839c8', '1', 'aa85622b-1ebb-4ec3-ba9d-93eaa7b35cf0', '2014-04-01 12:58:42', 'ivan');
INSERT INTO `t_mission_current` VALUES ('20c4af47-15a4-4a53-a89b-620cf1b9a269', '52bd77ee-5737-435c-8bf9-f6752805b584', '1', 'ivan', '2014-02-23 17:38:49', '');
INSERT INTO `t_mission_current` VALUES ('64fa6783-bfb2-4c3d-9bbb-ad7e68f9268f', 'd12f0695-699c-45b2-8863-08413b4af74d', '1', '(完成用户的角色以及权限后补充完整)', '2014-03-06 11:05:14', '');
INSERT INTO `t_mission_current` VALUES ('77129ecb-4886-45c3-a796-ae63922d70a1', '55952efa-2b6f-433c-9f8a-c5039ca52a92', '1', '(完成用户的角色以及权限后补充完整)', '2014-02-23 22:27:39', '');
INSERT INTO `t_mission_current` VALUES ('8c9216f6-5768-4aa6-a131-5fa7793570be', '30b7a405-5bc8-4892-aea5-607a9397098c', '1', '1', '2014-03-31 19:59:49', 'ivan');
INSERT INTO `t_mission_current` VALUES ('955a9d7b-fd7c-4129-b2af-2da8b88d0006', '7831331b-06bc-4095-b9a5-484aa5ef3044', '1', 'aliceliu', '2014-02-23 17:58:52', '');
INSERT INTO `t_mission_current` VALUES ('9f310bc8-1985-4ff3-b19d-4adbf4d71659', '8e772236-2822-4557-bce8-7fc476905dea', '1', 'ivan', '2014-02-23 17:56:36', '');
INSERT INTO `t_mission_current` VALUES ('a6529bea-79f5-4158-a632-4c02a7fe6ee8', '1aad59ae-cf77-4a9c-87d2-c66f41b4bbae', '1', '(完成用户的角色以及权限后补充完整)', '2014-02-23 22:22:20', '');
INSERT INTO `t_mission_current` VALUES ('aa118406-1476-4e65-8f81-e08ad829694f', '1bd2c123-2a8c-4976-8fb3-8cfd22498ad9', '1', '(完成用户的角色以及权限后补充完整)', '2014-02-23 22:42:23', '');
INSERT INTO `t_mission_current` VALUES ('aad38569-46a1-40ed-8837-9971ebe380dd', '03ff8a1f-c9ef-4a6b-87f9-dbcf9c1b1f7f', '1', '(完成用户的角色以及权限后补充完整)', '2014-02-23 22:26:44', '');
INSERT INTO `t_mission_current` VALUES ('bbb7d89b-30b4-457d-8598-ee8a83e17f78', '277004a5-19c1-43a2-bc28-8beb1b9453a7', '1', '', '2014-03-03 22:31:50', '');
INSERT INTO `t_mission_current` VALUES ('d136a780-efb6-476d-8fb6-df2c92010794', 'a1d339e4-bb58-4754-9839-bcd727b6164e', '1', '(完成用户的角色以及权限后补充完整)', '2014-02-23 22:33:16', '');
INSERT INTO `t_mission_current` VALUES ('e712b466-78a6-41e7-9b9f-2708afd3616d', '71bdc82f-3f07-4356-b044-26f9bdf76ee4', '1', '(瀹屾垚鐢ㄦ埛鐨勮鑹蹭互鍙婃潈闄愬悗琛ュ厖瀹屾暣)', '2014-02-23 22:31:28', '');
INSERT INTO `t_mission_current` VALUES ('e95ec115-0c80-4d28-8cf3-487b30e47c5b', '1e75a55b-9223-47cc-bf2c-a2527f2ed114', '1', 'ivan', '2014-02-23 17:55:34', '');

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
-- Records of t_mission_grade
-- ----------------------------

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
-- Records of t_mission_history
-- ----------------------------

-- ----------------------------
-- Table structure for `t_mission_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_mission_info`;
CREATE TABLE `t_mission_info` (
  `ID` varchar(100) NOT NULL DEFAULT 'null' COMMENT 'Mission''s id',
  `MISSION_NAME` varchar(100) NOT NULL COMMENT 'Mission''s name',
  `DESCR` varchar(500) DEFAULT NULL COMMENT 'Describe the misson',
  `PLAN_TIME` int(20) DEFAULT NULL COMMENT 'How long the mission task according to plan',
  `TIME_UNIT` tinyint(1) DEFAULT NULL COMMENT 'man day or man hour',
  `START_TIME` datetime NOT NULL COMMENT 'Misson start time',
  `END_TIME` datetime DEFAULT NULL COMMENT 'Mission end time',
  `MISSION_PRIORITY` varchar(64) NOT NULL COMMENT 'Misson Priority',
  `CREATOR` varchar(64) NOT NULL COMMENT 'Which user''s id create this mission.',
  `PRE_MISSION` varchar(64) DEFAULT NULL COMMENT '前置任务',
  `REAL_START_TIME` datetime NOT NULL,
  `REAL_PLAN_TIME` int(20) DEFAULT NULL,
  `EST_COM_PER` varchar(10) DEFAULT NULL COMMENT 'Estimated completion percentage 估计完成比例',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='Recording mission''s information';

-- ----------------------------
-- Records of t_mission_info
-- ----------------------------
INSERT INTO `t_mission_info` VALUES ('03ff8a1f-c9ef-4a6b-87f9-dbcf9c1b1f7f', 'aa12', null, '4', '1', '2013-08-10 00:00:00', '2014-07-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('1aad59ae-cf77-4a9c-87d2-c66f41b4bbae', 'aa1', null, '4', '1', '2014-07-02 00:00:00', '2014-07-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('1bd2c123-2a8c-4976-8fb3-8cfd22498ad9', 'aa24', null, '4', '1', '2014-07-02 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('1e75a55b-9223-47cc-bf2c-a2527f2ed114', 'aa', null, '3', '1', '2013-08-10 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('277004a5-19c1-43a2-bc28-8beb1b9453a7', '韩国人凤飞飞v', '是否过几天', '3', '2', '2014-03-04 00:00:00', '2014-03-04 00:00:00', '2', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('30b7a405-5bc8-4892-aea5-607a9397098c', '收到122', 'ASDF', '3', '1', '2014-03-01 00:00:00', null, '8f50d276-1127-4126-b277-e7988f508318', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('42bc3a87-4665-427f-b2b8-43c10fd839c8', '收到3', '收到3', '20', '2', '2014-04-03 00:00:00', null, 'd9151ef6-2ad6-4f27-9379-30bf2430c3b8', 'ivan', null, '2014-04-03 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('4613613b-47da-4199-8309-81eb083ba34d', 'aa13', null, '4', '1', '2013-08-12 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('52bd77ee-5737-435c-8bf9-f6752805b584', 'aa', null, '3', '1', '2013-08-10 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('55952efa-2b6f-433c-9f8a-c5039ca52a92', 'aa2', null, '4', '1', '2013-08-10 00:00:00', '2014-07-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('6df32655-8436-4443-b5d3-457b845b6bdd', '任务1', '吃t1', '3', '1', '2014-02-26 00:00:00', null, '8f50d276-1127-4126-b277-e7988f508318', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('71bdc82f-3f07-4356-b044-26f9bdf76ee4', 'aa21', null, '3', '1', '2013-08-10 00:00:00', '2014-07-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('7831331b-06bc-4095-b9a5-484aa5ef3044', 'aa', null, '3', '1', '2013-08-11 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('8e772236-2822-4557-bce8-7fc476905dea', 'aa', null, '3', '1', '2013-08-10 00:00:00', '2013-09-10 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('a1d339e4-bb58-4754-9839-bcd727b6164e', 'aa22', null, '4', '1', '2014-07-02 00:00:00', '2014-07-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);
INSERT INTO `t_mission_info` VALUES ('d12f0695-699c-45b2-8863-08413b4af74d', '收到1', '', '3', '1', '2014-03-04 00:00:00', '2014-03-06 00:00:00', '1', 'ivan', null, '0000-00-00 00:00:00', null, null);

-- ----------------------------
-- Table structure for `t_miss_priority`
-- ----------------------------
DROP TABLE IF EXISTS `t_miss_priority`;
CREATE TABLE `t_miss_priority` (
  `ID` varchar(64) NOT NULL,
  `MIS_PRIORITY_NAME` varchar(100) NOT NULL COMMENT '任务优先级名称',
  `MIS_PRIORITY_DESC` varchar(200) DEFAULT NULL COMMENT '描述',
  `CREATE_TIME` datetime NOT NULL COMMENT '创建时间，系统自动记录',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_miss_priority
-- ----------------------------
INSERT INTO `t_miss_priority` VALUES ('5517132a-6599-496f-bd12-58e4385fd286', '优先级2', '优先级2·2', '2014-03-31 16:44:37');
INSERT INTO `t_miss_priority` VALUES ('8f50d276-1127-4126-b277-e7988f508318', '优先级4', '优先级4·42', '2014-04-01 13:07:09');
INSERT INTO `t_miss_priority` VALUES ('a4b3a966-c262-43a0-be70-ed44c87b4f43', '优先级5', '重要优先级', '2014-04-01 13:06:48');
INSERT INTO `t_miss_priority` VALUES ('d9151ef6-2ad6-4f27-9379-30bf2430c3b8', '优先级1', '优先级1··1', '2014-03-31 16:43:19');
INSERT INTO `t_miss_priority` VALUES ('eeeb88c3-2d0b-4cd0-a55c-d1677cb117eb', '优先级3', '优先级3·3', '2014-03-31 17:43:08');

-- ----------------------------
-- Table structure for `t_org_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_org_info`;
CREATE TABLE `t_org_info` (
  `ORG_ID` varchar(64) NOT NULL COMMENT '组织架构ID',
  `ORG_FULL_NAME` varchar(100) DEFAULT NULL COMMENT '组织架构的中文全称',
  `ORG_PARENT_ID` varchar(64) DEFAULT NULL COMMENT '组织架构中文简称',
  `ORG_CODE` varchar(20) DEFAULT NULL COMMENT '组织架构的英文简称',
  `ORG_DESC` varchar(500) DEFAULT NULL COMMENT '组织架构的描述',
  PRIMARY KEY (`ORG_ID`),
  KEY `ORG_ID` (`ORG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构信息表';

-- ----------------------------
-- Records of t_org_info
-- ----------------------------
INSERT INTO `t_org_info` VALUES ('o1', '1', null, null, null);
INSERT INTO `t_org_info` VALUES ('o2', '2', 'o1', null, null);
INSERT INTO `t_org_info` VALUES ('o3', '3', 'o1', null, null);
INSERT INTO `t_org_info` VALUES ('o4', '4', 'o3', null, null);

-- ----------------------------
-- Table structure for `t_per_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_per_info`;
CREATE TABLE `t_per_info` (
  `PER_ID` varchar(64) NOT NULL COMMENT '权限ID',
  `PER_NAME` varchar(100) NOT NULL COMMENT '权限名称',
  `PER_DESC` varchar(256) DEFAULT NULL COMMENT '权限描述',
  `MENU_IDS` varchar(256) NOT NULL COMMENT '菜单IDs  以英文逗号分隔',
  PRIMARY KEY (`PER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_per_info
-- ----------------------------
INSERT INTO `t_per_info` VALUES ('1', '2123', '1342123', '01001, 01002');
INSERT INTO `t_per_info` VALUES ('a0cb2e3f-f1c2-4fbe-abb0-a9a26e8555bb', 'qwerty发阿斯顿111', 'asdfsae1', '01001, 01003, 02001, 02002');
INSERT INTO `t_per_info` VALUES ('d1c123ff-80d9-49f7-987b-6cc2df4ae851', '权限1', '权限描述1', '02001');

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
INSERT INTO `t_property` VALUES ('default_role', '', '默认角色');

-- ----------------------------
-- Table structure for `t_rel_org_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_rel_org_role`;
CREATE TABLE `t_rel_org_role` (
  `ID` varchar(64) NOT NULL COMMENT '关系表ID',
  `ORG_ID` varchar(64) NOT NULL COMMENT '组织架构ID',
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色的ID',
  PRIMARY KEY (`ID`),
  KEY `org_role_rel_ind1` (`ORG_ID`) USING BTREE,
  KEY `org_role_rel_ind2` (`ROLE_ID`) USING HASH,
  CONSTRAINT `org_fk` FOREIGN KEY (`ORG_ID`) REFERENCES `t_org_info` (`ORG_ID`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `role_fk` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_role_info` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='组织架构与角色的关系表';

-- ----------------------------
-- Records of t_rel_org_role
-- ----------------------------
INSERT INTO `t_rel_org_role` VALUES ('r1', 'o2', '2');
INSERT INTO `t_rel_org_role` VALUES ('r2', 'o4', '3');

-- ----------------------------
-- Table structure for `t_rel_per_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_rel_per_role`;
CREATE TABLE `t_rel_per_role` (
  `REL_ID` varchar(64) NOT NULL,
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色ID',
  `PER_ID` varchar(64) NOT NULL COMMENT '权限IDS,以英文逗号分隔',
  PRIMARY KEY (`REL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_rel_per_role
-- ----------------------------
INSERT INTO `t_rel_per_role` VALUES ('1c211877-b52b-40d2-8f09-e4c59c4cb7c2', '9', 'd1c123ff-80d9-49f7-987b-6cc2df4ae851');
INSERT INTO `t_rel_per_role` VALUES ('2d0fd53c-fbf1-432c-9853-b42018fd228a', '9', 'a0cb2e3f-f1c2-4fbe-abb0-a9a26e8555bb');
INSERT INTO `t_rel_per_role` VALUES ('35250aea-20ad-41ca-a1f2-d627a90ca64f', 'aa85622b-1ebb-4ec3-ba9d-93eaa7b35cf0', ' a0cb2e3f-f1c2-4fbe-abb0-a9a26e8555bb');
INSERT INTO `t_rel_per_role` VALUES ('af146816-10bd-4b99-9f08-057680f0321b', 'aa85622b-1ebb-4ec3-ba9d-93eaa7b35cf0', '1');
INSERT INTO `t_rel_per_role` VALUES ('d2223f81-d715-43f3-9a76-c71d20f41739', 'aa85622b-1ebb-4ec3-ba9d-93eaa7b35cf0', ' d1c123ff-80d9-49f7-987b-6cc2df4ae851');
INSERT INTO `t_rel_per_role` VALUES ('e7917956-bd72-49ee-b000-39dfc5a6b44c', '9', '1');

-- ----------------------------
-- Table structure for `t_rel_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_rel_user_role`;
CREATE TABLE `t_rel_user_role` (
  `ID` varchar(64) NOT NULL COMMENT '表ID',
  `USER_ID` varchar(64) NOT NULL COMMENT '用户ID',
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`ID`),
  KEY `role_user_fk` (`ROLE_ID`),
  KEY `user_ind` (`USER_ID`) USING HASH,
  CONSTRAINT `role_user_fk` FOREIGN KEY (`ROLE_ID`) REFERENCES `t_role_info` (`ROLE_ID`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';

-- ----------------------------
-- Records of t_rel_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `t_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_info`;
CREATE TABLE `t_role_info` (
  `ROLE_ID` varchar(64) NOT NULL COMMENT '角色ID',
  `ROLE_NAME` varchar(50) NOT NULL COMMENT '角色中文名',
  `ROLE_DESC` varchar(100) DEFAULT NULL COMMENT '角色备注描述',
  `ROLE_VAL` varchar(1) NOT NULL DEFAULT '1' COMMENT '角色是否有效标志位，默认1为有效,0无效',
  PRIMARY KEY (`ROLE_ID`),
  KEY `ROLE_ID` (`ROLE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='角色基本信息表';

-- ----------------------------
-- Records of t_role_info
-- ----------------------------
INSERT INTO `t_role_info` VALUES ('0', '新进员工1', '员工默认角色1', '0');
INSERT INTO `t_role_info` VALUES ('1', '1', null, '1');
INSERT INTO `t_role_info` VALUES ('10', '10', null, '1');
INSERT INTO `t_role_info` VALUES ('11', '11', null, '1');
INSERT INTO `t_role_info` VALUES ('12', '12', null, '1');
INSERT INTO `t_role_info` VALUES ('13', '13', '13', '1');
INSERT INTO `t_role_info` VALUES ('14', '14', '14', '1');
INSERT INTO `t_role_info` VALUES ('15', '15', null, '1');
INSERT INTO `t_role_info` VALUES ('2', '2', '2', '1');
INSERT INTO `t_role_info` VALUES ('3', '3', null, '1');
INSERT INTO `t_role_info` VALUES ('4', '4', '4', '1');
INSERT INTO `t_role_info` VALUES ('5', '5-3', '5-1', '1');
INSERT INTO `t_role_info` VALUES ('6', '6', null, '1');
INSERT INTO `t_role_info` VALUES ('7', '7', null, '1');
INSERT INTO `t_role_info` VALUES ('8', '8', null, '1');
INSERT INTO `t_role_info` VALUES ('9', '9', null, '1');
INSERT INTO `t_role_info` VALUES ('aa85622b-1ebb-4ec3-ba9d-93eaa7b35cf0', '角色11', '角色12', '1');

-- ----------------------------
-- Table structure for `t_userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `t_userinfo`;
CREATE TABLE `t_userinfo` (
  `ID` varchar(64) NOT NULL DEFAULT '' COMMENT 'key',
  `LONGIN_ID` varchar(64) NOT NULL,
  `USERNAME` varchar(80) NOT NULL COMMENT 'user name',
  `EMAIL` varchar(100) DEFAULT '' COMMENT 'Email address',
  `QQ` varchar(40) DEFAULT '' COMMENT 'QQ',
  `DEPT_ID` varchar(20) DEFAULT '',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_userinfo
-- ----------------------------
INSERT INTO `t_userinfo` VALUES ('1', '1', 'ivan', '11huangjianghua81@163.com', '111', '');
