-- MySQL dump 10.13  Distrib 8.0.18, for macos10.14 (x86_64)
--
-- Host: 127.0.0.1    Database: exercise_dictionary
-- ------------------------------------------------------
-- Server version	8.0.19

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
-- Table structure for table `body_part`
--

DROP TABLE IF EXISTS `body_part`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `body_part` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of body part.',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name of body part.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `body_part_name_uindex` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Human Body Part.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `equipment`
--

DROP TABLE IF EXISTS `equipment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise equipment.',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name of equipment.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `equipment_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Equipment.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exercise`
--

DROP TABLE IF EXISTS `exercise`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise.',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name of exercise.',
  `preparation` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exercise preparation description.',
  `execution` varchar(800) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'Exercise execution description.',
  `exercise_gif_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'Exercise GIF image path.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `exercise_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise.\n\nhttps://exrx.net/Lists/Directory';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exercise_classification`
--

DROP TABLE IF EXISTS `exercise_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_classification` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise classification.',
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name of exercise classification.',
  `description` varchar(1000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The description of exercise classification.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `exercise_classification_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Classification.\n\nhttps://exrx.net/WeightTraining/Glossary';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exercise_comment`
--

DROP TABLE IF EXISTS `exercise_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_comment` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise comment.',
  `exercise_id` bigint unsigned NOT NULL COMMENT 'The ID of exercise.',
  `comment` varchar(2500) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The comment.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `exercise_comment_exercise_id_uindex` (`exercise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Comment.\n\nRelationship:\nOne exercise to one comment.\n\nIf the exercise doen''t have comment,\nthen this table will still store the comment record for it,\nlike { id: 1, exercise_id: 1, comment: ''NONE'' }.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exercise_related_classification`
--

DROP TABLE IF EXISTS `exercise_related_classification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_related_classification` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise related classification.',
  `exercise_id` bigint unsigned NOT NULL COMMENT 'The ID of exercise.',
  `exercise_classification_id` bigint unsigned NOT NULL COMMENT 'The exercise classification ID.',
  `related_classification_type` tinyint NOT NULL COMMENT '1 - Utility, 2 - Mechanics, 3 - Force',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Related Classification.\n\nRelationship:\nOne exercise usually mapping to 3 types of exercise classification.\nAnd one exercise can have more than one specific type of classification.\n\nFor example:\nOne exercise can have 2 records whose types are both Utility.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `exercise_related_muscle`
--

DROP TABLE IF EXISTS `exercise_related_muscle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `exercise_related_muscle` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of exercise related muscle.',
  `exercise_id` bigint unsigned NOT NULL COMMENT 'The ID of exercise.',
  `muscle_id` bigint unsigned NOT NULL COMMENT 'The ID of muscle.',
  `related_muscle_type` tinyint NOT NULL COMMENT 'Related muscle type. Muscle movement classification.\n\n1 - Agonist\n2 - Antagonist\n3 - Target\n4 - Synergist\n5 - Stabilizer\n6 - Dynamic Stabilizer\n7 - Antagonist Stabilizer\n\nhttps://exrx.net/Kinesiology/Glossary#MuscleMovClass',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Related Muscle.\n\nRelationship:\nOne exercise can have 3 (or more) different types of related muscle.\nAnd one exercise can have more than one specific type of related muscles.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `kinesiology_glossary`
--

DROP TABLE IF EXISTS `kinesiology_glossary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kinesiology_glossary` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of kinesiology glossary.',
  `name` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name kinesiology glossary.',
  `description` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'The description of kinesiology glossary.',
  `parent_id` bigint unsigned DEFAULT NULL COMMENT 'The parent ID of kinesiology glossary.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `kinesiology_glossary_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Kinesiology Glossary.\n\nhttps://exrx.net/Kinesiology/Glossary';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `muscle`
--

DROP TABLE IF EXISTS `muscle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muscle` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of muscle.',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The name of muscle.',
  `other_names` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'The muslce''s other names.',
  `parent_id` bigint unsigned DEFAULT NULL COMMENT 'The parent ID of muscle.',
  `body_part_id` bigint unsigned NOT NULL COMMENT 'Related body part ID.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `muscle_name_uindex` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle.\n\nhttps://exrx.net/Lists/Muscle';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `muscle_image`
--

DROP TABLE IF EXISTS `muscle_image`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `muscle_image` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of muscle image.',
  `muscle_id` bigint unsigned NOT NULL COMMENT 'The ID of muslce.',
  `image_path` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'The image path of muscle image.',
  `alternative_text` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'A textual description of the image.',
  PRIMARY KEY (`id`),
  UNIQUE KEY `muscle_image_image_path_uindex` (`image_path`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle Image.\n\nThe relationship:\nOne muscle to one or more muscle image.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `related_muscle`
--

DROP TABLE IF EXISTS `related_muscle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `related_muscle` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT 'The ID of related muscle.',
  `muscle_id` bigint unsigned NOT NULL COMMENT 'The ID of muscle.',
  `related_muscle_id` bigint unsigned NOT NULL COMMENT 'Related muscle''s ID.',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle''s related muscles.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `test_table`
--

DROP TABLE IF EXISTS `test_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_table` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT,
  `string_value` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `int_value` int DEFAULT NULL,
  `double_value` double DEFAULT NULL,
  `datetime_value` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Test Table for ORM library.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_table`
--

LOCK TABLES `test_table` WRITE;
/*!40000 ALTER TABLE `test_table` DISABLE KEYS */;
INSERT INTO `test_table` VALUES (1,'Hello',12,12.2,'2020-01-10 14:23:33');
/*!40000 ALTER TABLE `test_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-11  9:55:46
