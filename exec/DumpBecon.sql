-- MySQL dump 10.13  Distrib 8.0.25, for Win64 (x86_64)
--
-- Host: 3.36.67.58    Database: ssafy_web_db
-- ------------------------------------------------------
-- Server version	5.7.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `concert`
--

DROP TABLE IF EXISTS `concert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `end_time` varchar(255) DEFAULT NULL,
  `is_active` int(1) DEFAULT NULL,
  `price_stand` int(11) DEFAULT NULL,
  `price_vip` int(11) DEFAULT NULL,
  `start_time` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `category_id` bigint(20) DEFAULT NULL,
  `thumbnail_id` bigint(20) DEFAULT NULL,
  `owner_id` bigint(20) DEFAULT NULL,
  `min_age` int(11) DEFAULT NULL,
  `poster_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKokjbyhr55butef4uisqtbh1c` (`category_id`),
  KEY `FKfr8ahllyfo5oyuocei3frim7a` (`thumbnail_id`),
  KEY `FKgijck1akuttcymxqhfd53bdyp` (`owner_id`),
  KEY `FK71jxk89nykyd3fh2thkwi1p54` (`poster_id`),
  CONSTRAINT `FK71jxk89nykyd3fh2thkwi1p54` FOREIGN KEY (`poster_id`) REFERENCES `concert_poster` (`id`),
  CONSTRAINT `FKfr8ahllyfo5oyuocei3frim7a` FOREIGN KEY (`thumbnail_id`) REFERENCES `concert_thumbnail` (`id`),
  CONSTRAINT `FKgijck1akuttcymxqhfd53bdyp` FOREIGN KEY (`owner_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKokjbyhr55butef4uisqtbh1c` FOREIGN KEY (`category_id`) REFERENCES `concert_category` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert`
--

