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
-- Dumping data for table `body_part`
--

LOCK TABLES `body_part` WRITE;
/*!40000 ALTER TABLE `body_part` DISABLE KEYS */;
INSERT INTO `body_part` VALUES (1,'Neck'),(2,'Shoulders'),(3,'Upper Arms'),(4,'Forearms'),(5,'Back'),(6,'Chest'),(7,'Waist'),(8,'Hips'),(9,'Thighs'),(10,'Calves'),(11,'Other Exercises');
/*!40000 ALTER TABLE `body_part` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `equipment`
--

LOCK TABLES `equipment` WRITE;
/*!40000 ALTER TABLE `equipment` DISABLE KEYS */;
/*!40000 ALTER TABLE `equipment` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `exercise`
--

LOCK TABLES `exercise` WRITE;
/*!40000 ALTER TABLE `exercise` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Exercise Classification.\n\nhttps://exrx.net/WeightTraining/Glossary';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exercise_classification`
--

LOCK TABLES `exercise_classification` WRITE;
/*!40000 ALTER TABLE `exercise_classification` DISABLE KEYS */;
INSERT INTO `exercise_classification` VALUES (1,'Basic','A principal exercise that can place greater absolute intensity on muscles exercised relative to auxiliary exercises. Basic exercises tend to have more of the following characteristics:\n\ngravity dependent\ninclusion or shift of resistance through multiple muscle group throughout the range of motion\n\ne.g. bench press: front deltoid to pectoralis major to triceps\n\nnatural transfer of torsion force to compression force (e.g., lockout on squat, bench press, etc.) or tension force (e.g. extension of arm curl) to the bone(s) and joint(s) during full range of motion\n\nAlso see angle of pull\n\ngravity dependent'),(2,'Auxiliary','An optional exercise that may supplement a basic exercise. Auxiliary exercises may place greater relative intensity on a specific muscle or a head of a muscle.Compound'),(3,'Compound','An exercise that involves two or more joint movements.'),(4,'Isolated','An exercise that involves just one discernible joint movement.\nPull'),(5,'Closed Chain','An exercise or movement in which the end segment of the exercised limb is fixed, or the end is supporting the weight. Most compound exercises are closed-chainmovements.'),(6,'Open Chain','An exercise or movement in which the end segment of the exercised limb is not fixed, or the end is not supporting the weight. Many isolated exercises are open-chain movements.'),(7,'Functional','An exercise which allows one to gain motor development or strength in a manner in which it is used in the execution of a particular task (eg: specific sport skill, occupational task, or daily activity).'),(8,'Push','Movement away from center of body during the concentric contraction of the target muscle. Isolated movements are classified by their compound counterparts.'),(9,'Pull','Movement toward center of body during the concentric contraction of the target muscle. Isolated movements are classified by their compound counterparts.');
/*!40000 ALTER TABLE `exercise_classification` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `exercise_comment`
--

LOCK TABLES `exercise_comment` WRITE;
/*!40000 ALTER TABLE `exercise_comment` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise_comment` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `exercise_related_classification`
--

LOCK TABLES `exercise_related_classification` WRITE;
/*!40000 ALTER TABLE `exercise_related_classification` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise_related_classification` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `exercise_related_muscle`
--

LOCK TABLES `exercise_related_muscle` WRITE;
/*!40000 ALTER TABLE `exercise_related_muscle` DISABLE KEYS */;
/*!40000 ALTER TABLE `exercise_related_muscle` ENABLE KEYS */;
UNLOCK TABLES;

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
-- Dumping data for table `kinesiology_glossary`
--

