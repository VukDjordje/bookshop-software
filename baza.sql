/*
SQLyog Community v12.5.1 (64 bit)
MySQL - 10.1.28-MariaDB : Database - seminarski
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`seminarski` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `seminarski`;

/*Table structure for table `autor` */

DROP TABLE IF EXISTS `autor`;

CREATE TABLE `autor` (
  `autorID` int(11) NOT NULL AUTO_INCREMENT,
  `zanr` varchar(50) DEFAULT NULL,
  `ime` varchar(20) DEFAULT NULL,
  `prezime` varchar(20) DEFAULT NULL,
  `radnikID` int(11) DEFAULT NULL,
  PRIMARY KEY (`autorID`),
  KEY `radnikID` (`radnikID`),
  CONSTRAINT `autor_ibfk_1` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;

/*Data for the table `autor` */

insert  into `autor`(`autorID`,`zanr`,`ime`,`prezime`,`radnikID`) values 
(2,'poezija','Mesa','Selimovic',2),
(3,'Ruska poezija','Fjodor','Dostojevski',2),
(4,'Decije pesme','Dusko','Radovic',1),
(5,'Fantazija','George','Martin',1),
(17,'Poezija','Ivo','Andric',1),
(18,'D','D','D',1),
(19,'M','M','M',1);

/*Table structure for table `izdavac` */

DROP TABLE IF EXISTS `izdavac`;

CREATE TABLE `izdavac` (
  `izdavacID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `maticniBroj` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`izdavacID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `izdavac` */

insert  into `izdavac`(`izdavacID`,`naziv`,`maticniBroj`) values 
(1,'Laguna','17414844'),
(2,'Vulkan','20644834'),
(3,'Pcelica','56191933');

/*Table structure for table `knjiga` */

DROP TABLE IF EXISTS `knjiga`;

CREATE TABLE `knjiga` (
  `knjigaID` int(11) NOT NULL AUTO_INCREMENT,
  `naziv` varchar(50) DEFAULT NULL,
  `godina` int(4) DEFAULT NULL,
  `opis` varchar(255) DEFAULT NULL,
  `izdavacID` int(11) DEFAULT NULL,
  `radnikID` int(11) DEFAULT NULL,
  `cena` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`knjigaID`),
  KEY `izdavacID` (`izdavacID`),
  KEY `radnikID` (`radnikID`),
  CONSTRAINT `knjiga_ibfk_1` FOREIGN KEY (`izdavacID`) REFERENCES `izdavac` (`izdavacID`) ON DELETE NO ACTION,
  CONSTRAINT `knjiga_ibfk_2` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=latin1;

/*Data for the table `knjiga` */

insert  into `knjiga`(`knjigaID`,`naziv`,`godina`,`opis`,`izdavacID`,`radnikID`,`cena`) values 
(6,'Dervis i smrt',1966,'Prica o dervisu',1,1,1200.00),
(7,'Zlocin i kazna',1866,'Sukob dobrog i loseg u coveku',2,1,900.00),
(8,'Postovana deco',1954,'Decije pesme',2,1,850.00),
(9,'s',1,'s',1,1,1.00);

/*Table structure for table `napisana` */

DROP TABLE IF EXISTS `napisana`;

CREATE TABLE `napisana` (
  `knjigaID` int(11) NOT NULL,
  `autorID` int(11) NOT NULL,
  PRIMARY KEY (`knjigaID`,`autorID`),
  KEY `autorID` (`autorID`),
  CONSTRAINT `napisana_ibfk_1` FOREIGN KEY (`knjigaID`) REFERENCES `knjiga` (`knjigaID`),
  CONSTRAINT `napisana_ibfk_2` FOREIGN KEY (`autorID`) REFERENCES `autor` (`autorID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `napisana` */

insert  into `napisana`(`knjigaID`,`autorID`) values 
(6,2),
(7,3),
(8,4),
(9,18),
(9,19);

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `racunID` int(11) NOT NULL,
  `ukupanIznos` decimal(10,2) DEFAULT NULL,
  `radnikID` int(11) DEFAULT NULL,
  PRIMARY KEY (`racunID`),
  KEY `radnikID` (`radnikID`),
  CONSTRAINT `racun_ibfk_1` FOREIGN KEY (`radnikID`) REFERENCES `radnik` (`radnikID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `racun` */

/*Table structure for table `radnik` */

DROP TABLE IF EXISTS `radnik`;

CREATE TABLE `radnik` (
  `radnikID` int(11) NOT NULL AUTO_INCREMENT,
  `ime` varchar(50) DEFAULT NULL,
  `prezime` varchar(50) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`radnikID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `radnik` */

insert  into `radnik`(`radnikID`,`ime`,`prezime`,`username`,`password`) values 
(1,'Djordje','Vukicevic','djole','365'),
(2,'Jelena','Novovic','jeca','718'),
(3,'Mateja','Matejic','maki','121');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `rb` int(11) NOT NULL,
  `kolicina` int(11) DEFAULT NULL,
  `iznos` decimal(10,2) DEFAULT NULL,
  `knjigaID` int(11) DEFAULT NULL,
  `racunID` int(11) NOT NULL,
  PRIMARY KEY (`rb`,`racunID`),
  KEY `racunID` (`racunID`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`racunID`) REFERENCES `racun` (`racunID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `stavkaracuna` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
