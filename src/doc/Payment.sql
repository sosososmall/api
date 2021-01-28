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

 Date: 28/01/2021 18:33:37
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
  `admin_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '账号状态  1=开启 0=禁用',
  `admin_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话,多个号码以 ; 隔开',
  `admin_type` tinyint(1) NOT NULL DEFAULT 3 COMMENT '账号类型  1=超管  2=普通管理  3-客服？？',
  `admin_white_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT 'ip白名单,多个IP用;隔开,最多4个, 为空则不限制',
  `admin_daily_max_login_fail_count` int(11) NOT NULL DEFAULT 6 COMMENT '管理员当日登录失败总次数  超过阀值即禁用该账号 默认 6 次',
  `admin_daily_login_fail_count` int(11) NOT NULL DEFAULT 0 COMMENT '管理员当日登录失败次数  (写脚本每天 0时0分0秒 重置该值)',
  `admin_max_confirm_withdraw_count` int(11) NOT NULL DEFAULT 0 COMMENT '管理员每日能通过的最大代理提现次数',
  `admin_max_confirm_withdraw_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '管理员能通过的代理最大提现金额',
  `admin_create_time` int(11) NOT NULL DEFAULT 0 COMMENT '创建时间',
  `admin_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n管理员表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'tinker', 'jerry', 'e10adc3949ba59abbe56e057f20f883e', 1, '18223437401', 1, '192.168.2.132;192.168.2.236', 6, 0, 10, 10000000.00, 1611827541, 'hello world');

-- ----------------------------
-- Table structure for admin_log
-- ----------------------------
DROP TABLE IF EXISTS `admin_log`;
CREATE TABLE `admin_log`  (
  `admin_log_id` bigint(20) NOT NULL,
  `admin_id` int(11) NOT NULL COMMENT '管理员ID',
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
  `admin_login_log_ip` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
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
  `agent_phone` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系电话 多个号码以 ; 隔开',
  `agent_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码  md5 密文',
  `agent_withdraw_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现密码  md5 密文',
  `agent_bank_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现银行',
  `agent_bank_card` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现银行卡号',
  `agent_bank_branch` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '体现银行所属支行名称',
  `agent_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '状态  1=启用 0=禁用 默认1',
  `agent_create_time` int(11) NOT NULL COMMENT '创建时间',
  `agent_white_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip白名单,多个IP用;隔开,最多4个, 为空则不限制',
  `agent_belong` int(11) NULL DEFAULT 0 COMMENT '直属上级(如果有上级并且代理有盈利，会按照比例取该代理的盈利额给直属上级  比如代理月底盈利 100 比例10% 则该代理余额+90，上级 +10)',
  `agent_contribution_ratio` decimal(6, 2) NULL DEFAULT 5.00 COMMENT '像上级分红比例，默认5%',
  `agent_daily_max_login_fail_count` int(11) NULL DEFAULT 6 COMMENT '代理当日登录失败总次数  超过阀值即禁用该账号  默认6次',
  `agent_daily_login_fail_count` int(11) NULL DEFAULT 0 COMMENT '代理当日登录失败次数  (写脚本每天 0时0分0秒 重置该值)',
  `agent_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent
-- ----------------------------
INSERT INTO `agent` VALUES (1, 'tom and jerry', 'tomhanx', 'tinker', '18223437401', 'e10adc3949ba59abbe56e057f20f883e', 'e10adc3949ba59abbe56e057f20f883e', 'BOC', '54684665464984687468', '中国银行四川省成都分行', 1, 1611827925, '192.168.2.132;192.168.2.236', 0, 5.00, 6, 0, 'hello springboot');

-- ----------------------------
-- Table structure for agent_balance
-- ----------------------------
DROP TABLE IF EXISTS `agent_balance`;
CREATE TABLE `agent_balance`  (
  `agent_balance_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '代理ID',
  `agent_balance_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种iso code',
  `agent_balance_amount` decimal(15, 2) NOT NULL COMMENT '所属币种金额',
  `agent_balance_amount_withdraw` decimal(15, 2) NULL DEFAULT 0.00 COMMENT '所属币种提现金额',
  `agent_balance_amount_freeze` decimal(15, 2) NULL DEFAULT 0.00 COMMENT '所属币种冻结金额',
  `agent_balance_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`agent_balance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n代理资金信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of agent_balance
-- ----------------------------

-- ----------------------------
-- Table structure for agent_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `agent_balance_log`;
CREATE TABLE `agent_balance_log`  (
  `agent_balance_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '代理ID',
  `agent_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `agent_balance_log_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种代码',
  `agent_balance_log_balance_before` decimal(15, 2) NOT NULL COMMENT '变动前金额',
  `agent_balance_log_balance_after` decimal(15, 2) NOT NULL COMMENT '变动后金额',
  `agent_balance_log_balance` decimal(15, 2) NOT NULL COMMENT '变动金额',
  `agent_balance_log_balance_source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '变动来源',
  `agent_balance_log_create_time` int(11) NOT NULL COMMENT '变动时间',
  `balance_change_type_id` int(11) NOT NULL COMMENT '账变类型ID',
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
  `agent_id` int(11) NOT NULL COMMENT '代理ID',
  `agent_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '昵称',
  `agent_withdraw_order_balance` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提现金额',
  `agent_withdraw_order_balance_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资金币种',
  `agent_withdraw_order_create_time` int(11) NOT NULL COMMENT '申请时间',
  `agent_withdraw_order_status` int(11) NOT NULL DEFAULT 0 COMMENT '当前状态 0=待处理  1=成功  2=驳回  3=通过',
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
-- Table structure for balance_change_type
-- ----------------------------
DROP TABLE IF EXISTS `balance_change_type`;
CREATE TABLE `balance_change_type`  (
  `balance_change_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `balance_change_type_cn_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账变类型 中文',
  `balance_change_type_eg_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '账变类型 英文',
  `balance_change_type_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`balance_change_type_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n资金标动类型表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of balance_change_type
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
  `channel_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '渠道状态  1=开启 0=禁用 新增渠道默认开启',
  `channel_support_country_cn_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 中',
  `channel_support_country_eg_name` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 英',
  `channel_support_country_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道支持的国家 iso 编码',
  `channel_support_country_id` int(11) NOT NULL COMMENT '渠道支持的国家 id(如果某个渠道支持多个国家,需要为该渠道每个国家配置一个)',
  `channel_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '渠道IP   如果该值不为空 每次该渠道回调不为该IP的请求都拒绝',
  `channel_create_time` int(11) NOT NULL COMMENT '创建时间',
  `channel_last_update_time` int(11) NULL DEFAULT NULL COMMENT '最后更新时间',
  `channel_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n渠道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel
-- ----------------------------
INSERT INTO `channel` VALUES (1, 'BenriPay', 'Benri', 'https://openapi.benri-pay.com/gateway/prepaidOrder', 'https://openapi.benri-pay.com/gateway/cash', 0, 1, 'indonisia', '', '', 0, NULL, 0, NULL, '');
INSERT INTO `channel` VALUES (2, 'VNPay', 'VN', 'https://www.vn168pay.com/Pay_Index.html', 'https://www.vn168pay.com/Payment_Dfpay_add.html', 0, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (3, 'JuHuaPay', 'JuHua', 'http://admin.juhua1212.com/yj_action/orderApi/new', 'http://admin.juhua1212.com/yj_action/agentApi/create', 0, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (4, 'SJPay', 'SJ', 'https://api.rb131411.com/index/underorder.do', 'https://api.rb131411.com/withdrawal/create', 0, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (5, 'ShineUPay', 'ShineU', 'https://testgateway.shineupay.com/pay/create', 'https://testgateway.shineupay.com/withdraw/create', 0, 1, 'india', '', '', 0, NULL, 0, NULL, NULL);
INSERT INTO `channel` VALUES (6, 'SubiPay', 'SUB', 'http://efupays.com:8084/api/pay/V2', 'http://efupays.com:8084/api/defray/V2', 0, 1, 'vitenan', '', '', 0, NULL, 0, NULL, NULL);

-- ----------------------------
-- Table structure for channel_deposit
-- ----------------------------
DROP TABLE IF EXISTS `channel_deposit`;
CREATE TABLE `channel_deposit`  (
  `channel_deposit_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_support_country_id` int(11) NULL DEFAULT NULL COMMENT '国家ID',
  `channel_deposit_type_id` int(11) NOT NULL COMMENT '通道类型ID',
  `channel_deposit_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_deposit_code_extra` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_deposit_min_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小充值金额(支付渠道提供)',
  `channel_deposit_max_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大充值金额(支付渠道提供)',
  `channel_deposit_type_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '通道当前状态(支付渠道提供,如果渠道通道不可用则修改该值)  1=可用 0=禁用 默认开启',
  `channel_deduct_deposit_amount` int(11) NOT NULL COMMENT '代收扣除基额(平台盈利来源)',
  `channel_deposit_rate` decimal(6, 2) NOT NULL COMMENT '代收扣除费率(平台盈利来源)',
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
  `channel_deposit_merchant_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '商户充值渠道ID',
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_merchant_id` int(11) NOT NULL COMMENT '商户渠道ID',
  `channel_deposit_id` int(11) NOT NULL COMMENT '充值通道ID',
  `channel_support_country_id` int(11) NULL DEFAULT NULL COMMENT '国家ID',
  `channel_deposit_type_id` int(11) NOT NULL COMMENT '充值通道类型ID',
  `channel_deposit_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_deposit_extra_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_deposit_min_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小充值金额(支付渠道提供)',
  `channel_deposit_max_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大充值金额(支付渠道提供)',
  `channel_deposit_merchant_min_amount` decimal(15, 2) NOT NULL COMMENT '商户设置该通道最小充值金额(商户自行修改，不能低于渠道提供值，默认为渠道值)',
  `channel_deposit_merchant_max_amount` decimal(15, 2) NOT NULL COMMENT '商户设置该通道最大充值金额(商户自行修改，不能高于渠道提供值，默认为渠道值)',
  `channel_deposit_merchant_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '通道当前状态  1=开启 0=禁用  默认开启',
  `channel_deposit_merchant_deduct_amount` int(11) NOT NULL COMMENT '代收扣除基额(平台盈利来源)',
  `channel_deposit_merchant_rate` decimal(6, 2) NOT NULL COMMENT '代收扣除费率(平台盈利来源)',
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
  `channel_deposit_type_cn_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 中文',
  `channel_deposit_type_eg_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 英语',
  `channel_deposit_type_native_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 本地语言',
  `channel_deposit_type_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
  `channel_merchant_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号',
  `channel_merchant_secret_key` varchar(2048) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户密钥',
  `channel_support_country_id` int(11) NOT NULL COMMENT '渠道支持的国家',
  `channel_merchant_deduct_deposit_amount` int(11) NOT NULL COMMENT '商户代收扣除基额',
  `channel_merchant_deduct_withdraw_amount` int(11) NOT NULL COMMENT '商户代付扣除基额',
  `channel_merchant_deposit_rate` decimal(6, 2) NOT NULL COMMENT '商户代收扣除利率',
  `channel_merchant_withdraw_rate` decimal(6, 2) NOT NULL COMMENT '商户代付扣除利率',
  `channel_status` tinyint(1) NOT NULL COMMENT '渠道状态 1=启用 0=禁用 (管理员切换某个渠道的状态时，需要同步修改该表状态值，该值商户不可修改)',
  `channel_merchant_deposit_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '充值地址',
  `channel_merchant_withdraw_url` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代付地址',
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
  `channel_merchant_daily_report_deposit_amount` decimal(15, 2) NOT NULL COMMENT '当日充值金额',
  `channel_merchant_daily_report_withdraw_amount` decimal(15, 2) NOT NULL COMMENT '当日提现金额',
  `channel_merchant_daily_report_deposit_fee` decimal(15, 2) NOT NULL COMMENT '充值花费',
  `channel_merchant_daily_report_withdraw_fee` decimal(5, 2) NOT NULL COMMENT '提现花费',
  `channel_merchant_daily_report_year` int(11) NOT NULL COMMENT '年',
  `channel_merchant_daily_report_month` int(11) NOT NULL COMMENT '月',
  `channel_merchant_daily_report_week` int(11) NOT NULL COMMENT '周',
  `channel_merchant_daily_report_day` int(11) NOT NULL COMMENT '日',
  `channel_merchant_daily_report_add_time` int(11) NOT NULL COMMENT '创建时间',
  `channel_merchant_daily_report_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种',
  PRIMARY KEY (`channel_merchant_daily_report_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户渠道每日统计表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_merchant_daily_report
