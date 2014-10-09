/*
Navicat MySQL Data Transfer

Source Server         : Local server
Source Server Version : 50051
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50051
File Encoding         : 65001

Date: 2014-10-08 19:28:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `record`
-- ----------------------------
DROP TABLE IF EXISTS `record`;
CREATE TABLE `record` (
  `id` int(11) NOT NULL auto_increment,
  `title` varchar(255) character set utf8 collate utf8_spanish_ci default NULL,
  `release_date` timestamp NULL default NULL,
  `artist_id` int(11) default NULL,
  `label_id` int(11) default NULL,
  `created` timestamp NULL default NULL,
  `modified` timestamp NULL default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=1730429376 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of record
-- ----------------------------
INSERT INTO `record` VALUES ('215538419', 'ceasr', '2012-02-09 00:00:00', '12312', '31221', '2012-02-09 00:00:00', '2012-02-09 00:00:00');
INSERT INTO `record` VALUES ('2312', 'Amigo', '2012-11-01 18:17:55', '23212', '34323', '2012-10-24 18:17:58', '2012-10-08 18:18:02');
INSERT INTO `record` VALUES ('231', 'Kasdas', '2012-10-08 00:00:00', '343', '214', '2012-10-16 00:00:00', '2012-10-19 00:00:00');
INSERT INTO `record` VALUES ('1730429375', 'Pablo', '2014-10-10 00:00:00', '121312', '53453453', '2014-10-10 00:00:00', '2014-10-10 00:00:00');