LOCK TABLES `kinesiology_glossary` WRITE;
/*!40000 ALTER TABLE `kinesiology_glossary` DISABLE KEYS */;
/*!40000 ALTER TABLE `kinesiology_glossary` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle.\n\nhttps://exrx.net/Lists/Muscle';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muscle`
--

LOCK TABLES `muscle` WRITE;
/*!40000 ALTER TABLE `muscle` DISABLE KEYS */;
INSERT INTO `muscle` VALUES (1,'Adductors','Inner Thigh',NULL,0),(2,'Biceps Brachii','Arm (Front),Biceps,Biceps Cubiti',NULL,0),(3,'Brachialis','Arm (Side),Lower Biceps',NULL,0),(4,'Brachioradialis','Forearm (Upper-outer),Supinator longus (out dated)',NULL,0),(5,'Deltoid',NULL,NULL,0),(6,'Anterior','Shoulder (Front),Front Delts',NULL,0),(7,'Lateral','Shoulder (Side),Side Delts',NULL,0),(8,'Posterior','Shoulder (Rear),Rear Delts',NULL,0),(9,'Deep Hip External Rotators','Six Deep Lateral Rotator Hip Muscles',NULL,0),(10,'Erector Spinae','Lower Back',NULL,0),(11,'Gastrocnemius','Calf',NULL,0),(12,'Gluteus',NULL,NULL,0),(13,'Maximus','Butt,Hips (Rear),Glutes',NULL,0),(14,'Medius','Hip,Hip Abductor',NULL,0),(15,'Minimus','Hip,Hip Abductor',NULL,0),(16,'Gracilis','Inner Thigh,Hip Adductor',NULL,0),(17,'Hamstrings','Thigh (Rear)',NULL,0),(18,'Iliopsoas','Hip,Hip Flexors',NULL,0),(19,'Infraspinatus','Rotatory Cuff,Back',NULL,0),(20,'Latissimus Dorsi','Back (Middle, Outer),Lats',NULL,0),(21,'Levator Scapulae','Shoulder (Upper),Neck (Rear)',NULL,0),(22,'Obliques','Hips (Upper),Waist (Sides),Obliques',NULL,0),(23,'Pectineous','Thigh (upper),Hip Flexors',NULL,0),(24,'Pectoralis Major',NULL,NULL,0),(25,'Clavicular Head','Chest (Upper),Upper Pecs',NULL,0),(26,'Sternal Head','Chest,Lower Pecs',NULL,0),(27,'Teres',NULL,NULL,0),(28,'Major','Back (Outer),Lats little helper',NULL,0),(29,'Minor','Rotatory Cuff,Back',NULL,0),(30,'Tibialis Anterior','Shin,Tibias,Tibialis Anticus',NULL,0),(31,'Transverse Abdominus','Transverse Abs',NULL,0),(32,'Trapezius',NULL,NULL,0),(33,'Lower Fibers','Back (Middle),Lower Traps',NULL,0),(34,'Middle Fibers','Back (Upper),Traps',NULL,0),(35,'Upper Fibers','Shoulder (Upper),Upper Traps',NULL,0),(36,'Triceps Brachii','Arm (Rear),Triceps',NULL,0),(37,'Wrist',NULL,NULL,0),(38,'Extensors','Forearm (outer or back),Hand Extensors',NULL,0),(39,'Flexors','Forearm (Inner),Hand Flexors',NULL,0),(40,'Pectoralis Minor','Chest,Shoulder',NULL,0),(41,'Popliteus','Knee flexor',NULL,0),(42,'Quadratus Lumborum','Deep Low Back Lateral Flexor',NULL,0),(43,'Quadriceps','Thigh (Front),Quads',NULL,0),(44,'Rectus Abdominis','Waist (Belly),Abdominal,Abs',NULL,0),(45,'Rhomboids','Back (Middle)',NULL,0),(46,'Sartorius','Thigh (Inner),Tailor\'s muscle,Longest muscle in body',NULL,0),(47,'Serratus Anterior','Serratus Magnus,Boxer\'s Muscle',NULL,0),(48,'Soleus','Calf,Soleus',NULL,0),(49,'Splenius','Neck (Rear),Neck Extensors',NULL,0),(50,'Sternocleidomastoid','Sterno-mastoid,Neck (Front / Sides),Neck Flexors',NULL,0),(51,'Subscapularis','Rotator Cuff,Back',NULL,0),(52,'Supraspinatus','Rotatory Cuff,Shoulder',NULL,0),(53,'Tensor Fasciae Latae','Hip,Hip Abductor/Flexor,Tensor Fasciae Femoris',NULL,0);
/*!40000 ALTER TABLE `muscle` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle Image.\n\nThe relationship:\nOne muscle to one or more muscle image.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `muscle_image`
--

LOCK TABLES `muscle_image` WRITE;
/*!40000 ALTER TABLE `muscle_image` DISABLE KEYS */;
INSERT INTO `muscle_image` VALUES (1,1,'upload/muscle-picture/adductors/AdductorAnteriorSmall.png','Adductors'),(2,1,'upload/muscle-picture/adductors/AdductorPosteriorSmall.png','Adductors'),(3,2,'upload/muscle-picture/biceps-brachii/BicepsInsideSmall.gif','Biceps Brachii'),(4,3,'upload/muscle-picture/brachialis/BrachialisInsideSmall.gif','Brachialis'),(5,3,'upload/muscle-picture/brachialis/BrachialisUpperArmSegmentSmall.gif','Brachialis'),(6,4,'upload/muscle-picture/brachioradialis/BrachioradialisoutsideSmall.png','Brachioradialis'),(7,6,'upload/muscle-picture/anterior/DeltoidAnteriorFront.gif','Anterior'),(8,7,'upload/muscle-picture/lateral/DeltoidLateralBack.gif','Lateral'),(9,8,'upload/muscle-picture/posterior/DeltoidPosteriorBack.gif','Posterior'),(10,9,'upload/muscle-picture/deep-hip-external-rotators/DeepHipRotators.gif','Deep Hip External Rotators'),(11,10,'upload/muscle-picture/erector-spinae/96a0e9eeb4ad8418eff179a9c59bc713.png','Erector Spinae'),(12,10,'upload/muscle-picture/erector-spinae/ErectorSpinaeCrossSection.gif','Erector Spinae'),(13,11,'upload/muscle-picture/gastrocnemius/GastrocnemiusLateral.gif','Gastrocnemius'),(14,13,'upload/muscle-picture/maximus/80a4754b254e159c4cd5474b063d096e.png','Maximus'),(15,14,'upload/muscle-picture/medius/GluteusMediusPosterior.gif','Medius'),(16,15,'upload/muscle-picture/minimus/bf94c6ef8b7ca1c02323779e1fe3b837.png','Minimus'),(17,15,'upload/muscle-picture/minimus/GluteusMinimusSide.gif','Minimus'),(18,16,'upload/muscle-picture/gracilis/69c90b7fb98b9c863015a90b3ff3173c.png','Gracilis'),(19,17,'upload/muscle-picture/hamstrings/1c94da8f4db345d0343c3db475d2d84d.png','Hamstrings'),(20,18,'upload/muscle-picture/iliopsoas/99beae51baa19dc3d8ef62c04b469133.png','Iliopsoas'),(21,18,'upload/muscle-picture/iliopsoas/ed4205586bfaf0b1603ad8e70dae6706.png','Iliopsoas'),(22,19,'upload/muscle-picture/infraspinatus/3e3d3ded3335c56a7f932c6e38a3ed53.png','Infraspinatus'),(23,20,'upload/muscle-picture/latissimus-dorsi/67f687e9482a2a6bca9a38544e45d31c.png','Latissimus Dorsi'),(24,20,'upload/muscle-picture/latissimus-dorsi/LatSmall.png','Latissimus Dorsi'),(25,21,'upload/muscle-picture/levator-scapulae/5083bc6f81d7a598832a5cb53340fb4a.png','Levator Scapulae'),(26,22,'upload/muscle-picture/obliques/1d421470bb1b8650b68a055d15704abe.png','Obliques'),(27,22,'upload/muscle-picture/obliques/ObliqueCrossSection.gif','Obliques'),(28,23,'upload/muscle-picture/pectineous/52d884ea5ad22f197b0335468e4ca6e7.png','Pectineous'),(29,25,'upload/muscle-picture/clavicular-head/11a9ea1af4fa3e206ec2eecc7e60100e.png','Clavicular Head'),(30,25,'upload/muscle-picture/clavicular-head/0e1ed54440e102b3ec973207ea371964.png','Clavicular Head'),(31,26,'upload/muscle-picture/sternal-head/5a6b344e7b8a52c715adf8b091461f7d.png','Sternal Head'),(32,26,'upload/muscle-picture/sternal-head/PectoralAttachmentSmall.png','Sternal Head'),(33,28,'upload/muscle-picture/major/TeresMajorSmall.png','Major'),(34,29,'upload/muscle-picture/minor/TeresMinorSmall.png','Minor'),(35,30,'upload/muscle-picture/tibialis-anterior/TibialisAnteriorSmall.png','Tibialis Anterior'),(36,31,'upload/muscle-picture/transverse-abdominus/TransverseAbdominisCrossSectionNew.jpg','Transverse Abdominus'),(37,33,'upload/muscle-picture/lower-fibers/TrapLowerHalfSmall.png','Lower Fibers'),(38,34,'upload/muscle-picture/middle-fibers/TrapMiddleHalfSmall.png','Middle Fibers'),(39,35,'upload/muscle-picture/upper-fibers/TrapUpperHalfSmall.png','Upper Fibers'),(40,36,'upload/muscle-picture/triceps-brachii/TricepsOutsideSmall.gif','Triceps Brachii'),(41,38,'upload/muscle-picture/extensors/WristExtensorsSupSmall.gif','Extensors'),(42,39,'upload/muscle-picture/flexors/WristFlexorNeutSmall.gif','Flexors'),(43,40,'upload/muscle-picture/pectoralis-minor/e7cda9218a2e2c84a31a7ca32e98c3a9.png','Pectoralis Minor'),(44,41,'upload/muscle-picture/popliteus/PopliteusSmall.png','Popliteus'),(45,42,'upload/muscle-picture/quadratus-lumborum/QuadratusLumborumSmall.png','Quadratus Lumborum'),(46,43,'upload/muscle-picture/quadriceps/QuadricepsAnteriorSmall.png','Quadriceps'),(47,44,'upload/muscle-picture/rectus-abdominis/RectusAbdominisWaistSmall.png','Rectus Abdominis'),(48,44,'upload/muscle-picture/rectus-abdominis/RectusAbdominalCrossSectionNew.jpg','Rectus Abdominis'),(49,45,'upload/muscle-picture/rhomboids/RhomboidsHalfSmall.png','Rhomboids'),(50,46,'upload/muscle-picture/sartorius/SartoriusAnteriorSmall.png','Sartorius'),(51,47,'upload/muscle-picture/serratus-anterior/SerratusAnteriorSideSmall.png','Serratus Anterior'),(52,47,'upload/muscle-picture/serratus-anterior/SerratusAnteriorPullSmall.png','Serratus Anterior'),(53,47,'upload/muscle-picture/serratus-anterior/SerratusScapulaTransverseCu.gif','Serratus Anterior'),(54,48,'upload/muscle-picture/soleus/SoleusLateralSmall.png','Soleus'),(55,49,'upload/muscle-picture/splenius/SpleniusSpineSmall.png','Splenius'),(56,49,'upload/muscle-picture/splenius/SpeniusHalfSmall.png','Splenius'),(57,50,'upload/muscle-picture/sternocleidomastoid/SternoSideSmall.png','Sternocleidomastoid'),(58,51,'upload/muscle-picture/subscapularis/SubscapularisSmall.png','Subscapularis'),(59,52,'upload/muscle-picture/supraspinatus/SupraspinatusBackSmall.png','Supraspinatus'),(60,53,'upload/muscle-picture/tensor-fasciae-latae/TensorFasciaeLataeASmall.png','Tensor Fasciae Latae');
/*!40000 ALTER TABLE `muscle_image` ENABLE KEYS */;
UNLOCK TABLES;

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
) ENGINE=InnoDB AUTO_INCREMENT=56 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='Muscle''s related muscles.';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `related_muscle`
--

