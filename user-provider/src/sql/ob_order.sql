/*
 Navicat Premium Data Transfer

 Source Server         : mybatis
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : localhost:3306
 Source Schema         : springcloud

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 08/08/2023 16:16:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ob_order
-- ----------------------------
DROP TABLE IF EXISTS `ob_order`;
CREATE TABLE `ob_order`  (
  `WAYBILL_NO` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `BIG_TYPE` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `DTORDER_DATE` date NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of ob_order
-- ----------------------------
INSERT INTO `ob_order` VALUES (NULL, '集团外整车', '2023-08-07');
INSERT INTO `ob_order` VALUES (NULL, '零部件', '2023-08-06');
INSERT INTO `ob_order` VALUES (NULL, '普货', '2023-08-05');

SET FOREIGN_KEY_CHECKS = 1;
