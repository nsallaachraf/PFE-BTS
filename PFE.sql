/*
 Navicat Premium Data Transfer

 Source Server         : MySQL
 Source Server Type    : MySQL
 Source Server Version : 50723
 Source Host           : localhost:8889
 Source Schema         : Project

 Target Server Type    : MySQL
 Target Server Version : 50723
 File Encoding         : 65001

 Date: 04/02/2019 09:45:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for Amis
-- ----------------------------
DROP TABLE IF EXISTS `Amis`;
CREATE TABLE `Amis` (
  `idEmetteur` int(10) NOT NULL,
  `idRecepteur` int(10) NOT NULL,
  `statutAmis` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEmetteur`,`idRecepteur`),
  KEY `FKAmis161455` (`idRecepteur`),
  CONSTRAINT `FKAmis161455` FOREIGN KEY (`idRecepteur`) REFERENCES `Utilisateur` (`idUtilisateur`),
  CONSTRAINT `FKAmis46628` FOREIGN KEY (`idEmetteur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Amis
-- ----------------------------
BEGIN;
INSERT INTO `Amis` VALUES (1, 2, 'Confirm');
INSERT INTO `Amis` VALUES (1, 5, 'Confirm');
INSERT INTO `Amis` VALUES (2, 3, 'Confirm');
INSERT INTO `Amis` VALUES (3, 1, 'Confirm');
INSERT INTO `Amis` VALUES (4, 5, 'Confirm');
INSERT INTO `Amis` VALUES (6, 1, 'Waiting');
COMMIT;

-- ----------------------------
-- Table structure for Annonce
-- ----------------------------
DROP TABLE IF EXISTS `Annonce`;
CREATE TABLE `Annonce` (
  `idAnnonce` int(10) NOT NULL AUTO_INCREMENT,
  `textAnnonce` varchar(255) DEFAULT NULL,
  `statutAnnonce` varchar(20) NOT NULL,
  `idUtilisateur` int(10) NOT NULL,
  PRIMARY KEY (`idAnnonce`),
  KEY `FKAnnonce548373` (`idUtilisateur`),
  CONSTRAINT `FKAnnonce548373` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Annonce
-- ----------------------------
BEGIN;
INSERT INTO `Annonce` VALUES (1, 'la seance prochaine il y a pas de cours', 'Public', 7);
INSERT INTO `Annonce` VALUES (2, 'DSI la filiere plus mouvaise.', 'Public', 7);
COMMIT;

-- ----------------------------
-- Table structure for Classe
-- ----------------------------
DROP TABLE IF EXISTS `Classe`;
CREATE TABLE `Classe` (
  `idClasse` int(10) NOT NULL AUTO_INCREMENT,
  `nomClasse` varchar(255) DEFAULT NULL,
  `anneeClasse` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Classe
-- ----------------------------
BEGIN;
INSERT INTO `Classe` VALUES (1, 'DSI', '2eme Année');
INSERT INTO `Classe` VALUES (2, 'SE', '2eme Année');
INSERT INTO `Classe` VALUES (3, 'MI', '2eme Année');
INSERT INTO `Classe` VALUES (4, 'PME/PMI', '2eme Année');
INSERT INTO `Classe` VALUES (5, 'CPI', '2eme Année');
INSERT INTO `Classe` VALUES (6, 'DSI', '1ere Année');
INSERT INTO `Classe` VALUES (7, 'SE', '1ere Année');
INSERT INTO `Classe` VALUES (8, 'MI', '1ere Année');
INSERT INTO `Classe` VALUES (9, 'PME/PMI', '1ere Année');
INSERT INTO `Classe` VALUES (10, 'CPI', '1ere Année');
INSERT INTO `Classe` VALUES (11, 'Professor', NULL);
INSERT INTO `Classe` VALUES (12, 'Administrator', NULL);
COMMIT;

-- ----------------------------
-- Table structure for Commentaire
-- ----------------------------
DROP TABLE IF EXISTS `Commentaire`;
CREATE TABLE `Commentaire` (
  `idCommentaire` int(10) NOT NULL AUTO_INCREMENT,
  `textCommentaire` varchar(255) DEFAULT NULL,
  `dateCommentaire` date DEFAULT NULL,
  `idPoste` int(10) NOT NULL,
  `idUtilisateur` int(10) NOT NULL,
  PRIMARY KEY (`idCommentaire`),
  KEY `FKCommentair192612` (`idPoste`),
  KEY `FKCommentair841041` (`idUtilisateur`),
  CONSTRAINT `FKCommentair192612` FOREIGN KEY (`idPoste`) REFERENCES `Poste` (`idPoste`),
  CONSTRAINT `FKCommentair841041` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Commentaire
-- ----------------------------
BEGIN;
INSERT INTO `Commentaire` VALUES (1, 'Pouquoi Mr ?', '2019-02-02', 1, 2);
COMMIT;

-- ----------------------------
-- Table structure for Message
-- ----------------------------
DROP TABLE IF EXISTS `Message`;
CREATE TABLE `Message` (
  `idMessage` int(11) NOT NULL AUTO_INCREMENT,
  `dateMessage` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `textMessage` varchar(255) DEFAULT NULL,
  `idEmetteur` int(10) NOT NULL,
  `idRecepteur` int(10) NOT NULL,
  `statutMessage` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idMessage`),
  KEY `FKMessage489798` (`idEmetteur`),
  KEY `FKMessage726290` (`idRecepteur`),
  CONSTRAINT `FKMessage489798` FOREIGN KEY (`idEmetteur`) REFERENCES `Utilisateur` (`idUtilisateur`),
  CONSTRAINT `FKMessage726290` FOREIGN KEY (`idRecepteur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Message
-- ----------------------------
BEGIN;
INSERT INTO `Message` VALUES (1, '2019-02-02 01:10:09', 'Fin', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (2, '2019-02-02 04:10:09', 'Ça va nti ?', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (3, '2019-02-02 06:10:09', 'Hamdoulah', 2, 1, 'Confirm');
INSERT INTO `Message` VALUES (4, '2019-02-03 01:10:09', 'et Toi ?', 2, 1, 'Confirm');
INSERT INTO `Message` VALUES (5, '2019-02-02 17:48:23', 'Wach 3adna exam ghada ?', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (6, '2019-02-02 17:49:00', 'La Chkon Kalha lik ?', 5, 4, 'Confirm');
INSERT INTO `Message` VALUES (7, '2019-02-02 17:49:28', 'Dak Laghlid Bo 7nak', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (8, '2019-02-02 17:50:58', 'Hahaha', 5, 4, 'Confirm');
INSERT INTO `Message` VALUES (9, '2019-02-02 17:51:15', 'Hadak 3i kadab', 5, 4, 'Confirm');
INSERT INTO `Message` VALUES (10, '2019-02-02 17:51:30', 'hhhhh wayih', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (11, '2019-02-02 17:51:44', 'merci <3', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (12, '2019-02-02 18:54:04', 'cc', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (13, '2019-02-03 21:44:18', 'Sat', 1, 3, 'Confirm');
INSERT INTO `Message` VALUES (14, '2019-02-04 00:16:59', 'khouna', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (15, '2019-02-04 00:17:00', 'fink', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (16, '2019-02-04 00:17:01', 'HIHO', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (17, '2019-02-04 00:17:37', 'Dodo', 4, 5, 'Confirm');
INSERT INTO `Message` VALUES (18, '2019-02-04 00:19:09', 'Salam :)', 5, 4, 'Confirm');
INSERT INTO `Message` VALUES (19, '2019-02-04 00:39:39', 'Hi', 1, 3, 'Confirm');
INSERT INTO `Message` VALUES (20, '2019-02-04 00:44:32', 'khtna', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (21, '2019-02-04 00:46:07', 'Hi', 1, 3, 'Confirm');
INSERT INTO `Message` VALUES (22, '2019-02-04 01:04:51', 'Soso', 1, 3, 'Confirm');
INSERT INTO `Message` VALUES (23, '2019-02-04 02:17:50', 'Hi', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (24, '2019-02-04 02:19:17', 'Hi', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (25, '2019-02-04 02:32:04', 'Kono', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (26, '2019-02-04 03:25:03', 'Kono', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (27, '2019-02-04 03:25:17', 'Dododbobo', 1, 2, 'Confirm');
INSERT INTO `Message` VALUES (28, '2019-02-04 03:25:31', 'Dodo', 1, 3, 'Confirm');
INSERT INTO `Message` VALUES (29, '2019-02-04 04:20:59', 'Zehahaha', 1, 5, 'Confirm');
COMMIT;

-- ----------------------------
-- Table structure for Poste
-- ----------------------------
DROP TABLE IF EXISTS `Poste`;
CREATE TABLE `Poste` (
  `idPoste` int(10) NOT NULL AUTO_INCREMENT,
  `textPoste` varchar(255) DEFAULT NULL,
  `datePoste` date DEFAULT NULL,
  `statutPoste` varchar(20) NOT NULL,
  `idUtilisateur` int(10) NOT NULL,
  PRIMARY KEY (`idPoste`),
  KEY `FKPoste318453` (`idUtilisateur`),
  CONSTRAINT `FKPoste318453` FOREIGN KEY (`idUtilisateur`) REFERENCES `Utilisateur` (`idUtilisateur`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Poste
-- ----------------------------
BEGIN;
INSERT INTO `Poste` VALUES (1, 'C\'est une mouvaise boite', '2019-02-01', 'Public', 4);
INSERT INTO `Poste` VALUES (2, 'Course a été poster', '2019-02-02', 'Public', 4);
COMMIT;

-- ----------------------------
-- Table structure for Utilisateur
-- ----------------------------
DROP TABLE IF EXISTS `Utilisateur`;
CREATE TABLE `Utilisateur` (
  `idUtilisateur` int(10) NOT NULL AUTO_INCREMENT,
  `nomUtilisateur` varchar(255) DEFAULT NULL,
  `prenomUtilisateur` varchar(255) DEFAULT NULL,
  `emailUtilisateur` varchar(255) DEFAULT NULL,
  `passwordUtilisateur` varchar(255) DEFAULT NULL,
  `cneUtilisateur` varchar(255) DEFAULT NULL,
  `roleUtilisateur` varchar(50) DEFAULT NULL,
  `idClasse` int(10) NOT NULL,
  PRIMARY KEY (`idUtilisateur`),
  UNIQUE KEY `emailUtilisateur` (`emailUtilisateur`),
  UNIQUE KEY `cneUtilisateur` (`cneUtilisateur`),
  KEY `FKUtilisateu906479` (`idClasse`),
  CONSTRAINT `FKUtilisateu906479` FOREIGN KEY (`idClasse`) REFERENCES `Classe` (`idClasse`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of Utilisateur
-- ----------------------------
BEGIN;
INSERT INTO `Utilisateur` VALUES (1, 'Youssef', 'Fatihi', 'Youssef@gmail.com', 'qwerty123', 'G123654', 'Student', 1);
INSERT INTO `Utilisateur` VALUES (2, 'Chaimaa', 'El Haimer', 'Chaimaa@email.com', 'uytre54321', 'G654329', 'Student', 4);
INSERT INTO `Utilisateur` VALUES (3, 'Salah', 'Laaouina', 'Salah@gmail.com', 'qwertyuiop', 'GX43670', 'Student', 2);
INSERT INTO `Utilisateur` VALUES (4, 'Bouaabid', 'Mourad', 'Mourad@yahoo.fr', 'qazwsx321', 'A123432', 'Professor', 11);
INSERT INTO `Utilisateur` VALUES (5, 'Achref', 'Nsalla', 'Nsalla@gmail.com', 'trewq4321', 'G290344', 'Student', 1);
INSERT INTO `Utilisateur` VALUES (6, 'Oumaima', 'Mouna', 'Mouna@email.com', 'etrhfb54', 'T910492', 'Student', 4);
INSERT INTO `Utilisateur` VALUES (7, 'Abdellah', 'Achhab', 'Achhab@gmail.com', 'azqhf387c+', 'C909022', 'Administrator', 12);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
