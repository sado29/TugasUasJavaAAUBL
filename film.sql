# Host: localhost  (Version: 5.6.20)
# Date: 2016-12-29 02:03:52
# Generator: MySQL-Front 5.2  (Build 5.66)

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS */;
/*!40014 SET FOREIGN_KEY_CHECKS=0 */;

#
# Source for table "customer"
#

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_customer` varchar(5) NOT NULL DEFAULT '',
  `nama_customer` varchar(35) NOT NULL DEFAULT '',
  `alamat` text NOT NULL,
  `telepon` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#
# Data for table "customer"
#

INSERT INTO `customer` VALUES (2,'C-1','null','bintaro','021111111111'),(5,'C-2','hirmida','bintaro','0212206'),(6,'','','','');

#
# Source for table "datafilm"
#

DROP TABLE IF EXISTS `datafilm`;
CREATE TABLE `datafilm` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_film` varchar(5) NOT NULL DEFAULT '',
  `judul_film` varchar(101) NOT NULL DEFAULT '',
  `sutradara` varchar(35) NOT NULL DEFAULT '',
  `kode_kategori` varchar(5) NOT NULL DEFAULT '',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

#
# Data for table "datafilm"
#

INSERT INTO `datafilm` VALUES (1,'null','null','null','null'),(2,'null','null','null','null'),(3,'F-3','gede','fikih','K-1'),(4,'F-4','bukan mahasiswa biasa','angkasa olrenza','K-1'),(5,'F-6','makan','lapar','K-1'),(6,'','','','');

#
# Source for table "kategorifilm"
#

DROP TABLE IF EXISTS `kategorifilm`;
CREATE TABLE `kategorifilm` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_kategori` varchar(5) NOT NULL DEFAULT '',
  `nama_kategori` varchar(35) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

#
# Data for table "kategorifilm"
#

INSERT INTO `kategorifilm` VALUES (2,'K-1','Commedy'),(4,'k-6','Horor'),(5,'',''),(6,'K-2','Horor'),(7,'','');

#
# Source for table "pengembalian"
#

DROP TABLE IF EXISTS `pengembalian`;
CREATE TABLE `pengembalian` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_penyewaan` varchar(5) NOT NULL DEFAULT '',
  `kode_customer` varchar(5) NOT NULL DEFAULT '',
  `kode_film` varchar(5) NOT NULL DEFAULT '',
  `tgl_kembali` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

#
# Data for table "pengembalian"
#

INSERT INTO `pengembalian` VALUES (1,'KPN-1','C-2','F-4','2016-06-01');

#
# Source for table "penjualan"
#

DROP TABLE IF EXISTS `penjualan`;
CREATE TABLE `penjualan` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_penjualan` varchar(5) NOT NULL DEFAULT '',
  `kode_customer` varchar(5) NOT NULL DEFAULT '',
  `kode_film` varchar(255) NOT NULL DEFAULT '',
  `tgl_jual` date NOT NULL DEFAULT '0000-00-00',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "penjualan"
#

INSERT INTO `penjualan` VALUES (4,'KP-2','C-2','F-4','2016-06-01');

#
# Source for table "pennyewaan"
#

DROP TABLE IF EXISTS `pennyewaan`;
CREATE TABLE `pennyewaan` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `kode_penyewaan` varchar(5) NOT NULL DEFAULT '',
  `kode_customer` varchar(5) NOT NULL DEFAULT '',
  `kode_film` varchar(5) NOT NULL DEFAULT '',
  `tgl_sewa` date NOT NULL DEFAULT '0000-00-00',
  `tgl_kembali` date NOT NULL DEFAULT '0000-00-00',
  `catatan` text NOT NULL,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

#
# Data for table "pennyewaan"
#

INSERT INTO `pennyewaan` VALUES (4,'KPN-1','C-2','F-4','2016-06-08','2016-06-10','aaa');

/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
