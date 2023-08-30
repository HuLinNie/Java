
--建库，建表脚本；
--0、使用root登录mysql数据库，

--1、建库：
use mysql;
create datebase web2019;
--2、转到web2019；
use web2019;
--3、分别建立以下各表：
CREATE TABLE `album` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `artist` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `country` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` double DEFAULT NULL,
  `isdroped` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
;
--插入两条测试数据
insert into album(name,artist,country,price) values('十面埋伏','韩信','楚',10);
insert into album(name,artist,country,price) values('纵贯线','纵贯线乐团','中国',19.8);

 CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `birthday` varchar(10) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `address` varchar(256) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `mail` varchar(128) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(11) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
;
 CREATE TABLE `cart` (
  `userid` int(11) NOT NULL,
  `cart` varchar(1024) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
;
 CREATE TABLE `order_` (
  `id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  `date` timestamp NOT NULL,
  `amount` double DEFAULT '0',
  `customer_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
;
CREATE TABLE `order_item` (
 `id` int(11) NOT NULL AUTO_INCREMENT,
  `count` int(11) NOT NULL DEFAULT '1',
  `album_id` int(11) NOT NULL,
  `order_id` varchar(32) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci
;
--4、使用如下脚本建立存储过程：
--//加载订单详情 通过订单ID
		USE `web2019`;
		DROP procedure IF EXISTS `load_order`;

		DELIMITER $$
		USE `web2019`$$
		CREATE PROCEDURE `load_order` (in order_id varchar(32))
		BEGIN
			select order_.id as id,amount,date,customer_id,name,birthday,mail,phone,address from order_ left join customer on order_.customer_id=customer.id where order_.id=order_id;
			select order_item.id,order_item.count,album.id as album_id,album.name,album.artist,album.country,album.price from order_item left join album on order_item.album_id=album.id where order_item.order_id=order_id;
		END$$

		DELIMITER ;
		
--//加载订单概况 通过用户id	
		USE `web2019`;
		DROP procedure IF EXISTS `load_orderByCustomer`;

		DELIMITER $$
		USE `web2019`$$
		CREATE PROCEDURE `load_orderByCustomer` (in customer_id int)
		BEGIN
			select id,name,birthday,address,mail,phone from customer where id=customer_id;
			select id,amount,date from order_  where order_.customer_id=customer_id;
		END$$

		DELIMITER ;