-- ----------------------------

-- ----------------------------
-- Table structure for channel_withdraw
-- ----------------------------
DROP TABLE IF EXISTS `channel_withdraw`;
CREATE TABLE `channel_withdraw`  (
  `channel_withdraw_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_support_country_id` int(11) NULL DEFAULT NULL COMMENT '国家ID',
  `channel_withdraw_type_id` int(11) NOT NULL COMMENT '通道类型ID',
  `channel_withdraw_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_withdraw_code_extra` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_withdraw_min_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小提现金额(支付渠道提供)',
  `channel_withdraw_max_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大提现金额(支付渠道提供)',
  `channel_withdraw_type_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '通道当前状态(支付渠道提供,如果渠道通道不可用则修改该值)  1=可用 0=禁用 默认开启',
  `channel_deduct_withdraw_amount` int(11) NOT NULL COMMENT '代付扣除基额(平台盈利来源)',
  `channel_withdraw_rate` decimal(6, 2) NOT NULL COMMENT '代付扣除费率(平台盈利来源)',
  `channel_withdraw_type_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_withdraw_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_withdraw
-- ----------------------------

-- ----------------------------
-- Table structure for channel_withdraw_merchant
-- ----------------------------
DROP TABLE IF EXISTS `channel_withdraw_merchant`;
CREATE TABLE `channel_withdraw_merchant`  (
  `channel_withdraw_merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_merchant_id` int(11) NOT NULL COMMENT '商户渠道ID',
  `channel_withdraw_id` int(11) NOT NULL COMMENT '提现通道ID',
  `channel_support_country_id` int(11) NULL DEFAULT NULL COMMENT '国家ID',
  `channel_withdraw_type_id` int(11) NOT NULL COMMENT '提现通道类型ID',
  `channel_withdraw_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '通道编码(单个编码提供该值)',
  `channel_withdraw_extra_code` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '通道额外编码(需要2个编码的时候提供该值)',
  `channel_withdraw_min_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最小提现金额(支付渠道提供)',
  `channel_withdraw_max_amount` decimal(15, 2) NOT NULL DEFAULT 0.00 COMMENT '通道最大提现金额(支付渠道提供)',
  `channel_withdraw_merchant_min_amount` decimal(15, 2) NOT NULL COMMENT '商户设置该通道最小提现金额(商户自行修改，不能低于渠道提供值，默认为渠道值)',
  `channel_withdraw_merchant_max_amount` decimal(15, 2) NOT NULL COMMENT '商户设置该通道最大提现金额(商户自行修改，不能高于渠道提供值，默认为渠道值)',
  `channel_withdraw_merchant_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '通道当前状态  1=开启 0=禁用 默认开启',
  `channel_withdraw_merchant_deduct_amount` int(11) NOT NULL COMMENT '代收扣除基额(平台盈利来源)',
  `channel_withdraw_merchant_rate` decimal(6, 2) NOT NULL COMMENT '代收扣除费率(平台盈利来源)',
  `channel_withdraw_merchant_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_withdraw_merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户提现通道信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_withdraw_merchant
-- ----------------------------

-- ----------------------------
-- Table structure for channel_withdraw_type
-- ----------------------------
DROP TABLE IF EXISTS `channel_withdraw_type`;
CREATE TABLE `channel_withdraw_type`  (
  `channel_withdraw_type_id` int(11) NOT NULL,
  `channel_id` int(11) NOT NULL,
  `channel_withdraw_type_cn_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 中文',
  `channel_withdraw_type_eg_name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 英语',
  `channel_withdraw_type_native_name` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '支付类型名称 本地语言',
  `channel_withdraw_type_remark` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`channel_withdraw_type_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of channel_withdraw_type
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
  `country_currency_latest_exchange_rate` decimal(65, 14) NULL DEFAULT NULL COMMENT '当日汇率(1 cny = ?)',
  `country_currency_rate_update_time` int(11) NULL DEFAULT NULL COMMENT '汇率更新时间',
  `country_currency_update_time` int(11) NULL DEFAULT NULL COMMENT '更新汇率值时间',
  `country_sort` int(3) NOT NULL DEFAULT 0 COMMENT '排序   默认所有0  调大常用国家该值',
  `country_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`country_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 185 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n国家信息\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of country
-- ----------------------------
INSERT INTO `country` VALUES (1, '安道尔共和国', 'Andorra', 'AD', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (2, '阿拉伯联合酋长国', 'United Arab Emirates', 'AE', '阿联酋迪拉姆', 'AED', '784', 0.56658025692672, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (3, '阿富汗', 'Afghanistan', 'AF', '阿尼', 'AFN', '971', 11.91051919491100, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (4, '安提瓜和巴布达', 'Antigua and Barbuda', 'AG', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (5, '安圭拉岛', 'Anguilla', 'AI', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, '');
INSERT INTO `country` VALUES (6, '阿尔巴尼亚', 'Albania', 'AL', '列克', 'ALL', '008', 15.66329344191700, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (7, '亚美尼亚', 'Armenia', 'AM', '亚美尼亚德拉姆', 'AMD', '051', 79.98548714621200, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (8, '安哥拉', 'Angola', 'AO', '宽扎', 'AOA', '973', 100.55945051422000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (9, '阿根廷', 'Argentina', 'AR', '阿根廷比索', 'ARS', '032', 13.33709708506100, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (10, '奥地利', 'Austria', 'AT', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (11, '澳大利亚', 'Australia', 'AU', '澳元', 'AUD', '036', 0.19990980863060, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (12, '阿塞拜疆', 'Azerbaijan', 'AZ', '阿塞拜疆马纳特', 'AZN', '944', 0.26226449903211, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (13, '巴巴多斯', 'Barbados', 'BB', '巴巴多斯元', 'BBD', '052', 0.30855289689678, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (14, '孟加拉国', 'Bangladesh', 'BD', '塔卡', 'BDT', '050', 13.07316597992000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (15, '比利时', 'Belgium', 'BE', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (16, '布基纳法索', 'Burkina-faso', 'BF', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (17, '保加利亚', 'Bulgaria', 'BG', '保加利亚列瓦', 'BGN', '975', 0.24784469166859, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (18, '巴林', 'Bahrain', 'BH', '巴林第纳尔', 'BHD', '048', 0.05800794461660, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (19, '布隆迪', 'Burundi', 'BI', '布隆迪法郎', 'BIF', '108', 301.16420203529000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (20, '贝宁', 'Benin', 'BJ', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (21, '巴勒斯坦', 'Palestine', 'BL', '新谢克尔', 'ILS', '376', 0.50469501878879, 1611384909, 1611387883, 0, '');
INSERT INTO `country` VALUES (22, '百慕大群岛', 'Bermuda Is.', 'BM', '百慕大元', 'BMD', '060', 0.15427644844839, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (23, '文莱', 'Brunei', 'BN', '	文莱元', 'BND', '096', 0.20496387044671, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (24, '玻利维亚', 'Bolivia', 'BO', '玻利维亚资金', 'BOB', '984', 1.06121485913690, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (25, '巴西', 'Brazil', 'BR', '巴西雷亚尔', 'BRL', '986', 0.84345227652201, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (26, '巴哈马', 'Bahamas', 'BS', '巴哈马元', 'BSD', '044', 0.15427644844839, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (27, '博茨瓦纳', 'Botswana', 'BW', '	普拉', 'BWP', '072', 1.70671313951140, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (28, '白俄罗斯', 'Belarus', 'BY', '白俄罗斯卢布', 'BYN', '974', 0.39197858162758, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (29, '伯利兹', 'Belize', 'BZ', '伯利兹元', 'BZD', '084', 0.31075095460724, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (30, '加拿大', 'Canada', 'CA', '加元', 'CAD', '124', 0.19647080994816, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (31, '中非共和国', 'Central African Republic', 'CF', '多哥非洲共同体法郎', 'XAF', '950', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (32, '刚果', 'Congo', 'CG', '多哥非洲共同体法郎', 'XAF', '950', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (33, '瑞士', 'Switzerland', 'CH', '瑞士法郎', 'CHF', '756', 0.13661778205327, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (34, '库克群岛', 'Cook Is.', 'CK', '新西兰元', 'NZD', '554', 0.21423405325876, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (35, '智利', 'Chile', 'CL', '智利披索', 'CLP', '152', 112.27106610940000, 1611384908, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (36, '喀麦隆', 'Cameroon', 'CM', '多哥非洲共同体法郎', 'XAF', '950', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (37, '中国', 'China', 'CN', '人民币元', 'CNY', '156', 1.00000000000000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (38, '哥伦比亚', 'Colombia', 'CO', '哥伦比亚比索', 'COP', '170', 544.20043590059000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (39, '哥斯达黎加', 'Costa Rica', 'CR', '哥斯达尼家科朗', 'CRC', '188', 94.11138371217900, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (40, '捷克', 'Czech', 'CS', '捷克克朗', 'CZK', '203', 3.31169586176870, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (41, '古巴', 'Cuba', 'CU', '古巴比索', 'CUP', '192', 4.08832588388240, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (42, '塞浦路斯', 'Cyprus', 'CY', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (43, '捷克', 'Czech Republic', 'CZ', '捷克克朗', 'CZK', '203', 3.31169586176870, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (44, '德国', 'Germany', 'DE', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (45, '吉布提', 'Djibouti', 'DJ', '吉布提法郎', 'DJF', '262', 27.46145397389300, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (46, '丹麦', 'Denmark', 'DK', '丹麦克朗', 'DKK', '208', 0.94289898333963, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (47, '多米尼加共和国', 'Dominica Rep.', 'DO', '多米尼加比索', 'DOP', '214', 8.96199915525040, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (48, '阿尔及利亚', 'Algeria', 'DZ', '阿尔及利亚第纳尔', 'DZD', '012', 20.46689582246000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (49, '厄瓜多尔', 'Ecuador', 'EC', '美元', 'USD', '840', 0.15427644844839, 1611384908, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (50, '爱沙尼亚', 'Estonia', 'EE', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (51, '埃及', 'Egypt', 'EG', '埃及镑', 'EGP', '818', 2.42543441850810, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (52, '西班牙', 'Spain', 'ES', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (53, '埃塞俄比亚', 'Ethiopia', 'ET', '埃塞俄比亚比尔', 'ETB', '230', 6.06756631478530, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (54, '芬兰', 'Finland', 'FI', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (55, '斐济', 'Fiji', 'FJ', '斐济元', 'FJD', '242', 0.31468538632428, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (56, '法国', 'France', 'FR', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (57, '加蓬', 'Gabon', 'GA', '多哥非洲共同体法郎', 'XAF', '950', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (58, '英国', 'United Kiongdom', 'GB', '英镑', 'GBP', '826', 0.11275456970277, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (59, '格林纳达', 'Grenada', 'GD', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (60, '格鲁吉亚', 'Georgia', 'GE', '拉里', 'GEL', '981', 0.50929232783859, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (61, '法属圭亚那', 'French Guiana', 'GF', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (62, '加纳', 'Ghana', 'GH', '加纳赛地', 'GHS', '936', 0.90058822581347, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (63, '直布罗陀', 'Gibraltar', 'GI', '直布罗陀镑', 'GIP', '292', 0.11275456970277, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (64, '冈比亚', 'Gambia', 'GM', '达拉西', 'GMD', '270', 7.97507163977690, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (65, '几内亚', 'Guinea', 'GN', '几内亚法郎', 'GNF', '324', 1568.65549470890000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (66, '希腊', 'Greece', 'GR', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (67, '危地马拉', 'Guatemala', 'GT', '格查尔', 'GTQ', '320', 1.20103848025520, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (68, '关岛', 'Guam', 'GU', '美元', 'USD', '840', 0.15427644844839, 1611384908, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (69, '圭亚那', 'Guyana', 'GY', '圭亚那元', 'GYD', '328', 32.34941675016500, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (70, '香港特别行政区', 'Hongkong', 'HK', '港元', 'HKD', '344', 1.19594326519650, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (71, '洪都拉斯', 'Honduras', 'HN', '伦皮拉', 'HNL', '340', 3.71709242614040, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (72, '海地', 'Haiti', 'HT', '古德', 'HTG', '332', 11.45550966493700, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (73, '匈牙利', 'Hungary', 'HU', '福林', 'HUF', '348', 45.33796085192800, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (74, '印度尼西亚', 'Indonesia', 'ID', '卢比', 'IDR', '360', 2174.21447304480000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (75, '爱尔兰', 'Ireland', 'IE', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (76, '以色列', 'Israel', 'IL', '新谢克尔', 'ILS', '376', 0.50469501878879, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (77, '印度', 'India', 'IN', '印度卢比', 'INR', '356', 11.26208070508700, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (78, '伊拉克', 'Iraq', 'IQ', '伊拉克第纳尔', 'IQD', '368', 225.24019523514000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (79, '伊朗', 'Iran', 'IR', '伊朗里亚尔', 'IRR', '364', 6483.59515416610000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (80, '冰岛', 'Iceland', 'IS', '冰岛克朗', 'ISK', '352', 19.90153890374700, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (81, '意大利', 'Italy', 'IT', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (82, '牙买加', 'Jamaica', 'JM', '牙买加元', 'JMD', '388', 22.31692614465500, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (83, '约旦', 'Jordan', 'JO', '约旦第纳尔', 'JOD', '400', 0.10938200194991, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (84, '日本', 'Japan', 'JP', '日元', 'JPY', '392', 16.00848175752700, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (85, '肯尼亚', 'Kenya', 'KE', '肯尼亚先令', 'KES', '404', 16.98174784600000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (86, '吉尔吉斯坦', 'Kyrgyzstan', 'KG', '索姆', 'KGS', '417', 13.04036932398500, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (87, '柬埔寨', 'Kampuchea (Cambodia )', 'KH', '瑞尔', 'KHR', '116', 625.65449694106000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (88, '朝鲜', 'North Korea', 'KP', '朝鲜元', 'KPW', '408', 138.85071235526000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (89, '韩国', 'Korea', 'KR', '韩元', 'KRW', '410', 170.56179822383000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (90, '科特迪瓦共和国', 'Republic of Ivory Coast', 'KT', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (91, '科威特', 'Kuwait', 'KW', '科威特第纳尔', 'KWD', '414', 0.04668545721616, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (92, '哈萨克斯坦', 'Kazakstan', 'KZ', '腾格', 'KZT', '398', 64.94406589784300, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (93, '老挝', 'Laos', 'LA', '基普', 'LAK', '418', 1436.17976266360000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (94, '黎巴嫩', 'Lebanon', 'LB', '黎巴嫩镑', 'LBP', '422', 232.57174603595000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (95, '圣卢西亚', 'St.Lucia', 'LC', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (96, '列支敦士登', 'Liechtenstein', 'LI', '瑞士法郎', 'CHF', '756', 0.13657862915128, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (97, '斯里兰卡', 'Sri Lanka', 'LK', '斯里兰卡卢比', 'LKR', '144', 30.52203282239200, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (98, '利比里亚', 'Liberia', 'LR', '利比里亚元', 'LRD', '430', 26.22786320598100, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (99, '莱索托', 'Lesotho', 'LS', '鲁梯', 'LSL', '426', 2.33798054088910, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (100, '立陶宛', 'Lithuania', 'LT', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (101, '卢森堡', 'Luxembourg', 'LU', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (102, '拉脱维亚', 'Latvia', 'LV', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (103, '利比亚', 'Libya', 'LY', '利比亚第纳尔', 'LYD', '434', 0.68752653801563, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (104, '摩洛哥', 'Morocco', 'MA', '摩洛哥迪拉姆', 'MAD', '504', 1.37661062723450, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (105, '摩纳哥', 'Monaco', 'MC', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (106, '摩尔多瓦', 'Moldova, Republic of', 'MD', '摩尔多瓦尼乌', 'MDL', '498', 2.68288302998850, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (107, '马达加斯加', 'Madagascar', 'MG', '阿里亚里', 'MGA', '969', 581.55736358888000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (108, '马里', 'Mali', 'ML', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (109, '缅甸', 'Burma', 'MM', '缅甸元', 'MMK', '104', 205.37413064877000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (110, '蒙古', 'Mongolia', 'MN', '图格里克', 'MNT', '496', 439.97223056331000, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (111, '澳门', 'Macao', 'MO', '澳元', 'MOP', '446', 1.23182156315190, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (112, '蒙特塞拉特岛', 'Montserrat Is', 'MS', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (113, '马耳他', 'Malta', 'MT', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (114, '毛里求斯', 'Mauritius', 'MU', '毛里求斯卢比', 'MUR', '480', 6.12715790264030, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (115, '马尔代夫', 'Maldives', 'MV', '拉菲亚', 'MVR', '462', 2.37544419626400, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (116, '马拉维', 'Malawi', 'MW', '克瓦查', 'MWK', '454', 119.04822211774000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (117, '墨西哥', 'Mexico', 'MX', '墨西哥比索', 'MXN', '484', 3.08132403571420, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (118, '马来西亚', 'Malaysia', 'MY', '马来西亚林吉特', 'MYR', '458', 0.62373954394051, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (119, '莫桑比克', 'Mozambique', 'MZ', '莫桑比克梅蒂卡尔', 'MZN', '943', 11.55230787947000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (120, '纳米比亚', 'Namibia', 'NA', '纳米比亚元', 'NAD', '516', 2.33798054088910, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (121, '尼日尔', 'Niger', 'NE', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (122, '尼日利亚', 'Nigeria', 'NG', '奈拉', 'NGN', '566', 58.81004285664100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (123, '尼加拉瓜', 'Nicaragua', 'NI', '尼加拉瓜新科多巴', 'NIO', '558', 5.40673117533850, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (124, '荷兰', 'Netherlands', 'NL', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (125, '挪威', 'Norway', 'NO', '挪威克朗', 'NOK', '578', 1.30870990416180, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (126, '尼泊尔', 'Nepal', 'NP', '尼泊尔卢比', 'NPR', '524', 18.10379473342100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (127, '瑙鲁', 'Nauru', 'NR', '澳元', 'AUD', '036', 0.19990980863060, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (128, '新西兰', 'New Zealand', 'NZ', '新西兰元', 'NZD', '554', 0.21423405325876, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (129, '阿曼', 'Oman', 'OM', '阿曼里亚尔', 'OMR', '512', 0.05931929442841, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (130, '巴拿马', 'Panama', 'PA', '巴波亚', 'PAB', '590', 0.15427644844839, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (131, '秘鲁', 'Peru', 'PE', '新索尔', 'PEN', '604', 0.56027434304480, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (132, '法属玻利尼西亚', 'French Polynesia', 'PF', '非洲金融共同体法郎', 'XPF', '953', 15.12183516053700, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (133, '巴布亚新几内亚', 'Papua New Cuinea', 'PG', '基那', 'PGK', '598', 0.54781878221957, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (134, '菲律宾', 'Philippines', 'PH', '菲律宾比索', 'PHP', '608', 7.41683931284010, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (135, '巴基斯坦', 'Pakistan', 'PK', '巴基斯坦卢比', 'PKR', '586', 24.78834599113300, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (136, '波兰', 'Poland', 'PL', '兹罗提', 'PLN', '985', 0.57542783496896, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (137, '波多黎各', 'Puerto Rico', 'PR', '美元', 'USD', '840', 0.15427644844839, 1611384908, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (138, '葡萄牙', 'Portugal', 'PT', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (139, '巴拉圭', 'Paraguay', 'PY', '瓜拉尼', 'PYG', '600', 1061.15579704430000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (140, '卡塔尔', 'Qatar', 'QA', '卡塔尔里亚尔', 'QAR', '634', 0.56156627235215, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (141, '罗马尼亚', 'Romania', 'RO', '罗马尼亚列伊', 'RON', '946', 0.61792270724292, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (142, '俄罗斯', 'Russia', 'RU', '俄罗斯卢布', 'RUB', '643', 11.61919366194200, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (143, '沙特阿拉伯', 'Saudi Arabia', 'SA', '沙特里亚尔', 'SAR', '682', 0.57853668168147, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (144, '所罗门群岛', 'Solomon Is', 'SB', '所罗门群岛元', 'SBD', '090', 1.23224076324100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (145, '塞舌尔', 'Seychelles', 'SC', '塞舌尔卢比', 'SCR', '690', 3.26634119302720, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (146, '苏丹', 'Sudan', 'SD', '苏丹镑', 'SDG', '938', 8.50284640212460, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (147, '瑞典', 'Sweden', 'SE', '瑞典克朗', 'SEK', '752', 1.28885893553190, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (148, '新加坡', 'Singapore', 'SG', '新加坡元', 'SGD', '702', 0.20496387044671, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (149, '斯洛文尼亚', 'Slovenia', 'SI', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (150, '斯洛伐克', 'Slovakia', 'SK', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (151, '塞拉利昂', 'Sierra Leone', 'SL', '利昂', 'SLL', '694', 1571.78827123460000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (152, '圣马力诺', 'San Marino', 'SM', '欧元', 'EUR', '978', 0.12672097864023, 1611384908, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (153, '塞内加尔', 'Senegal', 'SN', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (154, '索马里', 'Somali', 'SO', '索马里先令', 'SOS', '706', 88.94203824937800, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (155, '苏里南', 'Suriname', 'SR', '苏里南元', 'SRD', '968', 2.18341622699730, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (156, '圣多美和普林西比', 'Sao Tome and Principe', 'ST', '多布拉', 'STN', '930', 3.14601228705250, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (157, '萨尔瓦多', 'EI Salvador', 'SV', '萨尔瓦多科朗', 'SVC', '222', 1.34991892392340, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (158, '叙利亚', 'Syria', 'SY', '叙利亚镑', 'SYP', '760', 79.11684061646100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (159, '斯威士兰', 'Swaziland', 'SZ', '里兰基尼', 'SZL', '748', 2.33798054088910, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (160, '乍得', 'Chad', 'TD', '多哥非洲共同体法郎', 'XAF', '950', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (161, '多哥', 'Togo', 'TG', '多哥非洲共同体法郎', 'XOF', '952', 83.12351298953100, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (162, '泰国', 'Thailand', 'TH', '泰铢', 'THB', '764', 4.62692964528140, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (163, '塔吉克斯坦', 'Tajikstan', 'TJ', '索摩尼', 'TJS', '972', 1.74332389198140, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (164, '土库曼斯坦', 'Turkmenistan', 'TM', '土库曼斯坦新马纳特', 'TMT', '934', 0.54151033246481, 1611384910, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (165, '突尼斯', 'Tunisia', 'TN', '突尼斯第纳尔', 'TND', '788', 0.41638380078044, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (166, '汤加', 'Tonga', 'TO', '潘加’', 'TOP', '776', 0.34786622569868, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (167, '土耳其', 'Turkey', 'TR', '土耳其里拉', 'TRY', '949', 1.14389800574240, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (168, '特立尼达和多巴哥', 'Trinidad and Tobago', 'TT', '特立达与多巴哥元', 'TTD', '780', 1.04578109480010, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (169, '台湾省', 'Taiwan', 'TW', '新台币元', 'TWD', '901', 4.31618311246860, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (170, '坦桑尼亚', 'Tanzania', 'TZ', '坦桑尼亚先令', 'TZS', '834', 357.73024835209000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (171, '乌克兰', 'Ukraine', 'UA', '格里夫尼亚', 'UAH', '980', 4.35796226775710, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (172, '乌干达', 'Uganda', 'UG', '乌干达先令', 'UGX', '800', 568.51005186258000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (173, '美国', 'United States of America', 'US', '美元', 'USD', '840', 0.15427644844839, 1611384908, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (174, '乌拉圭', 'Uruguay', 'UY', '乌拉圭比索', 'UYU', '858', 6.50932868919600, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (175, '乌兹别克斯坦', 'Uzbekistan', 'UZ', '乌兹别克斯坦萨', 'UZS', '860', 1620.65178763980000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (176, '圣文森特岛', 'Saint Vincent', 'VC', '东加勒比元', 'XCD', '951', 0.41693534203032, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (177, '委内瑞拉', 'Venezuela', 'VE', '玻利瓦尔', 'VEF', '937', 1.54083602887830, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (178, '越南', 'Vietnam', 'VN', '越南盾', 'VND', '704', 3558.64190420060000, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (179, '也门', 'Yemen', 'YE', '也门里亚尔', 'YER', '886', 38.62517554924600, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (180, '南斯拉夫', 'Yugoslavia', 'YU', '第纳尔', 'MKD', '807', 7.81205585969010, 1611384909, 1611387883, 0, NULL);
INSERT INTO `country` VALUES (181, '南非', 'South Africa', 'ZA', '兰特', 'ZAR', '710', 2.33798054088910, 1611384909, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (182, '赞比亚', 'Zambia', 'ZM', '赞比亚克瓦查', 'ZMW', '967', 3.29272109829800, 1611384910, 1611387884, 0, NULL);
INSERT INTO `country` VALUES (183, '扎伊尔', 'Zaire', 'ZR', '新扎伊尔', 'CDF', '180', 305.16789497373000, 1611384909, 1611387883, 0, '');
INSERT INTO `country` VALUES (184, '津巴布韦', 'Zimbabwe', 'ZW', '津巴布韦元', 'ZWD', '788', 55.84112053537600, 1611384909, 1611387883, 0, NULL);

-- ----------------------------
-- Table structure for merchant
-- ----------------------------
DROP TABLE IF EXISTS `merchant`;
CREATE TABLE `merchant`  (
  `merchant_id` int(11) NOT NULL AUTO_INCREMENT,
  `agent_id` int(11) NOT NULL COMMENT '所属代理',
  `agent_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '代理昵称',
  `merchant_real_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户真实姓名',
  `merchant_nick_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户昵称',
  `merchant_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户账号',
  `merchant_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户密码',
  `merchant_phone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '联系电话',
  `merchant_email` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '联系邮件',
  `merchant_ip` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '商户所在IP,如果不为空,则限制该商户所有不为此ip请求访问',
  `merchant_status` tinyint(1) NOT NULL DEFAULT 1 COMMENT '商户状态 1=开启 0=禁用  默认开启',
  `merchant_create_time` int(11) NOT NULL COMMENT '创建时间',
  `merchant_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户信息\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant
-- ----------------------------
INSERT INTO `merchant` VALUES (1, 1, 'tomhanx', 'sipada', 'tinker', 'spicytinker', 'e10adc3949ba59abbe56e057f20f883e', '18223437401', 'god@gmail.com', '192.168.2.132;192.168.2.236', 1, 1611828843, 'hallo java');

-- ----------------------------
-- Table structure for merchant_balance
-- ----------------------------
DROP TABLE IF EXISTS `merchant_balance`;
CREATE TABLE `merchant_balance`  (
  `merchant_balance_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `merchant_balance_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种iso code',
  `merchant_balance_amount` decimal(15, 2) NOT NULL COMMENT '所属币种金额',
  `merchant_balance_freeze_amount` decimal(15, 2) NOT NULL COMMENT '所属币种冻结金额',
  `merchant_balance_transaction_deposit_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '充值总额(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_balance_transaction_withdraw_amount` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '提现总额(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_balance_total_deposit_fee` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '充值总花费(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_balance_total_withdraw_fee` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '提现总花费(非实时数据，今天以前，每日凌晨统计后更新)',
  `merchant_balance_freeze_balance` decimal(65, 2) NOT NULL DEFAULT 0.00 COMMENT '冻结金额',
  `merchant_balance_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_balance_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户资金信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_balance
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_balance_log
-- ----------------------------
DROP TABLE IF EXISTS `merchant_balance_log`;
CREATE TABLE `merchant_balance_log`  (
  `merchant_balance_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `merchant_balance_log_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种iso code',
  `merchant_balance_log_before` decimal(15, 2) NOT NULL COMMENT '变动前金额',
  `merchant_balance_log_after` decimal(15, 2) NOT NULL COMMENT '变动后金额',
  `merchant_balance_log_balance` decimal(15, 2) NOT NULL COMMENT '变动金额',
  `merchant_balance_log_source` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '金钱来源',
  `merchant_balance_log_create_time` int(11) NOT NULL COMMENT '创建时间',
  `merchant_balance_type_id` int(11) NOT NULL COMMENT '账变类型ID',
  `merchant_balance_log_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
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
  `channel_merchant_id` int(11) NOT NULL COMMENT '商户渠道ID',
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_short_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道简称',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_deposit_merchant_id` int(11) NOT NULL COMMENT '商户支付通道ID',
  `channel_merchant_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号',
  `channel_deposit_type_id` int(11) NOT NULL COMMENT '通道类型ID',
  `merchant_deposit_order_plat_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '平台订单号',
  `merchant_deposit_order_channel_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道订单号',
  `merchant_deposit_order_merchant_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户订单号',
  `merchant_deposit_order_amount` decimal(65, 2) NOT NULL COMMENT '充值金额',
  `merchant_deposit_order_fee` decimal(15, 2) NOT NULL COMMENT '订单手续费',
  `merchant_deposit_order_fee_type` int(11) NOT NULL DEFAULT 1 COMMENT '手续费扣除方式 1=商户 2=商户客户',
  `merchant_deposit_order_notify_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户异步通知地址',
  `merchant_deposit_order_request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户请求地址',
  `merchant_deposit_order_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种',
  `merchant_deposit_order_merchant_sign` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '签名',
  `merchant_deposit_order_create_time` bigint(11) NOT NULL COMMENT '创建时间',
  `merchant_deposit_order_notify_merchant_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '商户异步通知状态  1=商户收到回调通知并返回成功',
  `merchant_deposit_order_notify_channel_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '渠道异步通知状态  1=渠道已向平台回调成功',
  `merchant_deposit_order_extra` varchar(1024) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '额外扩展',
  `merchant_deposit_order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_deposit_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n充值订单表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_deposit_order
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_login_log
-- ----------------------------
DROP TABLE IF EXISTS `merchant_login_log`;
CREATE TABLE `merchant_login_log`  (
  `merchant_login_log_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `merchant_account` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录账号',
  `merchant_login_log_ip` varchar(13) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录IP',
  `merchant_login_log_time` int(11) NOT NULL COMMENT '登陆时间',
  `merchant_login_log_status` tinyint(1) NOT NULL COMMENT '登录状态 1=成功 0=失败',
  `merchant_login_log_password` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '登录密码  md5密文',
  PRIMARY KEY (`merchant_login_log_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for merchant_withdraw_order
-- ----------------------------
DROP TABLE IF EXISTS `merchant_withdraw_order`;
CREATE TABLE `merchant_withdraw_order`  (
  `merchant_withdraw_order_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `channel_merchant_id` int(11) NOT NULL COMMENT '商户渠道ID',
  `channel_id` int(11) NOT NULL COMMENT '渠道ID',
  `channel_short_name` varchar(18) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道简称',
  `merchant_id` int(11) NOT NULL COMMENT '商户ID',
  `channel_withdraw_merchant_id` int(11) NOT NULL COMMENT '商户提现通道ID',
  `channel_withdraw_type_id` int(11) NOT NULL COMMENT '通道类型ID',
  `channel_merchant_number` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户号',
  `merchant_withdraw_order_merchant_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户订单号',
  `merchant_withdraw_order_plat_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '平台订单号',
  `merchant_withdraw_order_channel_no` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '渠道订单号',
  `merchant_withdraw_order_amount` decimal(65, 2) NOT NULL COMMENT '提现金额',
  `merchant_withdraw_order_fee` decimal(15, 2) NOT NULL COMMENT '手续费',
  `merchant_withdraw_order_fee_type` int(11) NOT NULL DEFAULT 1 COMMENT '手续费扣除方式 1=商户 2=商户客户',
  `merchant_withdraw_order_real_name` varchar(65) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提现用户真实姓名',
  `merchant_withdraw_order_bank_code` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提现银行代码',
  `merchant_withdraw_order_bank_card` varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '提现用户卡号',
  `merchant_withdraw_order_bank_branch` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '提现银行所在支行',
  `merchant_withdraw_order_notify_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户异步通知地址',
  `merchant_withdraw_order_request_url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商户请求地址',
  `merchant_withdraw_order_currency_iso_code` char(3) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '币种',
  `merchant_withdraw_order_merchant_sign` char(32) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '签名',
  `merchant_withdraw_order_create_time` int(11) NOT NULL COMMENT '创建时间',
  `merchant_withdraw_order_notify_merchant_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '商户异步通知状态  1=商户收到回调通知并返回成功',
  `merchant_withdraw_order_notify_channel_status` tinyint(1) NOT NULL DEFAULT 0 COMMENT '渠道异步通知状态  1=渠道已向平台回调成功',
  `merchant_withdraw_order_remark` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`merchant_withdraw_order_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '/*\r\n商户提现订单信息表\r\n*/' ROW_FORMAT = Compact;

-- ----------------------------
-- Records of merchant_withdraw_order
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
