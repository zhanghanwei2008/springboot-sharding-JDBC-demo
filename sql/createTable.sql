
CREATE TABLE `users` (
   `userID` int(11) NOT NULL COMMENT '用户ID',
   `username` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '用户名',
   `phoneNum` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '手机号码',
   `age` int(11) DEFAULT NULL COMMENT '年龄',
   `ddID` int(11) DEFAULT NULL COMMENT '所属会员类型',
   `createTime` datetime DEFAULT NULL COMMENT '注册时间',
   `lastUpdate` datetime DEFAULT NULL COMMENT '最后更新时间',
   PRIMARY KEY (`userID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin



CREATE TABLE `user_address` (
   `addressID` int(11) NOT NULL COMMENT '地址ID',
   `receiver` varchar(16) COLLATE utf8_bin DEFAULT NULL COMMENT '收货人',
   `addressDetail` varchar(32) COLLATE utf8_bin DEFAULT NULL COMMENT '地址详细',
   `userID` int(11) NOT NULL COMMENT '用户ID',
   `createTime` datetime DEFAULT NULL COMMENT '创建时间',
   `lastUpdate` datetime DEFAULT NULL COMMENT '最后更新时间',
   PRIMARY KEY (`addressID`,`userID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin




CREATE TABLE `store` (
   `storeID` int(11) NOT NULL,
   `storeName` varchar(32) COLLATE utf8_bin DEFAULT NULL,
   `storeAddress` varchar(256) COLLATE utf8_bin DEFAULT NULL,
   `createTime` datetime DEFAULT NULL,
   `lastUpdate` datetime DEFAULT NULL,
   PRIMARY KEY (`storeID`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin


CREATE TABLE `goods` (
   `goods_id` bigint(20) NOT NULL,
   `goods_name` varchar(100) COLLATE utf8_bin NOT NULL,
   `goods_type` bigint(20) DEFAULT NULL,
   PRIMARY KEY (`goods_id`)
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin