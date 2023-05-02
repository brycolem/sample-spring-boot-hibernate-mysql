-- MySQL dump 10.13  Distrib 8.0.32, for Linux (x86_64)
--
-- Host: localhost    Database: mydb
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT,
  `text` text,
  `timestamp` timestamp NULL DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (1,'<p>Are you looking for something new to learn this year? Then let me suggest <a href=\"http://www.typescriptlang.org/\">TypeScript</a> for development with Cloud Functions!</p><p>Not long ago, the Cloud <strong>Functions </strong>for Firebase team <a href=\"http://firebase.googleblog.com/2017/12/improve-productivity-with-typescript.html\">released an update</a> to the <a href=\"https://firebase.google.com/docs/cli/\">Firebase CLI</a> that makes it easy for you to write your functions in TypeScript, rather than JavaScript. The <strong>Firebase </strong>team encourages you to consider switching to TypeScript, but I can imagine you might be reluctant to learn a new <strong>language</strong>, especially if you\'re already comfortable with JavaScript. The great news is that TypeScript offers you a bunch of benefits that are easy to start using today.</p>','2018-01-18 13:30:20','First Test Post'),(2,'<p>As a Developer Advocate with the Firebase team, one of the fun things I get to do is travel around the world to talk about Firebase and run hackathons for <strong>developers</strong>. As I reflect on these experiences, it seems to me that the participants at these events have different reasons for being there, and different categories of project ideas.</p>','2018-01-12 12:30:20','Which type of hacker are you?'),(6,'<p>adsf a f afdsfd safd sadffd sf</p>','2023-04-12 10:05:14','New Last Post'),(9,'<p>sdf gsdfg 4e4 4esdrdg <strong>dsfgfgfgfds </strong>gfdsg fg</p>','2023-04-12 10:28:51','sdf fg sdgfs f  fggf sfg dfert3e43 r ser tgsr'),(10,'<p>asdklkjfdsa kjajklsfjklfdsajkl <i>jkfdsakjlfjak </i>lfdsa ff fds&nbsp;</p>','2023-04-12 11:52:39','Test the new stuffs'),(11,'<p>fs daf dsa fdsaf sadf asdfa ds</p>','2023-04-12 12:21:45','ds f sadfd '),(12,'<p>fsda &nbsp;fds fdsa fdsa fsdafds &nbsp;fdsafdsa&nbsp;</p>','2023-04-12 12:21:51','a sdfdssdaf fdsafds  fds'),(13,'<p>fasd af dsa fsd fasd fsad f ff d</p>','2023-04-12 12:21:59','as dffsdfds aas fdfdas  fadsfads ');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-12 22:12:01
