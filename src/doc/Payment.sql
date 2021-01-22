/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.2.236_3306
 Source Server Type    : MariaDB
 Source Server Version : 50568
 Source Host           : 192.168.2.236:3306
 Source Schema         : Payment

 Target Server Type    : MariaDB
 Target Server Version : 50568
 File Encoding         : 65001

 Date: 22/01/2021 18:58:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `admin_id` int(11) NOT NULL AUTO_INCREMENT,
  `admin_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `admin_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `admin_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码  md5密文',
  `admin_status` tinyint(1) NOT NULL COMMENT '账号状态  1=开启 0=禁用',
  `admin_type` tinyint(1) NOT NULL COMMENT '账号类型  1=超管  2=普通管理  3-客服？？',
  `admin_white_ip` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip白名单,多个IP用;隔开,最多4个, 为空则不限制',
  `admin_daily_max_login_fail_count` int(11) NOT NULL COMMENT '管理员当日登录失败总次数  超过阀值即禁用该账号',
  `admin_daily_login_fail_count` int(11) NOT NULL COMMENT '管理员当日登录失败次数  (写脚本每天 0时0分0秒 重置该值)',
  `admin_max_confirm_withdraw_count` int(11) NOT NULL COMMENT '管理员每日能通过的最大代理提现次数',
  `admin_max_confirm_withdraw_amount` decimal(65, 2) NOT NULL COMMENT '管理员能通过的代理最大提现金额',
  `admin_create_time` int(11) NOT NULL COMMENT '创建时间',
  `admin_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n管理员表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log`  (
  `admin_log_id` bigint(20) NOT NULL,
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `admin_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名称',
  `admin_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员昵称',
  `admin_type` tinyint(1) NOT NULL COMMENT '账号类型  1-超管  2-普通  3-客服？？',
  `admin_log_operate_method` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '操作动作',
  `admin_log_operate_time` int(11) NOT NULL COMMENT '操作时间',
  `admin_log_operate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '具体干了什么',
  `admin_log_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`admin_log_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n管理员操作日志表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_log
-- ----------------------------

