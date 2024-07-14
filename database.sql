-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               8.0.30 - MySQL Community Server - GPL
-- Server OS:                    Win64
-- HeidiSQL Version:             12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for web_ban_do_dien_tu_spring
CREATE DATABASE IF NOT EXISTS `web_ban_do_dien_tu_spring` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `web_ban_do_dien_tu_spring`;

-- Dumping structure for table web_ban_do_dien_tu_spring.cartitems
CREATE TABLE IF NOT EXISTS `cartitems` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKt478n10exulquokvij432v5pi` (`productid`),
  KEY `FKt2r45rx0pr4l0lkg0tlk3wjtt` (`userid`),
  CONSTRAINT `FKt2r45rx0pr4l0lkg0tlk3wjtt` FOREIGN KEY (`userid`) REFERENCES `user` (`id`),
  CONSTRAINT `FKt478n10exulquokvij432v5pi` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.cartitems: ~0 rows (approximately)

-- Dumping structure for table web_ban_do_dien_tu_spring.category
CREATE TABLE IF NOT EXISTS `category` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.category: ~4 rows (approximately)
REPLACE INTO `category` (`id`, `name`) VALUES
	(1, 'Điều hòa'),
	(2, 'Tủ lạnh'),
	(3, 'máy giặt'),
	(4, 'Tivi');

-- Dumping structure for table web_ban_do_dien_tu_spring.orderdetail
CREATE TABLE IF NOT EXISTS `orderdetail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `price` float DEFAULT NULL,
  `quantity` int DEFAULT NULL,
  `orderid` int DEFAULT NULL,
  `productid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKgcotbta7ruggbobqttkev2cr5` (`orderid`),
  KEY `FKnj3aqevednxylkji40nl3kb61` (`productid`),
  CONSTRAINT `FKgcotbta7ruggbobqttkev2cr5` FOREIGN KEY (`orderid`) REFERENCES `orders` (`id`),
  CONSTRAINT `FKnj3aqevednxylkji40nl3kb61` FOREIGN KEY (`productid`) REFERENCES `product` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.orderdetail: ~2 rows (approximately)
REPLACE INTO `orderdetail` (`id`, `price`, `quantity`, `orderid`, `productid`) VALUES
	(1, 9000000, 2, 1, 12),
	(2, 9000000, 1, 2, 21),
	(3, 9000000, 1, 3, 12);

