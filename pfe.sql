/*
Navicat MySQL Data Transfer

Source Server         : SQL
Source Server Version : 50505
Source Host           : localhost:3306
Source Database       : pfe

Target Server Type    : MYSQL
Target Server Version : 50505
File Encoding         : 65001

Date: 2019-01-05 16:57:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for message
-- ----------------------------
DROP TABLE IF EXISTS `message`;
CREATE TABLE `message` (
  `id` int(11) NOT NULL,
  `text` text,
  `dateCreation` datetime DEFAULT NULL,
  `id_emetteur` int(11) DEFAULT NULL,
  `id_recepteur` int(11) DEFAULT NULL,
  `statut` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_ideme` (`id_emetteur`),
  KEY `fk_idrec` (`id_recepteur`),
  CONSTRAINT `fk_ideme` FOREIGN KEY (`id_emetteur`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `fk_idrec` FOREIGN KEY (`id_recepteur`) REFERENCES `utilisateur` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of message
-- ----------------------------
INSERT INTO `message` VALUES ('1', 'fen', '2019-01-05 11:28:19', '1', '2', 'pas encore');
INSERT INTO `message` VALUES ('2', 'fen ca va', '2019-01-05 11:28:28', '2', '4', 'pas encore');
INSERT INTO `message` VALUES ('3', 'fen ca va ?', '2019-01-05 11:28:41', '2', '1', 'pas encore');
INSERT INTO `message` VALUES ('4', 'hmd', '2019-01-05 11:28:50', '1', '2', 'pas encore');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `role` int(11) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '1', 'Etudiant');
INSERT INTO `roles` VALUES ('2', '2', 'Proffesseur');
INSERT INTO `roles` VALUES ('3', '3', 'Administrateur');

-- ----------------------------
-- Table structure for utilisateur
-- ----------------------------
DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom_de_compte` varchar(255) DEFAULT NULL,
  `mot_de_pass` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL,
  `role` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of utilisateur
-- ----------------------------
INSERT INTO `utilisateur` VALUES ('1', 'user1', 'password1', 'user1@live.fr', 'john', 'kepler', '1');
INSERT INTO `utilisateur` VALUES ('2', 'user2', 'password2', 'user2@live.fr', 'Yanis', 'Gordon', '2');
INSERT INTO `utilisateur` VALUES ('3', 'user3', 'password3', 'user3@live.fr', 'Yassine', 'Harpoop', '3');
INSERT INTO `utilisateur` VALUES ('4', 'user4', 'password4', 'user4@live.fr', 'Amine', 'Bouanid', '1');