-- ----------------------------
-- Table structure for admin_login_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_login_log`;
CREATE TABLE `admin_login_log`  (
  `admin_login_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
  `admin_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员名称',
  `admin_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员昵称',
  `admin_type` tinyint(1) NOT NULL COMMENT '账号类型  1-超管  2-普通  3-客服？？',
  `admin_login_log_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
  `admin_login_log_time` int(11) NOT NULL COMMENT '登陆时间',
  `admin_login_log_status` tinyint(1) NOT NULL COMMENT '登录状态 1=成功 0=失败',
  `admin_login_log_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码  md5密文',
  PRIMARY KEY (`admin_login_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n管理员登录日志表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for agent
-- ----------------------------
DROP TABLE IF EXISTS `agent`;
CREATE TABLE `agent`  (
  `agent_id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `agent_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账号',
  `agent_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码  md5 密文',
  `agent_withdraw_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现密码  md5 密文',
  `agent_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '状态  1=启用 0=禁用 默认0',
  `agent_create_time` int(11) NOT NULL COMMENT '创建时间',
  `agent_balance` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '余额',
  `agent_freeze_balance` decimal(65, 2) NULL DEFAULT NULL COMMENT '冻结金额',
  `agent_white_ip` varchar(56) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip白名单,多个IP用;隔开,最多4个, 为空则不限制',
  `agent_belong` int(11) NULL DEFAULT 0 COMMENT '直属上级(如果有上级并且代理有盈利，会按照比例取该代理的盈利额给直属上级  比如代理月底盈利 100 比例10% 则该代理余额+90，上级 +10)',
  `agent_contribution_ratio` decimal(6, 2) NULL DEFAULT 5.00 COMMENT '像上级分红比例，默认5%',
  `agent_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent
-- ----------------------------

-- ----------------------------
-- Table structure for agent_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `agent_balance_log`;
CREATE TABLE `agent_balance_log`  (
  `agent_balance_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '代理ID',
  `agent_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `agent_nicke_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `agent_balance_log_balance_before` decimal(65, 2) NOT NULL COMMENT '变动前金额',
  `agent_balance_log_balance_after` decimal(65, 2) NOT NULL COMMENT '变动后金额',
  `agent_balance_log_balance` decimal(65, 2) NOT NULL COMMENT '变动金额',
  `agent_balance_log_balance_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变动来源',
  `agent_balance_log_create_time` int(11) NOT NULL COMMENT '变动时间',
  `agent_balance_log_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_balance_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理金额变动表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent_balance_log
-- ----------------------------

-- ----------------------------
-- Table structure for agent_login_log
-- ----------------------------
DROP TABLE IF EXISTS `agent_login_log`;
CREATE TABLE `agent_login_log`  (
  `agent_login_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '代理ID',
  `agent_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代理账号',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代理昵称',
  `agent_login_log_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
  `agent_login_log_time` int(11) NOT NULL COMMENT '登录时间',
  `agent_login_log_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_login_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理登录日志表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for agent_withdraw_order
-- ----------------------------
DROP TABLE IF EXISTS `agent_withdraw_order`;
CREATE TABLE `agent_withdraw_order`  (
  `agent_withdraw_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent_id` decimal(65, 2) NOT NULL COMMENT '代理ID',
  `agent_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `agent_withdraw_order_balance` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提现金额',
  `agent_withdraw_order_create_time` int(11) NOT NULL COMMENT '申请时间',
  `agent_withdraw_order_status` int(11) NOT NULL COMMENT '当前状态',
  `admin_id` int(11) NULL DEFAULT NULL COMMENT '管理员ID',
  `admin_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '管理员昵称',
  `agent_withdraw_order_operate_time` int(11) NULL DEFAULT 0 COMMENT '管理员操作时间',
  `agent_withdraw_order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_withdraw_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理提现申请表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent_withdraw_order
-- ----------------------------

-- ----------------------------
-- Table structure for channel
-- ----------------------------
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel`  (
  `channel_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_full_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道全程',
  `channel_short_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道简称',
  `channel_deposit_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代收地址',
  `channel_withdraw_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代付地址',
  `channel_sort` int(11) UNSIGNED NULL DEFAULT 0 COMMENT '排序  该值越大越前',
  `channel_deduct_deposit_amount` int(11) NOT NULL COMMENT '代收扣除基额(平台盈利来源)',
  `channel_deduct_withdraw_amount` int(11) NOT NULL COMMENT '代付扣除基额(平台盈利来源)',
  `channel_deposit_rate` decimal(5, 2) NOT NULL COMMENT '代收扣除费率(平台盈利来源)',
  `channel_withdraw_rate` decimal(5, 2) NOT NULL COMMENT '代付扣除费率(平台盈利来源)',
  `channel_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '渠道状态  1=开启 0=禁用 新增渠道默认为禁用状态 需管理员手动开启',
  `channel_support_country_cn_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 中',
  `channel_support_country_eg_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 英',
  `channel_support_country_iso_code` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 iso 编码',
  `channel_support_country_id` int(11) NOT NULL COMMENT '渠道支持的国家 id(如果某个渠道支持多个国家,需要为该渠道每个国家配置一个)',
  `channel_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道IP   如果该值不为空 每次该渠道回调不为该IP的请求都拒绝',
  `channel_create_time` int(11) NOT NULL COMMENT '创建时间',
  `channel_last_update_time` int(11) NULL DEFAULT NULL COMMENT '最后更新时间',
  `channel_remark` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 13 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n渠道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES (1, 'BenriPay', 'Benri', 'https://openapi.benri-pay.com/gateway/prepaidOrder', 'https://openapi.benri-pay.com/gateway/cash', 0, 0, 0, 0.00, 0.00, 1, 'indonisia', '', '', 0, NULL, 0, NULL, '');
INSERT INTO `channel` VALUES (2, 'VNPay', 'VN', 'https://www.vn168pay.com/Pay_Index.html', 'https://www.vn168pay.com/Payment_Dfpay_add.html', 0, 0, 0, 0.00, 0.00, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (3, 'JuHuaPay', 'JuHua', 'http://admin.juhua1212.com/yj_action/orderApi/new', 'http://admin.juhua1212.com/yj_action/agentApi/create', 0, 0, 0, 0.00, 0.00, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (4, 'SJPay', 'SJ', 'https://api.rb131411.com/index/underorder.do', 'https://api.rb131411.com/withdrawal/create', 0, 0, 0, 0.00, 0.00, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (5, 'ShineUPay', 'ShineU', 'https://testgateway.shineupay.com/pay/create', 'https://testgateway.shineupay.com/withdraw/create', 0, 0, 0, 0.00, 0.00, 1, 'india', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (6, 'SubiPay', 'SUB', 'http://efupays.com:8084/api/pay/V2', 'http://efupays.com:8084/api/defray/V2', 0, 0, 0, 0.00, 0.00, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for channel_deposit
-- ----------------------------
DROP TABLE IF EXISTS `channel_deposit`;
CREATE TABLE `channel_deposit`  (
  `channel_deposit_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_deposit_type_id` int(11) NOT NULL COMMENT '通道类型ID',
  `channel_deposit_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_deposit_code_extra` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_deposit_min_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小充值金额(支付渠道提供)',
  `channel_deposit_max_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大充值金额(支付渠道提供)',
  `channel_deposit_type_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '通道当前状态(支付渠道提供,如果渠道通道不可用则修改该值)  1=可用 0=禁用 每一个新增通道默认不可用需要管理员手动开启',
  `channel_deposit_type_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_deposit_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n充值通道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_deposit
-- ----------------------------

-- ----------------------------
-- Table structure for channel_deposit_merchant
-- ----------------------------
DROP TABLE IF EXISTS `channel_deposit_merchant`;
CREATE TABLE `channel_deposit_merchant`  (
  `channel_deposit_merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_deposit_id` int(11) NOT NULL COMMENT '充值通道ID',
  `channel_deposit_type_id` int(11) NOT NULL COMMENT '充值通道类型ID',
  `channel_deposit_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_deposit_extra_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_deposit_min_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小充值金额(支付渠道提供)',
  `channel_deposit_max_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大充值金额(支付渠道提供)',
  `channel_deposit_merchant_min_amount` decimal(65, 2) NOT NULL COMMENT '商户设置该通道最小充值金额(商户自行修改，不能低于渠道提供值，默认为渠道值)',
  `channel_deposit_merchant_max_amount` decimal(65, 2) NOT NULL COMMENT '商户设置该通道最大充值金额(商户自行修改，不能高于渠道提供值，默认为渠道值)',
  `channel_deposit_merchant_status` tinyint(1) NULL DEFAULT 0 COMMENT '通道当前状态  1=开启 0=禁用  新增通道默认为禁用状态 需要再商户后台手动开启',
  `channel_deposit_merchant_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_deposit_merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户充值通道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_deposit_merchant
-- ----------------------------

-- ----------------------------
-- Table structure for channel_deposit_type
-- ----------------------------
DROP TABLE IF EXISTS `channel_deposit_type`;
CREATE TABLE `channel_deposit_type`  (
  `channel_deposit_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_deposit_type_cn_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 中',
  `channel_deposit_type_eg_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 英',
  `channel_deposit_type_remark` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_deposit_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n支付通道类型表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_deposit_type
-- ----------------------------

-- ----------------------------
-- Table structure for channel_merchant
-- ----------------------------
DROP TABLE IF EXISTS `channel_merchant`;
CREATE TABLE `channel_merchant`  (
  `channel_merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_full_name` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道全称',
  `channel_short_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道简称',
  `channel_merchant_number` int(11) NOT NULL COMMENT '商户号',
  `channel_merchant_secret_key` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户密钥',
  `channel_support_country_id` int(11) NOT NULL COMMENT '渠道支持的国家',
  `channel_merchant_deduct_deposit_amount` int(11) NOT NULL COMMENT '商户代收扣除基额',
  `channel_merchant_deduct_withdraw_amount` int(11) NOT NULL COMMENT '商户代付扣除基额',
  `channel_merchant_deposit_rate` decimal(5, 2) NOT NULL COMMENT '商户代收扣除利率',
  `channel_merchant_withdraw_rate` decimal(5, 2) NOT NULL COMMENT '商户代付扣除利率',
  `channel_status` tinyint(1) NOT NULL COMMENT '渠道状态 1=启用 0=禁用 (管理员切换某个渠道的状态时，需要同步修改该表状态值，该值商户不可修改)',
  `channel_merchant_deposit_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值地址',
  `channel_merchant_withdraw_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代付地址',
  `channel_merchant_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '属于商户的通道开关  1=启用 0=禁用(当channel_status 和该值都为1 时，该通道才可用)',
  `channel_merchant_create_time` int(11) NOT NULL COMMENT '商户通道创建时间',
  `channel_merchant_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户通道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_merchant
-- ----------------------------

-- ----------------------------
-- Table structure for channel_merchant_daily_report
-- ----------------------------
DROP TABLE IF EXISTS `channel_merchant_daily_report`;
CREATE TABLE `channel_merchant_daily_report`  (
  `channel_merchant_daily_report_id` int(11) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_merchant_daily_report_deposit_amount` decimal(65, 2) NOT NULL COMMENT '当日充值金额',
  `channel_merchant_daily_report_withdraw_amount` decimal(65, 2) NOT NULL COMMENT '当日提现金额',
  `channel_merchant_daily_report_deposit_fee` decimal(65, 2) NOT NULL COMMENT '充值花费',
  `channel_merchant_daily_report_withdraw_fee` decimal(65, 2) NOT NULL COMMENT '提现花费',
  `channel_merchant_daily_report_year` int(11) NOT NULL COMMENT '年',
  `channel_merchant_daily_report_month` int(11) NOT NULL COMMENT '月',
  `channel_merchant_daily_report_week` int(11) NOT NULL COMMENT '周',
  `channel_merchant_daily_report_day` int(11) NOT NULL COMMENT '日',
  `channel_merchant_daily_report_add_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`channel_merchant_daily_report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户渠道每日统计表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_merchant_daily_report
-- ----------------------------

-- ----------------------------
-- Table structure for country
-- ----------------------------
DROP TABLE IF EXISTS `country`;
CREATE TABLE `country`  (
  `country_id` int(11) NOT NULL AUTO_INCREMENT,
  `country_cn_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '中文',
  `country_eg_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '英文',
  `country_iso_code` char(2) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '国际代码',
  `country_currency_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种',
  `country_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种ISOCODE',
  `country_currency_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种编号',
  `country_sort` int(3) NOT NULL DEFAULT 0 COMMENT '排序   默认所有0  调大常用国家该值',
  `country_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 185 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n国家信息\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '安道尔共和国', 'Andorra', 'AD', '欧元', '	EU', '978', 0, NULL);
INSERT INTO `country` VALUES (2, '阿拉伯联合酋长国', 'United Arab Emirates', 'AE', '阿联酋迪拉姆', 'AED', '784', 0, NULL);
INSERT INTO `country` VALUES (3, '阿富汗', 'Afghanistan', 'AF', '阿尼', 'AFN', '971', 0, NULL);
INSERT INTO `country` VALUES (4, '安提瓜和巴布达', 'Antigua and Barbuda', 'AG', '东加勒比元', 'XCD', '951', 0, NULL);
INSERT INTO `country` VALUES (5, '安圭拉岛', 'Anguilla', 'AI', '东加勒比元', 'XCD', '951', 0, '');
INSERT INTO `country` VALUES (6, '阿尔巴尼亚', 'Albania', 'AL', '列克', 'ALL', '008', 0, NULL);
INSERT INTO `country` VALUES (7, '亚美尼亚', 'Armenia', 'AM', '亚美尼亚德拉姆', 'AMD', '051', 0, NULL);
INSERT INTO `country` VALUES (8, '安哥拉', 'Angola', 'AO', '宽扎', 'AOA', '973', 0, NULL);
INSERT INTO `country` VALUES (9, '阿根廷', 'Argentina', 'AR', '阿根廷比索', 'ARS', '032', 0, NULL);
INSERT INTO `country` VALUES (10, '奥地利', 'Austria', 'AT', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (11, '澳大利亚', 'Australia', 'AU', '澳元', 'AUD', '036', 0, NULL);
INSERT INTO `country` VALUES (12, '阿塞拜疆', 'Azerbaijan', 'AZ', '阿塞拜疆马纳特', 'AZN', '944', 0, NULL);
INSERT INTO `country` VALUES (13, '巴巴多斯', 'Barbados', 'BB', '巴巴多斯元', 'BBD', '052', 0, NULL);
INSERT INTO `country` VALUES (14, '孟加拉国', 'Bangladesh', 'BD', '塔卡', 'BDT', '050', 0, NULL);
INSERT INTO `country` VALUES (15, '比利时', 'Belgium', 'BE', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (16, '布基纳法索', 'Burkina-faso', 'BF', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (17, '保加利亚', 'Bulgaria', 'BG', '保加利亚列瓦', 'BGN', '975', 0, NULL);
INSERT INTO `country` VALUES (18, '巴林', 'Bahrain', 'BH', '巴林第纳尔', 'BHD', '048', 0, NULL);
INSERT INTO `country` VALUES (19, '布隆迪', 'Burundi', 'BI', '布隆迪法郎', 'BIF', '108', 0, NULL);
INSERT INTO `country` VALUES (20, '贝宁', 'Benin', 'BJ', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (21, '巴勒斯坦', 'Palestine', 'BL', '新谢克尔', 'ILS', '376', 0, '');
INSERT INTO `country` VALUES (22, '百慕大群岛', 'Bermuda Is.', 'BM', '百慕大元', 'BMD', '060', 0, NULL);
INSERT INTO `country` VALUES (23, '文莱', 'Brunei', 'BN', '	文莱元', 'BND', '096', 0, NULL);
INSERT INTO `country` VALUES (24, '玻利维亚', 'Bolivia', 'BO', '玻利维亚资金', '	BO', '984', 0, NULL);
INSERT INTO `country` VALUES (25, '巴西', 'Brazil', 'BR', '巴西雷亚尔', 'BRL', '986', 0, NULL);
INSERT INTO `country` VALUES (26, '巴哈马', 'Bahamas', 'BS', '巴哈马元', 'BSD', '044', 0, NULL);
INSERT INTO `country` VALUES (27, '博茨瓦纳', 'Botswana', 'BW', '	普拉', 'BWP', '072', 0, NULL);
INSERT INTO `country` VALUES (28, '白俄罗斯', 'Belarus', 'BY', '白俄罗斯卢布', 'BYR', '974', 0, NULL);
INSERT INTO `country` VALUES (29, '伯利兹', 'Belize', 'BZ', '伯利兹元', 'BZD', '084', 0, NULL);
INSERT INTO `country` VALUES (30, '加拿大', 'Canada', 'CA', '加元', 'CAD', '124', 0, NULL);
INSERT INTO `country` VALUES (31, '中非共和国', 'Central African Republic', 'CF', '多哥非洲共同体法郎', 'XAF', '950', 0, NULL);
INSERT INTO `country` VALUES (32, '刚果', 'Congo', 'CG', '多哥非洲共同体法郎', 'XAF', '950', 0, NULL);
INSERT INTO `country` VALUES (33, '瑞士', 'Switzerland', 'CH', 'WIR欧元', 'CHE', '947', 0, NULL);
INSERT INTO `country` VALUES (34, '库克群岛', 'Cook Is.', 'CK', '新西兰元', 'NZD', '554', 0, NULL);
INSERT INTO `country` VALUES (35, '智利', 'Chile', 'CL', '智利资金', 'CLF', '990', 0, NULL);
INSERT INTO `country` VALUES (36, '喀麦隆', 'Cameroon', 'CM', '多哥非洲共同体法郎', 'XAF', '950', 0, NULL);
INSERT INTO `country` VALUES (37, '中国', 'China', 'CN', '人民币元', 'CNY', '156', 0, NULL);
INSERT INTO `country` VALUES (38, '哥伦比亚', 'Colombia', 'CO', '哥伦比亚比索', 'COP', '170', 0, NULL);
INSERT INTO `country` VALUES (39, '哥斯达黎加', 'Costa Rica', 'CR', '哥斯达尼家科朗', 'CRC', '188', 0, NULL);
INSERT INTO `country` VALUES (40, '捷克', 'Czech', 'CS', '捷克克朗', 'CZK', '203', 0, NULL);
INSERT INTO `country` VALUES (41, '古巴', 'Cuba', 'CU', '古巴比索', 'CUP', '192', 0, NULL);
INSERT INTO `country` VALUES (42, '塞浦路斯', 'Cyprus', 'CY', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (43, '捷克', 'Czech Republic', 'CZ', '捷克克朗', 'CZK', '203', 0, NULL);
INSERT INTO `country` VALUES (44, '德国', 'Germany', 'DE', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (45, '吉布提', 'Djibouti', 'DJ', '吉布提法郎', 'DJF', '262', 0, NULL);
INSERT INTO `country` VALUES (46, '丹麦', 'Denmark', 'DK', '丹麦克朗', 'DKK', '208', 0, NULL);
INSERT INTO `country` VALUES (47, '多米尼加共和国', 'Dominica Rep.', 'DO', '多米尼加比索', 'DOP', '214', 0, NULL);
INSERT INTO `country` VALUES (48, '阿尔及利亚', 'Algeria', 'DZ', '阿尔及利亚第纳尔', 'DZD', '012', 0, NULL);
INSERT INTO `country` VALUES (49, '厄瓜多尔', 'Ecuador', 'EC', '美元', 'USD', '840', 0, NULL);
INSERT INTO `country` VALUES (50, '爱沙尼亚', 'Estonia', 'EE', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (51, '埃及', 'Egypt', 'EG', '埃及镑', 'EGP', '818', 0, NULL);
INSERT INTO `country` VALUES (52, '西班牙', 'Spain', 'ES', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (53, '埃塞俄比亚', 'Ethiopia', 'ET', '埃塞俄比亚比尔', 'ETB', '230', 0, NULL);
INSERT INTO `country` VALUES (54, '芬兰', 'Finland', 'FI', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (55, '斐济', 'Fiji', 'FJ', '斐济元', 'FJD', '242', 0, NULL);
INSERT INTO `country` VALUES (56, '法国', 'France', 'FR', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (57, '加蓬', 'Gabon', 'GA', '多哥非洲共同体法郎', 'XAF', '950', 0, NULL);
INSERT INTO `country` VALUES (58, '英国', 'United Kiongdom', 'GB', '英镑', 'GBP', '826', 0, NULL);
INSERT INTO `country` VALUES (59, '格林纳达', 'Grenada', 'GD', '东加勒比元', 'XCD', '951', 0, NULL);
INSERT INTO `country` VALUES (60, '格鲁吉亚', 'Georgia', 'GE', '拉里', 'GEL', '981', 0, NULL);
INSERT INTO `country` VALUES (61, '法属圭亚那', 'French Guiana', 'GF', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (62, '加纳', 'Ghana', 'GH', '加纳赛地', 'GHS', '936', 0, NULL);
INSERT INTO `country` VALUES (63, '直布罗陀', 'Gibraltar', 'GI', '直布罗陀镑', 'GIP', '292', 0, NULL);
INSERT INTO `country` VALUES (64, '冈比亚', 'Gambia', 'GM', '达拉西', 'GMD', '270', 0, NULL);
INSERT INTO `country` VALUES (65, '几内亚', 'Guinea', 'GN', '几内亚法郎', 'GNF', '324', 0, NULL);
INSERT INTO `country` VALUES (66, '希腊', 'Greece', 'GR', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (67, '危地马拉', 'Guatemala', 'GT', '格查尔', 'GTQ', '320', 0, NULL);
INSERT INTO `country` VALUES (68, '关岛', 'Guam', 'GU', '美元', 'USD', '840', 0, NULL);
INSERT INTO `country` VALUES (69, '圭亚那', 'Guyana', 'GY', '圭亚那元', 'GYD', '328', 0, NULL);
INSERT INTO `country` VALUES (70, '香港特别行政区', 'Hongkong', 'HK', '港元', 'HKD', '344', 0, NULL);
INSERT INTO `country` VALUES (71, '洪都拉斯', 'Honduras', 'HN', '伦皮拉', 'HNL', '340', 0, NULL);
INSERT INTO `country` VALUES (72, '海地', 'Haiti', 'HT', '古德', 'HTG', '332', 0, NULL);
INSERT INTO `country` VALUES (73, '匈牙利', 'Hungary', 'HU', '福林', 'HUF', '348', 0, NULL);
INSERT INTO `country` VALUES (74, '印度尼西亚', 'Indonesia', 'ID', '卢比', 'IDR', '360', 0, NULL);
INSERT INTO `country` VALUES (75, '爱尔兰', 'Ireland', 'IE', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (76, '以色列', 'Israel', 'IL', '新谢克尔', 'ILS', '376', 0, NULL);
INSERT INTO `country` VALUES (77, '印度', 'India', 'IN', '印度卢比', 'INR', '356', 0, NULL);
INSERT INTO `country` VALUES (78, '伊拉克', 'Iraq', 'IQ', '伊拉克第纳尔', 'IQD', '368', 0, NULL);
INSERT INTO `country` VALUES (79, '伊朗', 'Iran', 'IR', '伊朗里亚尔', 'IRR', '364', 0, NULL);
INSERT INTO `country` VALUES (80, '冰岛', 'Iceland', 'IS', '冰岛克朗', 'ISK', '352', 0, NULL);
INSERT INTO `country` VALUES (81, '意大利', 'Italy', 'IT', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (82, '牙买加', 'Jamaica', 'JM', '牙买加元', 'JMD', '388', 0, NULL);
INSERT INTO `country` VALUES (83, '约旦', 'Jordan', 'JO', '约旦第纳尔', 'JOD', '400', 0, NULL);
INSERT INTO `country` VALUES (84, '日本', 'Japan', 'JP', '日元', 'JPY', '392', 0, NULL);
INSERT INTO `country` VALUES (85, '肯尼亚', 'Kenya', 'KE', '肯尼亚先令', 'KES', '404', 0, NULL);
INSERT INTO `country` VALUES (86, '吉尔吉斯坦', 'Kyrgyzstan', 'KG', '索姆', 'KGS', '417', 0, NULL);
INSERT INTO `country` VALUES (87, '柬埔寨', 'Kampuchea (Cambodia )', 'KH', '瑞尔', 'KHR', '116', 0, NULL);
INSERT INTO `country` VALUES (88, '朝鲜', 'North Korea', 'KP', '朝鲜元', 'KPW', '408', 0, NULL);
INSERT INTO `country` VALUES (89, '韩国', 'Korea', 'KR', '韩元', 'KRW', '410', 0, NULL);
INSERT INTO `country` VALUES (90, '科特迪瓦共和国', 'Republic of Ivory Coast', 'KT', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (91, '科威特', 'Kuwait', 'KW', '科威特第纳尔', 'KWD', '414', 0, NULL);
INSERT INTO `country` VALUES (92, '哈萨克斯坦', 'Kazakstan', 'KZ', '腾格', 'KZT', '398', 0, NULL);
INSERT INTO `country` VALUES (93, '老挝', 'Laos', 'LA', '基普', 'LAK', '418', 0, NULL);
INSERT INTO `country` VALUES (94, '黎巴嫩', 'Lebanon', 'LB', '黎巴嫩镑', 'LBP', '422', 0, NULL);
INSERT INTO `country` VALUES (95, '圣卢西亚', 'St.Lucia', 'LC', '东加勒比元', 'XCD', '951', 0, NULL);
INSERT INTO `country` VALUES (96, '列支敦士登', 'Liechtenstein', 'LI', '瑞士法郎', 'CHF', '756', 0, NULL);
INSERT INTO `country` VALUES (97, '斯里兰卡', 'Sri Lanka', 'LK', '斯里兰卡卢比', 'LKR', '144', 0, NULL);
INSERT INTO `country` VALUES (98, '利比里亚', 'Liberia', 'LR', '利比里亚元', 'LRD', '430', 0, NULL);
INSERT INTO `country` VALUES (99, '莱索托', 'Lesotho', 'LS', '鲁梯', 'LSL', '426', 0, NULL);
INSERT INTO `country` VALUES (100, '立陶宛', 'Lithuania', 'LT', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (101, '卢森堡', 'Luxembourg', 'LU', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (102, '拉脱维亚', 'Latvia', 'LV', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (103, '利比亚', 'Libya', 'LY', '利比亚第纳尔', 'LYD', '434', 0, NULL);
INSERT INTO `country` VALUES (104, '摩洛哥', 'Morocco', 'MA', '摩洛哥迪拉姆', 'MAD', '504', 0, NULL);
INSERT INTO `country` VALUES (105, '摩纳哥', 'Monaco', 'MC', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (106, '摩尔多瓦', 'Moldova, Republic of', 'MD', '摩尔多瓦尼乌', 'MDL', '498', 0, NULL);
INSERT INTO `country` VALUES (107, '马达加斯加', 'Madagascar', 'MG', '阿里亚里', 'MGA', '969', 0, NULL);
INSERT INTO `country` VALUES (108, '马里', 'Mali', 'ML', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (109, '缅甸', 'Burma', 'MM', '缅甸元', 'MMK', '104', 0, NULL);
INSERT INTO `country` VALUES (110, '蒙古', 'Mongolia', 'MN', '图格里克', 'MNT', '496', 0, NULL);
INSERT INTO `country` VALUES (111, '澳门', 'Macao', 'MO', '澳元', 'MOP', '446', 0, NULL);
INSERT INTO `country` VALUES (112, '蒙特塞拉特岛', 'Montserrat Is', 'MS', '东加勒比元', 'XCD', '951', 0, NULL);
INSERT INTO `country` VALUES (113, '马耳他', 'Malta', 'MT', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (114, '毛里求斯', 'Mauritius', 'MU', '毛里求斯卢比', 'MUR', '480', 0, NULL);
INSERT INTO `country` VALUES (115, '马尔代夫', 'Maldives', 'MV', '拉菲亚', 'MVR', '462', 0, NULL);
INSERT INTO `country` VALUES (116, '马拉维', 'Malawi', 'MW', '克瓦查', 'MWK', '454', 0, NULL);
INSERT INTO `country` VALUES (117, '墨西哥', 'Mexico', 'MX', '墨西哥比索', 'MXN', '484', 0, NULL);
INSERT INTO `country` VALUES (118, '马来西亚', 'Malaysia', 'MY', '马来西亚林吉特', 'MYR', '458', 0, NULL);
INSERT INTO `country` VALUES (119, '莫桑比克', 'Mozambique', 'MZ', '莫桑比克梅蒂卡尔', 'MZN', '943', 0, NULL);
INSERT INTO `country` VALUES (120, '纳米比亚', 'Namibia', 'NA', '纳米比亚元', 'NAD', '516', 0, NULL);
INSERT INTO `country` VALUES (121, '尼日尔', 'Niger', 'NE', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (122, '尼日利亚', 'Nigeria', 'NG', '奈拉', 'NGN', '566', 0, NULL);
INSERT INTO `country` VALUES (123, '尼加拉瓜', 'Nicaragua', 'NI', '尼加拉瓜新科多巴', 'NIO', '558', 0, NULL);
INSERT INTO `country` VALUES (124, '荷兰', 'Netherlands', 'NL', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (125, '挪威', 'Norway', 'NO', '挪威克朗', 'NOK', '578', 0, NULL);
INSERT INTO `country` VALUES (126, '尼泊尔', 'Nepal', 'NP', '尼泊尔卢比', 'NPR', '524', 0, NULL);
INSERT INTO `country` VALUES (127, '瑙鲁', 'Nauru', 'NR', '澳元', 'AUD', '036', 0, NULL);
INSERT INTO `country` VALUES (128, '新西兰', 'New Zealand', 'NZ', '新西兰元', 'NZD', '554', 0, NULL);
INSERT INTO `country` VALUES (129, '阿曼', 'Oman', 'OM', '阿曼里亚尔', 'OMR', '512', 0, NULL);
INSERT INTO `country` VALUES (130, '巴拿马', 'Panama', 'PA', '巴波亚', 'PAB', '590', 0, NULL);
INSERT INTO `country` VALUES (131, '秘鲁', 'Peru', 'PE', '新索尔', 'PEN', '604', 0, NULL);
INSERT INTO `country` VALUES (132, '法属玻利尼西亚', 'French Polynesia', 'PF', '非洲金融共同体法郎', 'XPF', '953', 0, NULL);
INSERT INTO `country` VALUES (133, '巴布亚新几内亚', 'Papua New Cuinea', 'PG', '基那', 'PGK', '598', 0, NULL);
INSERT INTO `country` VALUES (134, '菲律宾', 'Philippines', 'PH', '菲律宾比索', 'PHP', '608', 0, NULL);
INSERT INTO `country` VALUES (135, '巴基斯坦', 'Pakistan', 'PK', '巴基斯坦卢比', 'PKR', '586', 0, NULL);
INSERT INTO `country` VALUES (136, '波兰', 'Poland', 'PL', '兹罗提', 'PLN', '985', 0, NULL);
INSERT INTO `country` VALUES (137, '波多黎各', 'Puerto Rico', 'PR', '美元', 'USD', '840', 0, NULL);
INSERT INTO `country` VALUES (138, '葡萄牙', 'Portugal', 'PT', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (139, '巴拉圭', 'Paraguay', 'PY', '瓜拉尼', 'PYG', '600', 0, NULL);
INSERT INTO `country` VALUES (140, '卡塔尔', 'Qatar', 'QA', '卡塔尔里亚尔', 'QAR', '634', 0, NULL);
INSERT INTO `country` VALUES (141, '罗马尼亚', 'Romania', 'RO', '罗马尼亚列伊', 'RON', '946', 0, NULL);
INSERT INTO `country` VALUES (142, '俄罗斯', 'Russia', 'RU', '俄罗斯卢布', 'RUB', '643', 0, NULL);
INSERT INTO `country` VALUES (143, '沙特阿拉伯', 'Saudi Arabia', 'SA', '沙特里亚尔', 'SAR', '682', 0, NULL);
INSERT INTO `country` VALUES (144, '所罗门群岛', 'Solomon Is', 'SB', '所罗门群岛元', 'SBD', '090', 0, NULL);
INSERT INTO `country` VALUES (145, '塞舌尔', 'Seychelles', 'SC', '塞舌尔卢比', 'SCR', '690', 0, NULL);
INSERT INTO `country` VALUES (146, '苏丹', 'Sudan', 'SD', '苏丹镑', 'SDG', '938', 0, NULL);
INSERT INTO `country` VALUES (147, '瑞典', 'Sweden', 'SE', '瑞典克朗', 'SEK', '752', 0, NULL);
INSERT INTO `country` VALUES (148, '新加坡', 'Singapore', 'SG', '新加坡元', 'SGD', '702', 0, NULL);
INSERT INTO `country` VALUES (149, '斯洛文尼亚', 'Slovenia', 'SI', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (150, '斯洛伐克', 'Slovakia', 'SK', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (151, '塞拉利昂', 'Sierra Leone', 'SL', '利昂', 'SLL', '694', 0, NULL);
INSERT INTO `country` VALUES (152, '圣马力诺', 'San Marino', 'SM', '欧元', 'EUR', '978', 0, NULL);
INSERT INTO `country` VALUES (153, '塞内加尔', 'Senegal', 'SN', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (154, '索马里', 'Somali', 'SO', '索马里先令', 'SOS', '706', 0, NULL);
INSERT INTO `country` VALUES (155, '苏里南', 'Suriname', 'SR', '苏里南元', 'SRD', '968', 0, NULL);
INSERT INTO `country` VALUES (156, '圣多美和普林西比', 'Sao Tome and Principe', 'ST', '多布拉', 'STN', '930', 0, NULL);
INSERT INTO `country` VALUES (157, '萨尔瓦多', 'EI Salvador', 'SV', '萨尔瓦多科朗', 'SVC', '222', 0, NULL);
INSERT INTO `country` VALUES (158, '叙利亚', 'Syria', 'SY', '叙利亚镑', 'SYP', '760', 0, NULL);
INSERT INTO `country` VALUES (159, '斯威士兰', 'Swaziland', 'SZ', '里兰基尼', 'SZL', '748', 0, NULL);
INSERT INTO `country` VALUES (160, '乍得', 'Chad', 'TD', '多哥非洲共同体法郎', 'XAF', '950', 0, NULL);
INSERT INTO `country` VALUES (161, '多哥', 'Togo', 'TG', '多哥非洲共同体法郎', 'XOF', '952', 0, NULL);
INSERT INTO `country` VALUES (162, '泰国', 'Thailand', 'TH', '泰铢', 'THB', '764', 0, NULL);
INSERT INTO `country` VALUES (163, '塔吉克斯坦', 'Tajikstan', 'TJ', '索摩尼', 'TJS', '972', 0, NULL);
INSERT INTO `country` VALUES (164, '土库曼斯坦', 'Turkmenistan', 'TM', '土库曼斯坦新马纳特', 'TMT', '934', 0, NULL);
INSERT INTO `country` VALUES (165, '突尼斯', 'Tunisia', 'TN', '突尼斯第纳尔', 'TND', '788', 0, NULL);
INSERT INTO `country` VALUES (166, '汤加', 'Tonga', 'TO', '潘加’', 'TOP', '776', 0, NULL);
INSERT INTO `country` VALUES (167, '土耳其', 'Turkey', 'TR', '土耳其里拉', 'TRY', '949', 0, NULL);
INSERT INTO `country` VALUES (168, '特立尼达和多巴哥', 'Trinidad and Tobago', 'TT', '特立达与多巴哥元', 'TTD', '780', 0, NULL);
INSERT INTO `country` VALUES (169, '台湾省', 'Taiwan', 'TW', '新台币元', 'TWD', '901', 0, NULL);
INSERT INTO `country` VALUES (170, '坦桑尼亚', 'Tanzania', 'TZ', '坦桑尼亚先令', 'TZS', '834', 0, NULL);
INSERT INTO `country` VALUES (171, '乌克兰', 'Ukraine', 'UA', '格里夫尼亚', 'UAH', '980', 0, NULL);
INSERT INTO `country` VALUES (172, '乌干达', 'Uganda', 'UG', '乌干达先令', 'UGX', '800', 0, NULL);
INSERT INTO `country` VALUES (173, '美国', 'United States of America', 'US', '美元', 'USD', '840', 0, NULL);
INSERT INTO `country` VALUES (174, '乌拉圭', 'Uruguay', 'UY', '乌拉圭比索', 'UYI', '940', 0, NULL);
INSERT INTO `country` VALUES (175, '乌兹别克斯坦', 'Uzbekistan', 'UZ', '乌兹别克斯坦萨', 'UZS', '860', 0, NULL);
INSERT INTO `country` VALUES (176, '圣文森特岛', 'Saint Vincent', 'VC', '东加勒比元', 'XCD', '951', 0, NULL);
INSERT INTO `country` VALUES (177, '委内瑞拉', 'Venezuela', 'VE', '玻利瓦尔', 'VEF', '937', 0, NULL);
INSERT INTO `country` VALUES (178, '越南', 'Vietnam', 'VN', '越南盾', 'VND', '704', 0, NULL);
INSERT INTO `country` VALUES (179, '也门', 'Yemen', 'YE', '也门里亚尔', 'YER', '886', 0, NULL);
INSERT INTO `country` VALUES (180, '南斯拉夫', 'Yugoslavia', 'YU', '第纳尔', 'MKD', '807', 0, NULL);
INSERT INTO `country` VALUES (181, '南非', 'South Africa', 'ZA', '兰特', 'ZAR', '710', 0, NULL);
INSERT INTO `country` VALUES (182, '赞比亚', 'Zambia', 'ZM', '赞比亚克瓦查', 'ZMW', '967', 0, NULL);
INSERT INTO `country` VALUES (183, '扎伊尔', 'Zaire', 'ZR', '新扎伊尔', 'CDF', '180', 0, '');
INSERT INTO `country` VALUES (184, '津巴布韦', 'Zimbabwe', 'ZW', '津巴布韦元', 'ZWL', '932', 0, NULL);

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '所属代理',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代理昵称',
  `merchant_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户名称',
  `merchant_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `merchant_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮件',
  `merchant_transaction_deposit_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '充值总额(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_transaction_withdraw_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '提现总额(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_total_deposit_fee` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '充值总花费(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_total_withdraw_fee` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '提现总花费(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_balance` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '商户余额',
  `merchant_freeze_balance` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '冻结金额',
  `merchant_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户所在IP,如果不为空,则限制该商户所有不为此ip请求访问',
  `merchant_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户信息\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `merchant_balance_log`;
CREATE TABLE `merchant_balance_log`  (
  `merchant_balance_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_balance_log_before` decimal(65, 2) NOT NULL COMMENT '变动前金额',
  `merchant_balance_log_after` decimal(65, 2) NOT NULL COMMENT '变动后金额',
  `merchant_balance_log_balance` decimal(65, 2) NOT NULL COMMENT '变动金额',
  `merchant_balance_log_source` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '金钱来源',
  `merchant_balance_log_create_time` int(11) NOT NULL COMMENT '创建时间',
  PRIMARY KEY (`merchant_balance_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_balance_log
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_deposit_order
-- ----------------------------
DROP TABLE IF EXISTS `merchant_deposit_order`;
CREATE TABLE `merchant_deposit_order`  (
  `merchant_deposit_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_merchant_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `channel_short_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchant_id` int(11) NOT NULL,
  `channel_merchant_number` int(11) NOT NULL,
  `merchant_deposit_order_merchant_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchant_deposit_order_plat_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchant_deposit_order_amount` decimal(65, 2) NULL DEFAULT NULL,
  `merchant_deposit_order_notify_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `merchant_deposit_order_request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_deposit_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_deposit_order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