LOCK TABLES `related_muscle` WRITE;
/*!40000 ALTER TABLE `related_muscle` DISABLE KEYS */;
INSERT INTO `related_muscle` VALUES (1,1,16),(2,2,3),(3,2,4),(4,3,2),(5,3,4),(6,4,3),(7,4,2),(8,10,49),(9,10,42),(10,11,48),(11,16,1),(12,16,17),(13,17,11),(14,17,46),(15,17,16),(16,18,46),(17,18,53),(18,21,45),(19,22,42),(20,22,44),(21,23,1),(22,23,18),(23,23,46),(24,23,53),(25,25,40),(26,26,40),(27,28,20),(28,29,19),(29,31,44),(30,31,22),(31,33,45),(32,34,45),(33,35,21),(34,40,47),(35,41,17),(36,42,22),(37,42,10),(38,43,18),(39,43,46),(40,43,53),(41,44,22),(42,45,32),(43,45,21),(44,45,47),(45,46,18),(46,46,53),(47,46,17),(48,47,40),(49,47,45),(50,48,11),(51,49,50),(52,49,10),(53,50,49),(54,53,18),(55,53,46);
/*!40000 ALTER TABLE `related_muscle` ENABLE KEYS */;
UNLOCK TABLES;

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

-- Dump completed on 2020-02-11  9:54:23
