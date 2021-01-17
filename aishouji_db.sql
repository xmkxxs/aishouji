/*
SQLyog Ultimate v11.33 (64 bit)
MySQL - 5.5.15 : Database - aishouji_db
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`aishouji_db` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `aishouji_db`;

/*Table structure for table `tb_brand` */

DROP TABLE IF EXISTS `tb_brand`;

CREATE TABLE `tb_brand` (
  `p_brand_id` int(11) NOT NULL COMMENT '商品品牌id',
  `p_brand_name` varchar(255) NOT NULL COMMENT '商品品牌名称',
  `p_brand_describe` varchar(255) NOT NULL COMMENT '品牌描述',
  PRIMARY KEY (`p_brand_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_brand` */

insert  into `tb_brand`(`p_brand_id`,`p_brand_name`,`p_brand_describe`) values (1,'iPhone','风靡全球的iPhone手机，再一次改变世界！'),(2,'三星','三星，智慧生活，安卓机皇只为你生！'),(3,'华为','先有华为后又天，上天入地赛神仙！'),(4,'小米','永远相信，美好的事情即将发生！'),(5,'OPPO','聆听, 如此优雅！'),(6,'ViVO','vivo音乐手机');

/*Table structure for table `tb_order` */

DROP TABLE IF EXISTS `tb_order`;

CREATE TABLE `tb_order` (
  `order_id` varchar(255) NOT NULL COMMENT '订单id',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `user_address` varchar(255) NOT NULL COMMENT '收货地址',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order` */

/*Table structure for table `tb_order_item` */

DROP TABLE IF EXISTS `tb_order_item`;

CREATE TABLE `tb_order_item` (
  `order_id` varchar(255) NOT NULL COMMENT '订单编号',
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `id` int(10) NOT NULL COMMENT 'id',
  `p_price` varchar(255) NOT NULL COMMENT '单价',
  `p_img` varchar(255) NOT NULL COMMENT '图片',
  `p_num` varchar(255) NOT NULL COMMENT '个数',
  `user_address` varchar(255) NOT NULL,
  `p_brand_describe` varchar(255) NOT NULL COMMENT '商品描述'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_order_item` */

insert  into `tb_order_item`(`order_id`,`user_name`,`id`,`p_price`,`p_img`,`p_num`,`user_address`,`p_brand_describe`) values ('asj20201102084212567176','bbbbb',44,'1700','oppoace2.png','1','a','聆听, 如此优雅！'),('asj20201102084234414885','bbbbb',18,'4400','samsungnote10plus.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20201102084234414885','bbbbb',22,'5100','samsungnote20ultra.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20201102084407502664','bbbbb',26,'5000','samsungs20ultra.png','1','江苏','三星，智慧生活，安卓机皇只为你生！'),('asj20201102084407502664','bbbbb',35,'2500','mi10.png','1','aa','永远相信，美好的事情即将发生！'),('asj20201102085335389481','bbbbb',95,'3000','oppofindx2.png','1','a','聆听, 如此优雅！'),('asj20210113134307501950','bbbbb',104,'3000','oppofindx2.png','1','a','聆听, 如此优雅！'),('asj20210113134817228878','bbbbb',15,'4100','iphone11pro.png','1','a','风靡全球的iPhone手机，再一次改变世界！'),('asj20210113135921116919','bbbbb',123,'3000','oppofindx2.png','1','a','聆听, 如此优雅！'),('asj20210113173626095292','bbbbb',67,'3000','iphonexs.png','1','dsa','风靡全球的iPhone手机，再一次改变世界！'),('asj20210115125144456320','bbbbb',11,'3900','iphone11.png','1','a','风靡全球的iPhone手机，再一次改变世界！'),('asj20210115125144456320','bbbbb',41,'1500','opporeno4.png','1','a','聆听, 如此优雅！'),('asj20210115125144456320','bbbbb',22,'5100','samsungnote20ultra.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20210115144436159156','bbbbb',29,'3500','huaweimate30pro.png','1','aa','先有华为后又天，上天入地赛神仙！'),('asj20210116171354814486','bbbbb',44,'1700','oppoace2.png','1','江苏南京文澜99','聆听, 如此优雅！'),('asj20210116171354814486','bbbbb',37,'3500','mi10zhizun.png','2','江苏南京文澜99','永远相信，美好的事情即将发生！'),('asj20210116172015068959','bbbbb',27,'4700','samsungs20ultra.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20210116172034218474','bbbbb',22,'5100','samsungnote20ultra.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20210116172250316972','bbbbb',20,'2500','samsungnote10plus.png','1','a','三星，智慧生活，安卓机皇只为你生！'),('asj20210116172703031647','bbbbb',45,'4100','vivox50proplus.png','1','a','vivo音乐手机'),('asj20210116190109735750','bbbbb',36,'1900','mi10.png','2','a','永远相信，美好的事情即将发生！');

/*Table structure for table `tb_product` */

DROP TABLE IF EXISTS `tb_product`;

CREATE TABLE `tb_product` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `p_name` varchar(255) NOT NULL COMMENT '商品名称',
  `p_level` varchar(255) NOT NULL COMMENT '商品成色',
  `p_price` varchar(255) NOT NULL COMMENT '商品价格',
  `p_img` varchar(255) NOT NULL COMMENT '商品图片',
  `p_num` varchar(255) NOT NULL COMMENT '商品数量',
  `p_brand_id` int(11) NOT NULL COMMENT '商品品牌id',
  `P_size` varchar(255) NOT NULL COMMENT '存储大小',
  `p_ram` varchar(255) NOT NULL COMMENT '内存',
  PRIMARY KEY (`id`),
  KEY `fk_brand_id` (`p_brand_id`),
  CONSTRAINT `fk_brand_id` FOREIGN KEY (`p_brand_id`) REFERENCES `tb_brand` (`p_brand_id`)
) ENGINE=InnoDB AUTO_INCREMENT=127 DEFAULT CHARSET=utf8;

/*Data for the table `tb_product` */

insert  into `tb_product`(`id`,`p_name`,`p_level`,`p_price`,`p_img`,`p_num`,`p_brand_id`,`P_size`,`p_ram`) values (1,'iPhone 8 Plus','99','3100','iphone8plus.png','0',1,'128','3G'),(2,'iPhone 8 Plus','95','2700','iphone8plus.png','9',1,'128','3G'),(3,'iPhone 8 Plus','9','2400','iphone8plus.png','49',1,'128','3G'),(4,'iPhone 8 Plus','9','2800','iphone8plus.png','19',1,'256','3G'),(5,'iPhone 8 Plus','99','2900','iphone8plus.png','13',1,'64','3G'),(6,'iPhone X','99','3800','iphonex.png','65',1,'256','3G'),(7,'iPhone X','95','3500','iphonex.png','49',1,'256','3G'),(8,'iPhone X','9','2999','iphonex.png','19',1,'256','3G'),(9,'iPhone XS','99','4000','iphonexs.png','20',1,'256','4G'),(10,'iPhone XS','95','3800','iphonexs.png','70',1,'256','4G'),(11,'iPhone 11','99','3900','iphone11.png','14',1,'128','4G'),(12,'iPhone 11','95','3400','iphone11.png','21',1,'256','4G'),(13,'iPhone 11','95','2900','iphone11.png','39',1,'64','4G'),(14,'iPhone 11 Pro','99','4600','iphone11pro.png','47',1,'256','4G'),(15,'iPhone 11 Pro','99','4100','iphone11pro.png','16',1,'64','4G'),(16,'iPhone 11 Pro','95','4200','iphone11pro.png','42',1,'256','4G'),(17,'iPhone 11 Pro','9','3500','iphone11pro.png','31',1,'64','4G'),(18,'三星Note10+','99','4400','samsungnote10plus.png','15',2,'256','12G'),(19,'三星Note10+','95','3700','samsungnote10plus.png','27',2,'256','12G'),(20,'三星Note10+','8','2500','samsungnote10plus.png','48',2,'256','12G'),(21,'三星Note20 Ultra','99','5700','samsungnote20ultra.png','10',2,'512','12G'),(22,'三星Note20 Ultra','99','5100','samsungnote20ultra.png','5',2,'256','12G'),(23,'三星Note20 Ultra','95','5200','samsungnote20ultra.png','17',2,'512','12G'),(24,'三星Note20 Ultra','95','4900','samsungnote20ultra.png','29',2,'256','12G'),(25,'三星S20 Ultra','99','5600','samsungs20ultra.png','17',2,'512','16G'),(26,'三星S20 Ultra','99','5000','samsungs20ultra.png','14',2,'256','12G'),(27,'三星S20 Ultra','95','4700','samsungs20ultra.png','22',2,'256','12G'),(28,'华为Mate30 Pro','95','3700','huaweimate30pro.png','11',3,'128','8G'),(29,'华为Mate30 Pro','9','3500','huaweimate30pro.png','18',3,'256','8G'),(30,'华为P40','99','3100','huaweip40.png','17',3,'256','8G'),(31,'华为P40','99','2700','huaweip40.png','49',3,'128','8G'),(32,'华为Nova7 SE','95','1200','huaweinova7se.png','9',3,'64','8G'),(33,'华为Nova7 SE','8','1500','huaweinova7se.png','9',3,'256','8G'),(34,'小米10','99','2999','mi10.png','25',4,'256','8G'),(35,'小米10','95','2500','mi10.png','20',4,'256','8G'),(36,'小米10','9','1900','mi10.png','46',4,'128','8G'),(37,'小米10至尊纪念版','99','3500','mi10zhizun.png','19',4,'512','16G'),(38,'小米10至尊纪念版','95','3000','mi10zhizun.png','39',4,'512','16G'),(39,'OPPO Find X2','99','3500','oppofindx2.png','34',5,'256','8G'),(40,'OPPO Find X2','8','2000','oppofindx2.png','22',5,'256','8G'),(41,'OPPO Reno 4','99','1500','opporeno4.png','19',5,'128','8G'),(42,'OPPO ACE 2','99','2500','oppoace2.png','35',5,'256','8G'),(43,'OPPO ACE 2','95','2000','oppoace2.png','13',5,'256','8G'),(44,'OPPO ACE 2','95','1700','oppoace2.png','33',5,'128','8G'),(45,'ViVo X50 Pro Plus','99','4100','vivox50proplus.png','22',6,'256','8G'),(46,'ViVo X50 Pro Plus','95','3800','vivox50proplus.png','80',6,'256','8G'),(47,'ViVo X50 Pro Plus','95','3400','vivox50proplus.png','19',6,'256','8G'),(48,'ViVo X50 Pro Plus','9','2700','vivox50proplus.png','16',6,'128','8G'),(49,'ViVo Nex 3S','99','3900','vivonex3s.png','50',6,'256','8G'),(50,'ViVo Nex 3S','95','3500','vivonex3s.png','19',6,'256','8G'),(51,'ViVo Nex 3S','9','3000','vivonex3s.png','184',6,'256','8G'),(52,'ViVo Nex 3S','8','2700','vivonex3s.png','18',6,'256','8G'),(53,'ViVo IQOO5','99','3700','vivoiqoo5.png','22',6,'256','8G'),(54,'ViVo IQOO5','95','3000','vivoiqoo5.png','26',6,'128','8G'),(55,'ViVo IQOO5','8','2100','vivoiqoo5.png','50',6,'128','8G'),(56,'iPhone XS','9','3000','iphonexs.png','12',1,'256','3G'),(57,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(58,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(59,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(60,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(61,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(62,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(63,'iPhone XS','9','3000','iphonexs.png','19',1,'256','3G'),(64,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(65,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(66,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(67,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(68,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(69,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(70,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(71,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(72,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(73,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(74,'iPhone XS','9','3000','iphonexs.png','22',1,'256','3G'),(75,'iPhone XS','9','3000','iphonexs.png','21',1,'256','3G'),(76,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(77,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(78,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(79,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(80,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(81,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(82,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(83,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(84,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(85,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(86,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(87,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(88,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(89,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(90,'OPPO Find X2','9','3000','oppofindx2.png','19',5,'256','8G'),(91,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(92,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(93,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(94,'OPPO Find X2','9','3000','oppofindx2.png','20',5,'256','8G'),(95,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(96,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(97,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(98,'OPPO Find X2','9','3000','oppofindx2.png','20',5,'256','8G'),(99,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(101,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(102,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(103,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(104,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(105,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(106,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(107,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(108,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(109,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(110,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(111,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(112,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(113,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(114,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(115,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(116,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(117,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(118,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(119,'OPPO Find X2','9','3000','oppofindx2.png','20',5,'256','8G'),(120,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(121,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(122,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(123,'OPPO Find X2','9','3000','oppofindx2.png','21',5,'256','8G'),(124,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(125,'OPPO Find X2','9','3000','oppofindx2.png','22',5,'256','8G'),(126,'OPPO Find X2','9','3000','oppofindx2.png','19',5,'256','8G');

/*Table structure for table `tb_user` */

DROP TABLE IF EXISTS `tb_user`;

CREATE TABLE `tb_user` (
  `user_name` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user` */

insert  into `tb_user`(`user_name`,`password`,`email`) values ('a12345','aaaaa','ad@a.com'),('aaaaa','aaaaa','aaaaa@aaaaa.com'),('aaaaaa','aaaaa','aaaaaa@aaaaaa.com'),('aaaaaaa','dsasd','dsa@a.com'),('aaaaab','aaaaa','aaaaab@aaaaa.com'),('bbbbb','bbbbb','bbbbb@bbbbb.com'),('dsaaa','dsadsa','dsadsa@o.com'),('dsadsadsa','dsadssad','dsadsadsa@a.com'),('ewqew','ewqe','ewq@q.com'),('opopop','opopop','opopop@opopop.com'),('ppppp','ppppp','ppppp@ppppp.com'),('qweqwe','123123','a@dsa.com'),('qwqwqw','qwqwqw','qwqwqw@qwqwqw.com'),('testtest','testtest','testtest@163.com');

/*Table structure for table `tb_user_cart` */

DROP TABLE IF EXISTS `tb_user_cart`;

CREATE TABLE `tb_user_cart` (
  `user_name` varchar(255) NOT NULL COMMENT '用户名',
  `p_id` int(10) NOT NULL COMMENT '商品id',
  `p_num` int(11) NOT NULL COMMENT '商品数量',
  `user_address` varchar(255) NOT NULL COMMENT '用户地址',
  `p_img` varchar(255) NOT NULL COMMENT '商品图',
  `p_brand_describe` varchar(255) NOT NULL COMMENT '商品描述',
  `p_price` varchar(255) NOT NULL COMMENT '商品单价'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `tb_user_cart` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