LOCK TABLES `concert` WRITE;
/*!40000 ALTER TABLE `concert` DISABLE KEYS */;
INSERT INTO `concert` VALUES (96,'MSG워너비의 김정수가 아닌 본캐 \'록 황태자 김정민\'의 단독콘서트. \'마지막 약속\', \'무한지애\', \'마지막 사랑\'. \'슬픈 언약식\', \'붐붐붐\' 등 주옥같은 히트곡 록 발라드 레전드 가수인 김정민의 명불허전 라이브 무대로 90년대 추억을 소환합니다.','2021-08-21 15:30',0,700,1100,'2021-08-21 13:00','2021 김정민 단독콘서트',3,96,31,0,25),(97,'보고 싶고, 듣고 싶고, 즐기고 싶고, 그래서 그_냥 BLUE SUMMER 콘서트\n최근 웹툰 \'연애혁명\' OST에 참여하며 열일 중인 그_냥님의 목소리를 가까이에서 들을 수 있는 시간!\n데뷔 6주년을 맞이하며 팬분들을 위한 특별한 토크 콘서트를 준비했습니다. 단 하루, 1부와 2부 전혀 다른 컨셉으로 준비될 이번 스페셜 콘서트에 많은 기대 부탁드립니다.','2021-08-23 14:10',0,5000,7700,'2021-08-23 13:00','그_냥 BLUE SUMMER 콘서트',3,97,30,0,26),(98,'ADOY x dosii 함께하는 짜릿한 공연 지금바로 함께하세요','2021-08-24 21:00',0,500,1000,'2021-08-24 18:00','ADOY x dosii ',2,98,32,0,27),(99,'특유의 음색으로 노래하는 음유시인 최백호\n2021년 가을, 그의 목소리에서 인생의 파노라마가 펼쳐진다.\n노래 인생 44년을 맞이한 가수 최백호가 인생의 수많은 계단을 지나온 시민들과 호흡하는 시간을 마련한다.','2021-08-21 17:30',0,5000,7000,'2021-08-21 16:00','최백호 콘서트 〈낭만〉 - 하남',3,99,30,15,28),(100,'2021년 가장 핫한 아티스트를 셀렉하는\n가장 트렌디한 콘서트, ［Select Shop Concert; 셀렉콘］.\n매회 두 하이엔드 아티스트들이 ［셀렉콘］에 찾아옵니다.','2021-08-21 16:00',0,900,1200,'2021-08-21 13:30','SELECT SHOP〈십센치 X 윤딴딴〉콘서트 - 대구',4,100,31,12,29),(101,'다채로운 퍼포먼스와 강렬하고 독특한 음색을 가진 알리!\n압도적인 가창력으로 장르를 넘나드는 국내 최고 디바,\n알리의 콘서트가 2년만에 돌아옵니다.\n그녀의 음악 인생 ‘에세이’를 녹여낸 최고의 라이브 무대를 기대해주세요','2021-08-20 18:00',0,500,1500,'2021-08-20 15:00','2021 알리 콘서트 essay 에세이',3,101,32,12,30),(102,'페르시아의 왕자! 인도의 향불! 아리조나의 카우보이! 이름만 들어도 로망이 느껴지는 환상의 세계로 시간여행을 떠난다. 1950년대에 유행했던 이국풍 고전가요를 재조명하며 평범한 일상을 이국의 정취로 물들일 \'판타지\'를 선사한다.','2021-08-21 15:30',0,4000,5000,'2021-08-21 14:00','고래야〈판타지아1950〉 - 구리',1,102,30,0,31),(103,'새로운 음악과 함께\n돌아올 ‘넬(NELL)’의 계절.\n당연하게만 느껴졌던\n일상의 소소함들이 더욱 그리워지는 순간.\n우리가 함께 나누지 못했던\n비워진 일상의 행복한 순간들을 다시 채워줄 시간,\n새롭게 발매될 넬(NELL)의\n신곡과 함께\n그 소중한 순간을 당신과 함께하고 싶습니다.\n2021년 밴드 넬(NELL)의 첫 단독 콘서트.\nNELL’S SEASON 2021\n‘Moments in between’','2021-08-21 11:20',0,1000,1000,'2021-08-21 09:00','NELL’S SEASON 2021 ‘Moments in between',3,104,32,12,33),(104,'가슴 두근거릴 수밖에 없는 목소리를 가진 Zion.T와 WONSTEIN의 기분 좋아지는 섞임!\nZion.T ＆ WONSTEIN BLENDING CONCERT!','2021-08-20 17:00',0,1000,2000,'2021-08-20 14:00','자이언티 원슈타인 콘서트 울산',2,105,32,0,34),(105,'강한 중독성의 압도적인 사운드, 야성미 넘치는 강렬한 퍼포먼스\n덴마크 출신의 팝 프린스 크리스토퍼(Christopher) 내한공연 2020!\n강한 중독성의 압도적인 사운드, 야성미 넘치는 강렬한 퍼포먼스로 열광적인 반응을 이끌어낸 팝 프린스 ‘크리스토퍼(Christopher)’가 지난 공연 이후, 뜨거운 요청에 따라 3월 26일 내한공연을 드디어 확정했다.','2021-08-20 16:30',0,500,700,'2021-08-20 14:30','크리스토퍼 내한공연',1,108,31,12,37),(106,'＂이승환 음악은 항상 진화하고 있어, 멈춘 적이 없지“ ＂21세기 음악, ＇어떻게 사랑이 그래요＇도 듣고 싶어＂\n모두를 만족시킬 공연, 거리두기좌석제 콘서트 <이십세기 이승환 +>','2021-08-20 18:19',0,1000,2000,'2021-08-20 16:19','거리두기좌석제 콘서트 이십세기 이승환',2,109,32,0,38),(107,'강민주의 시연 SHOW SHOW SHOW','2021-08-20 05:30',3,200,500,'2021-08-20 05:18','시연 SHOW',1,110,31,0,39),(108,'오직 국민들을 위하여 15년만에 대한민국 어게인 언택트 공연으로 방송 출연!','2021-08-20 05:49',0,100,200,'2021-08-20 05:45','강민주의 시연 SHOW',4,111,33,12,40);
/*!40000 ALTER TABLE `concert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_category`
--

DROP TABLE IF EXISTS `concert_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_category` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_category`
--

LOCK TABLES `concert_category` WRITE;
/*!40000 ALTER TABLE `concert_category` DISABLE KEYS */;
INSERT INTO `concert_category` VALUES (1,'HIPHOP'),(2,'ZAZZ'),(3,'BALAD'),(4,'DANCE');
/*!40000 ALTER TABLE `concert_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_poster`
--

DROP TABLE IF EXISTS `concert_poster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_poster` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `origin_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_poster`
--

LOCK TABLES `concert_poster` WRITE;
/*!40000 ALTER TABLE `concert_poster` DISABLE KEYS */;
INSERT INTO `concert_poster` VALUES (25,'5e75c4c5330ac913aa079b7478545026','kimjungmin.png','/images/poster/kimjungmin.png'),(26,'852ea9e3575d3873e976e6d8352bb970','just.png','/images/poster/just.png'),(27,'417c9349173c0bfda357a47a7bb4ce69','1-1.PNG','/images/poster/1-1.PNG'),(28,'c3ee980675cee195f46364d8ec3adfae','choi.png','/images/poster/choi.png'),(29,'8ec3a1e9eb1d11f6611a625cd8a95d09','10cm.png','/images/poster/10cm.png'),(30,'4c8df90d29764108b6b980d137582815','2-1.PNG','/images/poster/2-1.PNG'),(31,'b116a36cb824026d99adac76a05ee4d7','whale.png','/images/poster/whale.png'),(32,'170459546380433c164448e3f21bed7e','christopher.jpg','/images/poster/christopher.jpg'),(33,'45b8b2d39ecd57a3a76125ce608f35ed','3-1.PNG','/images/poster/3-1.PNG'),(34,'780739c499ae4f9d2c5ba7d3eefe6f0d','4-1.PNG','/images/poster/4-1.PNG'),(35,'170459546380433c164448e3f21bed7e','christopher.jpg','/images/poster/christopher.jpg'),(36,'170459546380433c164448e3f21bed7e','christopher.jpg','/images/poster/christopher.jpg'),(37,'170459546380433c164448e3f21bed7e','christopher.jpg','/images/poster/christopher.jpg'),(38,'4ae831558b4a41f2b1a20c90a7127bcf','5-1.PNG','/images/poster/5-1.PNG'),(39,'516a08d53cad57c554645fc4be7b4778','poster.jpg','/images/poster/poster.jpg'),(40,'516a08d53cad57c554645fc4be7b4778','poster.jpg','/images/poster/poster.jpg');
/*!40000 ALTER TABLE `concert_poster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `concert_thumbnail`
--

DROP TABLE IF EXISTS `concert_thumbnail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `concert_thumbnail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `origin_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=112 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `concert_thumbnail`
--

LOCK TABLES `concert_thumbnail` WRITE;
/*!40000 ALTER TABLE `concert_thumbnail` DISABLE KEYS */;
INSERT INTO `concert_thumbnail` VALUES (96,'c3d45cf37678825052f9d07dd6a18727','김정민.PNG','/images/thumbnail/김정민.PNG'),(97,'23a8816ebbd02a3ecac8b412ff9bd9fe','just_thum.PNG','/images/thumbnail/just_thum.PNG'),(98,'69bba4902e6154b4bb3b01c6731ddadd','1-2.PNG','/images/thumbnail/1-2.PNG'),(99,'c7ae3a84dcc75e1ed7f3bb77adfc8fed','choi_thum.PNG','/images/thumbnail/choi_thum.PNG'),(100,'c28bfa0416bcfd31e58ecead66cf5086','10cm.PNG','/images/thumbnail/10cm.PNG'),(101,'451392e54d4c611896aa1b6fe9e8c16e','2-2.PNG','/images/thumbnail/2-2.PNG'),(102,'cbd2550ed74785085b3f7bc8848ee2b8','panta.PNG','/images/thumbnail/panta.PNG'),(103,'11c1d1fd0ed40e878a04a6fab91e5a82','크리스토퍼.PNG','/images/thumbnail/크리스토퍼.PNG'),(104,'03c06148e8ef71e1c5cda60880ed6e05','3-2.PNG','/images/thumbnail/3-2.PNG'),(105,'f0a77ee1b16f36c8088abbb15dcb4e5f','4-2.PNG','/images/thumbnail/4-2.PNG'),(106,'11c1d1fd0ed40e878a04a6fab91e5a82','크리스토퍼.PNG','/images/thumbnail/크리스토퍼.PNG'),(107,'11c1d1fd0ed40e878a04a6fab91e5a82','크리스토퍼.PNG','/images/thumbnail/크리스토퍼.PNG'),(108,'11c1d1fd0ed40e878a04a6fab91e5a82','크리스토퍼.PNG','/images/thumbnail/크리스토퍼.PNG'),(109,'98545d8ecd79476bbf528e7890c51ba7','5-2.PNG','/images/thumbnail/5-2.PNG'),(110,'eff33504db0a29a838b8513d2e2d4da6','thumbNail.PNG','/images/thumbnail/thumbNail.PNG'),(111,'eff33504db0a29a838b8513d2e2d4da6','thumbNail.PNG','/images/thumbnail/thumbNail.PNG');
/*!40000 ALTER TABLE `concert_thumbnail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `email`
--

DROP TABLE IF EXISTS `email`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `email` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `code` varchar(255) DEFAULT NULL,
  `user_email` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=78 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `email`
--

LOCK TABLES `email` WRITE;
/*!40000 ALTER TABLE `email` DISABLE KEYS */;
INSERT INTO `email` VALUES (74,'UQ5KIGYFHI','wlsgmd1535@naver.com','heung'),(75,'C77YKW4QBA','honey1696@naver.com','honey1696'),(76,'ZLH55TSPHC','cherrykang97@naver.com','alswn8972'),(77,'J9E3540XZT','cherrykang97@naver.com','alswn9798');
/*!40000 ALTER TABLE `email` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `buy_date` varchar(255) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `concert_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjopj22j9q92hs2kpi0l8bt3gs` (`concert_id`),
  KEY `FKdvt57mcco3ogsosi97odw563o` (`user_id`),
  CONSTRAINT `FKdvt57mcco3ogsosi97odw563o` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
  CONSTRAINT `FKjopj22j9q92hs2kpi0l8bt3gs` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (18,'2021-08-20 04:25:38','3ER9O7378N',1100,'VIP',96,31),(19,'2021-08-20 04:37:13','5OPR35C83J',1500,'VIP',101,31),(20,'2021-08-20 05:15:58','5CKT8DRJ6A',500,'VIP',107,30),(21,'2021-08-20 05:16:27','91KL81H5SN',500,'VIP',107,32),(22,'2021-08-20 05:43:54','3H3W4DI457',1100,'VIP',96,33);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL,
  `user_profile_id` bigint(20) DEFAULT NULL,
  `carrier` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKjjes1f6tjhqns02054ou51m00` (`user_profile_id`),
  CONSTRAINT `FKjjes1f6tjhqns02054ou51m00` FOREIGN KEY (`user_profile_id`) REFERENCES `user_profile` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (30,'wlsgmd1535@naver.com','안진흥','$2a$10$99v10mR3VVYzHArGOWi.3.l.cGTAAgav0IakI5NuKK1sIu1.XE3fe','010-2438-4535','heung',30,'LGT'),(31,'cherrykang97@naver.com','강민주','$2a$10$w5S4ahE1V5gxkoWZvMj/8.i7kBNCERi3zUEfsRpev53SR90DEvmxe','010-5137-8979','alswn8972',31,'SKT'),(32,'honey1696@naver.com','권준엽','$2a$10$e4l4VYh0KEJJj.cp2ka1yOMSzBPSEr2JoSYeggiPdGhotSKfKrbQq','010-9954-1696','honey1696',32,'KTF'),(33,'cherrykang97@naver.com','강민주당','$2a$10$0t1ibLvbBNbrM7jCby3BUejwjPf9rKlMPtgbFYYjfkaT1pznEMUwO','010-5137-8979','alswn9798',33,'SKT');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_concert`
--

DROP TABLE IF EXISTS `user_concert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_concert` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `concert_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKklbobfl83w3cf2ao02w64ip1o` (`concert_id`),
  KEY `FKmv1rlbyo8wrutvhefdo0yij3p` (`user_id`),
  CONSTRAINT `FKklbobfl83w3cf2ao02w64ip1o` FOREIGN KEY (`concert_id`) REFERENCES `concert` (`id`),
  CONSTRAINT `FKmv1rlbyo8wrutvhefdo0yij3p` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_concert`
--

LOCK TABLES `user_concert` WRITE;
/*!40000 ALTER TABLE `user_concert` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_concert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_profile`
--

DROP TABLE IF EXISTS `user_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user_profile` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `origin_name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_profile`
--

LOCK TABLES `user_profile` WRITE;
/*!40000 ALTER TABLE `user_profile` DISABLE KEYS */;
INSERT INTO `user_profile` VALUES (30,'53f7395f2c16b4573edcb3ed18778717','img.jpg','/images/profile/heung.png'),(31,'e6ddbaa40e957c007050197603a7048a','dog.jpg','/images/profile/dog.jpg'),(32,'e810f995c10f56972067833fb5514e7c','KakaoTalk_20210819_170712879.jpg','/images/profile/honey1696.png'),(33,'d1ca387494e064df81e83d585c10802c','photo (2).jpg','/images/profile/alswn9798.png');
/*!40000 ALTER TABLE `user_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ssafy_web_db'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-20  9:27:37
