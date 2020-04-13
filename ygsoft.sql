# Host: 127.0.0.1  (Version: 5.5.15)
# Date: 2019-04-25 22:58:08
# Generator: MySQL-Front 5.3  (Build 4.269)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "api"
#

CREATE TABLE `api` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `apiName` varchar(100) DEFAULT NULL,
  `apiType` varchar(255) DEFAULT NULL COMMENT '请求方式',
  `apiAddress` varchar(200) NOT NULL DEFAULT '',
  `protocol` varchar(10) NOT NULL DEFAULT '' COMMENT '请求协议',
  `requestType` varchar(4) NOT NULL DEFAULT '' COMMENT '请求方式',
  `requestDataFormat` varchar(10) NOT NULL DEFAULT '' COMMENT '请求数据类型',
  `returnDataFormat` varchar(10) NOT NULL DEFAULT '' COMMENT '返回的数据类型',
  `outline` varchar(100) DEFAULT NULL,
  `time` datetime NOT NULL DEFAULT '2019-04-16 00:00:00',
  `status` varchar(10) NOT NULL DEFAULT '未审核' COMMENT '审核状态',
  `publisher` varchar(40) DEFAULT NULL COMMENT '发布者',
  `reviewer` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

#
# Data for table "api"
#

INSERT INTO `api` VALUES (12,'sdf','jn','sdfsfs','HTTP','post','jn','jn',NULL,'2019-04-25 22:12:08','测试失败','commonUser','test'),(13,'test','jn','test/tsst','HTTP','post','jn','jn',NULL,'2019-04-25 22:15:11','测试失败','commonUser','test'),(14,'test1','jn','test1','HTTP','get','jn','jn',NULL,'2019-04-25 22:21:33','测试通过','commonUser','test'),(15,'test3','jn','test/t','HTTP','post','jn','jn',NULL,'2019-04-25 22:25:24','未审核','commonUser',NULL);

#
# Structure for table "api_param"
#

CREATE TABLE `api_param` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `paramName` varchar(20) NOT NULL DEFAULT '',
  `paramType` varchar(15) NOT NULL DEFAULT '',
  `aid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `api_aid` (`aid`),
  CONSTRAINT `api_param_ibfk_1` FOREIGN KEY (`aid`) REFERENCES `api` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

#
# Data for table "api_param"
#

INSERT INTO `api_param` VALUES (17,'gfd','dfg',12),(18,'name','string',13),(19,'sdf','sdf',14),(20,'test','string',15);

#
# Structure for table "logs"
#

CREATE TABLE `logs` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) DEFAULT NULL,
  `action` varchar(20) DEFAULT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '时间戳',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COMMENT='日志表';

#
# Data for table "logs"
#

INSERT INTO `logs` VALUES (1,'10','0','2019-03-22 20:38:17'),(2,'20','0','2019-03-22 20:38:35'),(3,'未登录用户','查询所有用户','2019-04-13 20:00:49'),(4,'未登录用户',NULL,'2019-04-13 20:00:50'),(5,'未登录用户',NULL,'2019-04-13 20:01:19'),(6,'未登录用户','查询所有用户','2019-04-13 20:02:38'),(7,'未登录用户','查询所有用户','2019-04-13 20:03:29'),(8,'未登录用户','查询所有用户','2019-04-13 20:03:47'),(9,'未登录用户','查询所有用户','2019-04-13 20:04:03'),(10,'未登录用户','查询所有用户','2019-04-13 20:24:19'),(11,'未登录用户','查询所有用户','2019-04-13 20:50:56'),(12,'未登录用户','查询所有用户','2019-04-13 20:51:12'),(13,'未登录用户','查询所有用户','2019-04-13 20:51:30'),(14,'未登录用户','查询所有用户','2019-04-13 21:00:55'),(15,'未登录用户','查询所有用户','2019-04-13 21:03:51'),(16,'未登录用户','查询所有用户','2019-04-13 21:06:46'),(17,'未登录用户','查询所有用户','2019-04-13 21:07:18'),(18,'未登录用户','查询所有用户','2019-04-13 21:09:29'),(19,'1111','11111','2019-04-13 23:23:42'),(21,'222','222','2019-04-13 23:26:14');

#
# Structure for table "permission"
#

CREATE TABLE `permission` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(40) NOT NULL DEFAULT '',
  `action` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8 COMMENT='权限';

#
# Data for table "permission"
#

INSERT INTO `permission` VALUES (15,'/config/addUser','新增用户');

#
# Structure for table "role"
#

CREATE TABLE `role` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(40) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COMMENT='角色表';

#
# Data for table "role"
#

INSERT INTO `role` VALUES (4,'测试用户'),(6,'审核用户'),(11,'普通用户'),(13,'系统管理用户');

#
# Structure for table "role_permission"
#

CREATE TABLE `role_permission` (
  `rid` int(11) NOT NULL DEFAULT '0',
  `pid` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`rid`,`pid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "role_permission"
#

INSERT INTO `role_permission` VALUES (11,1),(13,2),(13,3);

#
# Structure for table "user"
#

CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(40) NOT NULL DEFAULT '',
  `password` varchar(64) NOT NULL DEFAULT '',
  `salt` varchar(64) NOT NULL DEFAULT '',
  `date` date NOT NULL DEFAULT '2019-03-20' COMMENT '注册日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='用户表';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (5,'201616080319','326a38a2f447a099169dcec53681b369','LkwJfKJWzK94//bGTJaxAw==','2019-03-20'),(19,'201616080315','cef028fd9def479bf076f6ddff804cd2','7/hguLRkOacU1Fx3TEynsw==','2019-03-20'),(22,'a123','25d9fd14ec2dc001f7ebb21c08abbfcd','GqK2DP6At8ZkisrfulphBg==','2019-03-20'),(23,'a1234','12d18ad6b7aaa1aff17082899b579a01','YQvIuLkrIgYGG4So4gmLnQ==','2019-03-20'),(27,'admin','7f292a733bd979ea93f55503f0059506','8/zM1s0RJXJZZlDnH24/8A==','2019-03-20'),(28,'test','13ecd46be3816f7b20666f88c406e39b','miZwRRNMZNLdunkrSuffcA==','2019-03-20'),(29,'auditor','fb6ac72c6aab7307f7f70c5a4507e933','PuIa9br71CjPCxyTFOgwIA==','2019-03-20'),(30,'commonUser','81f7895e0b5b4323413287600a445cb9','nRMQEUYG6s4TDDAiwTDnBA==','2019-03-20'),(31,'testor','5b37be26ebc5406459862c4f257d4ce9','jXMQSTHF9ZRY8NJNAMWfMw==','2019-03-20');

#
# Structure for table "user_role"
#

CREATE TABLE `user_role` (
  `uid` bigint(20) NOT NULL DEFAULT '0',
  `rid` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`uid`,`rid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "user_role"
#

INSERT INTO `user_role` VALUES (1,4),(5,4),(11,8),(12,8),(14,7),(18,4),(19,6),(20,11),(22,4),(23,13),(25,13),(27,13),(28,4),(29,6),(30,11),(31,4);
