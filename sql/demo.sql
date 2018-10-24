-- ----------------------------
-- Table structure for rdm_employee
-- ----------------------------
DROP TABLE IF EXISTS `rdm_employee`;
CREATE TABLE `rdm_employee` (
  `employee_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '员工ID',
  `dept_id` int(11) NOT NULL COMMENT '部门ID',
  `empno` varchar(10) NOT NULL COMMENT '工号',
  `name` varchar(30) NOT NULL COMMENT '姓名',
  `sex` char(1) DEFAULT '0' COMMENT '性别',
  `email` varchar(50) DEFAULT '' COMMENT '邮箱',
  `phone` varchar(11) DEFAULT '' COMMENT '手机号码',
  `birthdate` date DEFAULT NULL COMMENT '出生日期',
  `birthplace` varchar(20) DEFAULT NULL COMMENT '籍贯',
  `graduate_date` date DEFAULT NULL COMMENT '毕业日期',
  `school` varchar(50) DEFAULT NULL COMMENT '毕业院校',
  `major` varchar(50) DEFAULT NULL COMMENT '专业',
  `education` char(1) DEFAULT NULL COMMENT '学历',
  `grade` char(1) DEFAULT NULL COMMENT '水平等级',
  `hiredate` date DEFAULT NULL COMMENT '入职日期',
  `formaldate` date DEFAULT NULL COMMENT '转正日期',
  `location` char(1) DEFAULT NULL COMMENT '办公地点',
  `leftdate` date DEFAULT NULL COMMENT '离职日期',
  `status` char(1) DEFAULT '0' COMMENT '状态',
  `create_by` varchar(64) DEFAULT '' COMMENT '创建者',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_by` varchar(64) DEFAULT '' COMMENT '更新者',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `remark` varchar(500) DEFAULT '' COMMENT '备注',
  PRIMARY KEY (`employee_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='员工信息表';

-- ----------------------------
-- Table structure for rdm_employee_salary
-- ----------------------------
DROP TABLE IF EXISTS `rdm_employee_salary`;
CREATE TABLE `rdm_employee_salary` (
  `salary_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '薪酬ID',
  `employee_id` int(11) NOT NULL COMMENT '员工ID',
  `monthly` int(11) DEFAULT NULL COMMENT '月薪',
  `point` tinyint(4) DEFAULT NULL COMMENT '薪数',
  `yearly` int(11) DEFAULT NULL COMMENT '年薪',
  `welfare` varchar(20) DEFAULT NULL COMMENT '福利',
  `effective_date` date DEFAULT NULL COMMENT '生效日期',
  `status` char(1) DEFAULT '0' COMMENT '状态',
  PRIMARY KEY (`salary_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='薪酬变动表';

-- ----------------------------
-- Records of sys_dict_type, sys_dict_data
-- ----------------------------
INSERT INTO `sys_dict_type` VALUES (100, '员工状态', 'rdm_employee_status', '0', 'admin', '2018-08-24 12:16:15', 'admin', '2018-09-01 17:22:19', '员工状态列表');
INSERT INTO `sys_dict_type` VALUES (101, '办公场所', 'rdm_employee_location', '0', 'admin', '2018-08-24 17:30:28', 'admin', '2018-09-01 17:22:26', '办公场所列表');
INSERT INTO `sys_dict_type` VALUES (102, '水平等级', 'rdm_employee_grade', '0', 'admin', '2018-08-24 17:48:42', 'admin', '2018-09-16 13:32:35', '技能水平等级');
INSERT INTO `sys_dict_type` VALUES (103, '员工时间类别', 'rdm_employee_time_type', '0', 'admin', '2018-09-01 22:30:14', 'admin', '2018-09-01 22:56:31', '');
INSERT INTO `sys_dict_type` VALUES (104, '学历', 'rdm_employee_education', '0', 'admin', '2018-09-01 22:44:58', '', NULL, '');

INSERT INTO `sys_dict_data` VALUES (100, 1, '正式', '0', 'rdm_employee_status', '', 'primary', 'N', '0', 'admin', '2018-08-24 12:19:52', 'admin', '2018-09-07 23:55:12', '正式员工');
INSERT INTO `sys_dict_data` VALUES (101, 2, '试用', '1', 'rdm_employee_status', '', 'warning', 'Y', '0', 'admin', '2018-08-24 14:13:45', 'admin', '2018-09-07 23:56:44', '试用员工');
INSERT INTO `sys_dict_data` VALUES (102, 3, '实习', '2', 'rdm_employee_status', '', 'white', 'Y', '0', 'admin', '2018-08-24 14:14:11', 'admin', '2018-09-07 23:57:09', '实习员工');
INSERT INTO `sys_dict_data` VALUES (103, 4, '离职', '3', 'rdm_employee_status', '', 'danger', 'Y', '0', 'admin', '2018-08-24 16:14:13', 'admin', '2018-09-07 23:56:38', '离职员工');
INSERT INTO `sys_dict_data` VALUES (104, 1, '福州总部', '0', 'rdm_employee_location', '', '', 'Y', '0', 'admin', '2018-08-24 17:31:04', '', NULL, '福州总部');
INSERT INTO `sys_dict_data` VALUES (105, 2, '杭州分部', '1', 'rdm_employee_location', '', '', 'Y', '0', 'admin', '2018-08-24 17:31:35', '', NULL, '杭州分部');
INSERT INTO `sys_dict_data` VALUES (106, 3, '上海分部', '2', 'rdm_employee_location', '', '', 'Y', '0', 'admin', '2018-08-24 17:31:50', '', NULL, '杭州分部');
INSERT INTO `sys_dict_data` VALUES (107, 4, '广州分部', '3', 'rdm_employee_location', '', '', 'Y', '0', 'admin', '2018-08-24 17:32:09', '', NULL, '广州分部');
INSERT INTO `sys_dict_data` VALUES (108, 1, '初级', '0', 'rdm_employee_grade', '', '', 'Y', '0', 'admin', '2018-08-24 17:59:44', '', NULL, '初级');
INSERT INTO `sys_dict_data` VALUES (109, 2, '中级', '1', 'rdm_employee_grade', '', '', 'Y', '0', 'admin', '2018-08-24 17:59:54', '', NULL, '中级');
INSERT INTO `sys_dict_data` VALUES (110, 3, '高级', '2', 'rdm_employee_grade', '', '', 'Y', '0', 'admin', '2018-08-24 18:00:04', '', NULL, '高级');
INSERT INTO `sys_dict_data` VALUES (111, 4, '专家', '3', 'rdm_employee_grade', '', '', 'Y', '0', 'admin', '2018-08-24 18:00:24', '', NULL, '专家');
INSERT INTO `sys_dict_data` VALUES (112, 1, '出生日期', '0', 'rdm_employee_time_type', '', '', 'Y', '0', 'admin', '2018-09-01 22:31:04', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (113, 2, '毕业日期', '1', 'rdm_employee_time_type', '', '', 'Y', '0', 'admin', '2018-09-01 22:32:17', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (114, 3, '入职日期', '2', 'rdm_employee_time_type', '', '', 'Y', '0', 'admin', '2018-09-01 22:32:35', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (115, 4, '转正日期', '3', 'rdm_employee_time_type', '', '', 'Y', '0', 'admin', '2018-09-01 22:32:54', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (116, 5, '离职日期', '4', 'rdm_employee_time_type', '', '', 'Y', '0', 'admin', '2018-09-01 22:33:13', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (117, 1, '本科', '0', 'rdm_employee_education', '', '', 'Y', '0', 'admin', '2018-09-01 22:45:39', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (118, 2, '硕士', '1', 'rdm_employee_education', '', '', 'Y', '0', 'admin', '2018-09-01 22:45:53', '', NULL, '');
INSERT INTO `sys_dict_data` VALUES (119, 3, '博士', '2', 'rdm_employee_education', '', '', 'Y', '0', 'admin', '2018-09-01 22:46:02', 'admin', '2018-09-01 22:46:12', '');
INSERT INTO `sys_dict_data` VALUES (120, 4, '专科', '3', 'rdm_employee_education', '', '', 'Y', '0', 'admin', '2018-09-01 22:46:22', '', NULL, '');

INSERT INTO `sys_menu` VALUES (2000, '人力资源', 0, 0, '', 'M', '0', '', 'fa fa-users', 'admin', '2018-09-01 15:14:21', 'admin', '2018-09-07 22:30:27', '');
INSERT INTO `sys_menu` VALUES (2001, '员工管理', 2000, 1, '/demo/employee', 'C', '0', 'demo:employee:view', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '员工菜单');
INSERT INTO `sys_menu` VALUES (2002, '员工查询', 2001, 1, '#', 'F', '0', 'demo:employee:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2003, '员工新增', 2001, 2, '#', 'F', '0', 'demo:employee:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2004, '员工修改', 2001, 3, '#', 'F', '0', 'demo:employee:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2005, '员工删除', 2001, 4, '#', 'F', '0', 'demo:employee:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2006, '员工导出', 2001, 4, '#', 'F', '0', 'demo:employee:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2007, '员工薪酬', 2000, 2, '/demo/employee/salary', 'C', '0', 'demo:salary:view', '#', 'admin', '2018-03-01 00:00:00', 'admin', '2018-09-08 10:49:47', '薪酬菜单');
INSERT INTO `sys_menu` VALUES (2008, '薪酬查询', 2007, 1, '#', 'F', '0', 'demo:salary:list', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2009, '薪酬新增', 2007, 2, '#', 'F', '0', 'demo:salary:add', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2010, '薪酬修改', 2007, 3, '#', 'F', '0', 'demo:salary:edit', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
INSERT INTO `sys_menu` VALUES (2011, '薪酬删除', 2007, 4, '#', 'F', '0', 'demo:salary:remove', '#', 'admin', '2018-03-01 00:00:00', 'ry', '2018-03-01 00:00:00', '');