-- Dumping structure for table web_ban_do_dien_tu_spring.orders
CREATE TABLE IF NOT EXISTS `orders` (
  `id` int NOT NULL AUTO_INCREMENT,
  `orderdate` datetime(6) DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `userid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKdxew8n76x1bnoxjas0qxrlbq6` (`userid`),
  CONSTRAINT `FKdxew8n76x1bnoxjas0qxrlbq6` FOREIGN KEY (`userid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.orders: ~2 rows (approximately)
REPLACE INTO `orders` (`id`, `orderdate`, `status`, `userid`) VALUES
	(1, '2024-07-13 08:57:50.831014', 'done', 2),
	(2, '2024-07-13 09:02:28.962408', 'canceled', 2),
	(3, '2024-07-13 11:24:35.983183', 'ordered', 4);

-- Dumping structure for table web_ban_do_dien_tu_spring.product
CREATE TABLE IF NOT EXISTS `product` (
  `id` int NOT NULL AUTO_INCREMENT,
  `amount` int DEFAULT NULL,
  `description` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `img` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `price` float DEFAULT NULL,
  `status` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `categoryid` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4ort9abhumpx4t2mlngljr1vi` (`categoryid`),
  CONSTRAINT `FK4ort9abhumpx4t2mlngljr1vi` FOREIGN KEY (`categoryid`) REFERENCES `category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.product: ~41 rows (approximately)
REPLACE INTO `product` (`id`, `amount`, `description`, `img`, `name`, `price`, `status`, `categoryid`) VALUES
	(2, 12, 'sản phẩm chất lượng', '/img/may-lanh-am-tran-lg-ztnq24gpla0-1.jpg', 'điều hòa nagakawa1', 9000000, '', 1),
	(3, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa2', 9000000, NULL, 1),
	(4, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa3', 9000000, NULL, 1),
	(5, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa4', 9000000, NULL, 1),
	(6, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa5', 9000000, NULL, 1),
	(7, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa6', 9000000, NULL, 1),
	(8, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa7', 9000000, NULL, 1),
	(9, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa8', 9000000, NULL, 1),
	(10, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa9', 9000000, NULL, 1),
	(11, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa nagakawa10', 9000000, NULL, 1),
	(12, 12, 'sản phẩm chất lượng', '/img/may-lanh-am-tran-nagakawa-5-hp-nt-1.jpg', 'điều hòa daikin1', 9000000, '', 1),
	(13, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin2', 9000000, NULL, 1),
	(14, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin3', 9000000, NULL, 1),
	(15, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin4', 9000000, NULL, 1),
	(16, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin5', 9000000, NULL, 1),
	(17, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin6', 9000000, NULL, 1),
	(18, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin7', 9000000, NULL, 1),
	(19, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin8', 9000000, NULL, 1),
	(20, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin9', 9000000, NULL, 1),
	(21, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa daikin10', 9000000, NULL, 1),
	(22, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic1', 10000000, NULL, 1),
	(23, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic2', 10000000, NULL, 1),
	(24, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic3', 10000000, NULL, 1),
	(25, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic4', 10000000, NULL, 1),
	(26, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic5', 10000000, NULL, 1),
	(27, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic6', 10000000, NULL, 1),
	(28, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic7', 10000000, NULL, 1),
	(29, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic8', 10000000, NULL, 1),
	(30, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic9', 10000000, NULL, 1),
	(31, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa panasonic10', 10000000, NULL, 1),
	(32, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki1', 8000000, NULL, 1),
	(33, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki2', 8000000, NULL, 1),
	(34, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki3', 8000000, NULL, 1),
	(35, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki4', 8000000, NULL, 1),
	(36, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki5', 8000000, NULL, 1),
	(37, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki6', 8000000, NULL, 1),
	(38, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki7', 8000000, NULL, 1),
	(39, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki8', 8000000, NULL, 1),
	(40, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki9', 8000000, NULL, 1),
	(41, 12, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', 'điều hòa funiki10', 8000000, NULL, 1),
	(42, 12, 'fadf', '/img/may-lanh-am-tran-lg-ztnq24gpla0-1.jpg', 'java', 30000000, 'canceled', 1);

-- Dumping structure for table web_ban_do_dien_tu_spring.role
CREATE TABLE IF NOT EXISTS `role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.role: ~2 rows (approximately)
REPLACE INTO `role` (`id`, `role`) VALUES
	(1, 'CUSTOMER'),
	(2, 'ADMIN');

-- Dumping structure for table web_ban_do_dien_tu_spring.user
CREATE TABLE IF NOT EXISTS `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.user: ~2 rows (approximately)
REPLACE INTO `user` (`id`, `address`, `email`, `enabled`, `name`, `password`, `phone`, `username`) VALUES
	(1, 'hanoi', 'A@gmail.com', b'1', 'Nguyễn Văn A', '$2a$10$JnxdyBD03eGeLxXMnPK2KOpeG0W60FBxJ3QnXCbPF4cw5dyUAfDsq', '078967813', 'admin'),
	(2, 'hanoi', 'mai@gmail.com', b'1', 'mai nguyen thi', '$2a$10$JnxdyBD03eGeLxXMnPK2KOpeG0W60FBxJ3QnXCbPF4cw5dyUAfDsq', '078967813', 'mai'),
	(4, 'hanoi', NULL, b'1', 'java', '$2a$10$DNybDQrtrbkV3G0ZD2NnRuT/15mziU1jq/7YYfb/Aq1MpZc4BGBdO', '0358028926', 'manh');

-- Dumping structure for table web_ban_do_dien_tu_spring.user_role
CREATE TABLE IF NOT EXISTS `user_role` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`),
  KEY `FK859n2jvi8ivhui0rl0esws6o` (`user_id`),
  CONSTRAINT `FK859n2jvi8ivhui0rl0esws6o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Dumping data for table web_ban_do_dien_tu_spring.user_role: ~2 rows (approximately)
REPLACE INTO `user_role` (`user_id`, `role_id`) VALUES
	(1, 2),
	(2, 1),
	(4, 1);

-- Dumping structure for procedure web_ban_do_dien_tu_spring.while_loop
DELIMITER //
CREATE PROCEDURE `while_loop`()
BEGIN
    DECLARE counter INT DEFAULT 0;

    WHILE counter < 10 DO
        SET counter = counter + 1;
        -- Thực hiện các thao tác khác tại đây        
        INSERT INTO product(amount, categoryid, price, DESCRIPTION, img, name)
        VALUES(12, 1, 9000000, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', CONCAT('điều hòa nagakawa', counter));
    END WHILE;
END//
DELIMITER ;

-- Dumping structure for procedure web_ban_do_dien_tu_spring.while_loop1
DELIMITER //
CREATE PROCEDURE `while_loop1`()
BEGIN
    DECLARE counter INT DEFAULT 0;

    WHILE counter < 10 DO
        SET counter = counter + 1;
        -- Thực hiện các thao tác khác tại đây        
        INSERT INTO product(amount, categoryid, price, DESCRIPTION, img, name)
        VALUES(12, 1, 9000000, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', CONCAT('điều hòa daikin', counter));
    END WHILE;
END//
DELIMITER ;

-- Dumping structure for procedure web_ban_do_dien_tu_spring.while_loop2
DELIMITER //
CREATE PROCEDURE `while_loop2`()
BEGIN
    DECLARE counter INT DEFAULT 0;

    WHILE counter < 10 DO
        SET counter = counter + 1;
        -- Thực hiện các thao tác khác tại đây        
        INSERT INTO product(amount, categoryid, price, DESCRIPTION, img, name)
        VALUES(12, 1, 10000000, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', CONCAT('điều hòa panasonic', counter));
    END WHILE;
END//
DELIMITER ;

-- Dumping structure for procedure web_ban_do_dien_tu_spring.while_loop3
DELIMITER //
CREATE PROCEDURE `while_loop3`()
BEGIN
    DECLARE counter INT DEFAULT 0;

    WHILE counter < 10 DO
        SET counter = counter + 1;
        -- Thực hiện các thao tác khác tại đây        
        INSERT INTO product(amount, categoryid, price, DESCRIPTION, img, name)
        VALUES(12, 1, 8000000, 'sản phẩm chất lượng', '/img/dieu-hoa-nagakawa.jpg', CONCAT('điều hòa funiki', counter));
    END WHILE;
END//
DELIMITER ;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
