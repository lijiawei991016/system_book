/*
MySQL Data Transfer
Source Host: localhost
Source Database: system_book
Target Host: localhost
Target Database: system_book
Date: 2020/4/13 15:27:51
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for system_book_cart
-- ----------------------------
CREATE TABLE `system_book_cart` (
  `cartId` int(11) NOT NULL AUTO_INCREMENT,
  `bookId` int(11) NOT NULL,
  `uid` varchar(64) NOT NULL,
  `count` int(11) DEFAULT '0',
  PRIMARY KEY (`cartId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_category
-- ----------------------------
CREATE TABLE `system_book_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `category` varchar(32) NOT NULL COMMENT '分类',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_info
-- ----------------------------
CREATE TABLE `system_book_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ä¸»é”®',
  `bookName` varchar(128) DEFAULT NULL COMMENT 'ä¹¦å',
  `author` varchar(128) DEFAULT NULL COMMENT 'ä½œè€…',
  `categoryId` int(11) DEFAULT NULL COMMENT 'åˆ†ç±»id',
  `publisher` varchar(128) DEFAULT NULL COMMENT 'å‡ºç‰ˆç¤¾',
  `price` double DEFAULT NULL COMMENT 'å”®ä»·',
  `photo` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_orders
-- ----------------------------
CREATE TABLE `system_book_orders` (
  `oid` varchar(32) NOT NULL COMMENT 'è®¢å•å·',
  `bid` int(11) DEFAULT NULL COMMENT 'å…³è”SYTEM_BOOK_INFOçš„ä¸»é”®',
  `uid` varchar(64) DEFAULT NULL,
  `count` double DEFAULT NULL COMMENT 'è®¢å•æ•°é‡',
  `curPrice` double DEFAULT NULL COMMENT 'å•ä»·',
  `date` datetime DEFAULT NULL COMMENT 'è®¢å•æ—¥æœŸæ—¶é—´',
  PRIMARY KEY (`oid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for system_book_user
-- ----------------------------
CREATE TABLE `system_book_user` (
  `userId` varchar(64) NOT NULL COMMENT '账户',
  `userPsw` varchar(64) NOT NULL COMMENT '密码',
  `userName` varchar(128) DEFAULT NULL COMMENT '姓名',
  `role` int(11) DEFAULT '1' COMMENT '角色',
  PRIMARY KEY (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `system_book_category` VALUES ('10', '仙侠');
INSERT INTO `system_book_category` VALUES ('9', '历史');
INSERT INTO `system_book_category` VALUES ('13', '小说');
INSERT INTO `system_book_category` VALUES ('11', '玄幻');
INSERT INTO `system_book_info` VALUES ('7', '水浒传', '施耐庵', '13', '中国人民邮政出版社', '17', null);
INSERT INTO `system_book_info` VALUES ('8', '红楼梦', '曹雪芹', '11', '清华大学出版社', '19', '452fd682-336b-4461-9d27-d0512abb7da3.png');
INSERT INTO `system_book_info` VALUES ('10', '史记', '司马迁', '9', '中国人民邮政出版社', '13', '5a83ba5e-4c0b-4021-903a-ba4d9a6aa1be.png');
INSERT INTO `system_book_info` VALUES ('11', '剑道第一仙', '萧瑾瑜', '11', '纵横网出版社', '32', '0e4fb44f-5230-473e-968c-01173402694c.png');
INSERT INTO `system_book_info` VALUES ('12', '星辰之主', '减肥专家', '11', '纵横网出版社', '36', 'c4e6c3f3-2aca-4924-9d13-5b66e553ab47.png');
INSERT INTO `system_book_info` VALUES ('13', '深夜乐园', '大元宝', '11', '纵横网出版社', '51', 'a2fa31ae-18d6-4d08-9928-9dea679312b4.png');
INSERT INTO `system_book_info` VALUES ('14', '末世无限吞噬', '风雨神话', '11', '纵横网出版社', '12', '10dcc8be-8e5c-47bc-bc78-284ce0ea1ff8.png');
INSERT INTO `system_book_info` VALUES ('16', '长宁帝军', '知白', '11', '纵横网出版社', '37', '88e20ac6-106e-4f5b-8f7f-357a9c98fd2c.png');
INSERT INTO `system_book_info` VALUES ('17', '凡人修仙', '喜喜', '10', '纵横网出版', '18', null);
INSERT INTO `system_book_info` VALUES ('18', '凡人历险记', '嘿嘿', '13', '中国人民邮政出版社', '66', 'd6232808-d357-419b-8629-b029498ab3b6.png');
INSERT INTO `system_book_info` VALUES ('19', '无敌凡人', '呵呵', '10', '纵横网出版社', '19', null);
INSERT INTO `system_book_info` VALUES ('20', '我是凡人', '玩小小', '13', '纵横网出版社', '77', null);
INSERT INTO `system_book_info` VALUES ('21', '老子是凡人', '王尼玛', '9', '四川日报出版社', '63', null);
INSERT INTO `system_book_user` VALUES ('21232f297a57a5a743894a0e4a801fc3', '21232f297a57a5a743894a0e4a801fc3', '管理员', '2');
INSERT INTO `system_book_user` VALUES ('b4022480e9e1915cd37ef2af97d0c87b', '202cb962ac59075b964b07152d234b70', '张三', '1');
INSERT INTO `system_book_user` VALUES ('b3a6bafab1029c2b79f1fea20b68fdb9', 'f379eaf3c831b04de153469d1bec345e', '李四', '1');
