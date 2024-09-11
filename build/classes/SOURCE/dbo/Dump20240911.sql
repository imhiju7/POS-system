-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: qlcuahangtienloi
-- ------------------------------------------------------
-- Server version	8.0.32

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
-- Table structure for table `chitiethoadon`
--

DROP TABLE IF EXISTS `chitiethoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitiethoadon` (
  `maCTHoaDon` int NOT NULL AUTO_INCREMENT,
  `maSanPham` int NOT NULL,
  `soLuong` int NOT NULL,
  `donGia` double NOT NULL,
  `maHoaDon` int NOT NULL,
  PRIMARY KEY (`maCTHoaDon`),
  KEY `fk_CTHoaDon_hoaDon` (`maHoaDon`),
  KEY `maSanPham` (`maSanPham`,`maHoaDon`),
  CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`maSanPham`) REFERENCES `sanpham` (`maSanPham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`maHoaDon`) REFERENCES `hoadon` (`maHoaDon`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (91,1,2,35000,56),(92,5,2,10000,56),(93,8,2,20000,56),(94,10,2,15000,56),(95,11,2,38000,56),(96,15,4,30000,56),(97,12,4,12000,56),(98,9,2,12000,56),(99,1,2,35000,57),(100,9,1,12000,57),(101,10,2,15000,57),(102,16,1,12000,58),(103,15,2,30000,58),(104,12,1,12000,58),(105,9,2,12000,58),(106,10,3,15000,58),(107,11,2,38000,58),(108,5,1,10000,58),(109,8,1,20000,58),(110,18,1,15000,58),(111,16,3,12000,59),(112,15,2,30000,59),(113,12,3,12000,59),(114,9,3,12000,59),(115,10,3,15000,59),(116,11,2,38000,59),(117,8,3,20000,59),(118,5,2,10000,59),(119,1,3,35000,59),(120,1,2,35000,60),(121,5,2,10000,60),(122,10,3,15000,60),(123,18,1,15000,60),(124,12,2,12000,60),(125,15,2,30000,60),(126,1,2,35000,61),(127,9,2,12000,61),(128,16,1,12000,61),(129,18,1,15000,61),(130,12,2,12000,61),(131,15,2,30000,61),(132,11,3,38000,61),(133,16,1,12000,62),(134,15,3,30000,62),(135,9,2,12000,62),(136,10,1,15000,62),(137,12,2,12000,62),(138,8,1,20000,62),(139,1,2,35000,63),(140,5,3,10000,63),(141,10,2,15000,63),(142,9,2,12000,63),(143,16,2,12000,63),(144,18,1,15000,63),(145,12,2,12000,63),(146,15,2,30000,63),(147,16,2,12000,64),(148,15,3,30000,64),(149,10,2,15000,64),(150,9,2,12000,64),(151,12,2,12000,64),(152,11,1,38000,64),(153,8,3,20000,65),(154,5,3,10000,65),(155,1,4,35000,65),(156,9,3,12000,65),(157,10,3,15000,65),(158,11,2,38000,65),(159,16,2,12000,65),(160,15,2,30000,65),(161,12,2,12000,65),(162,18,1,15000,65),(163,18,3,15000,66),(164,16,2,12000,66),(165,8,4,20000,66),(166,1,1,35000,66),(167,9,10,12000,67),(168,5,5,10000,67),(169,8,5,20000,67),(170,12,5,12000,67),(171,18,5,15000,67),(172,5,6,25000,68),(173,10,3,15000,68),(174,9,5,12000,68),(175,5,10,25000,69),(176,9,4,12000,69),(177,16,2,12000,69),(178,18,4,15000,69),(179,18,4,15000,70),(180,15,1,30000,70),(181,12,4,12000,70),(182,9,3,12000,70),(183,8,4,20000,70),(184,5,4,25000,70),(185,9,3,12000,71),(186,16,3,12000,71),(187,18,3,15000,71),(188,12,4,12000,71),(189,12,10,12000,72),(190,18,6,15000,72),(191,10,4,15000,72),(192,9,5,12000,72),(193,1,4,35000,72),(194,18,3,15000,73),(195,16,5,12000,73),(196,12,3,12000,73),(197,8,5,20000,73),(198,10,6,15000,73),(199,1,2,35000,73),(200,16,5,12000,74),(201,9,5,12000,74),(202,1,2,35000,75),(203,8,1,20000,75),(204,11,1,38000,75),(205,15,1,30000,75);
/*!40000 ALTER TABLE `chitiethoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `maCTPhieuNhap` int NOT NULL AUTO_INCREMENT,
  `soLuong` int NOT NULL,
  `donGia` double NOT NULL,
  `maPhieuNhap` int NOT NULL,
  `maSanPham` int NOT NULL,
  `ngayHetHan` date NOT NULL,
  `ishidden` tinyint(1) NOT NULL,
  `ghiChu` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `soLuongTonKho` int NOT NULL,
  PRIMARY KEY (`maCTPhieuNhap`),
  KEY `maPhieuNhap` (`maPhieuNhap`,`maSanPham`),
  KEY `fk_CTPhieuNhap_sanPham` (`maSanPham`),
  CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`maSanPham`) REFERENCES `sanpham` (`maSanPham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`maPhieuNhap`) REFERENCES `phieunhap` (`maPhieuNhap`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
INSERT INTO `chitietphieunhap` VALUES (36,30,28000,21,1,'2023-12-21',0,'',4),(37,40,16000,21,8,'2023-12-24',0,'',11),(38,20,35000,21,11,'2023-12-17',0,'',7),(39,30,18000,22,15,'2023-12-15',0,'',6),(40,40,12000,23,10,'2023-12-31',0,'',6),(41,50,8000,23,12,'2024-01-07',0,'',4),(42,40,6000,24,5,'2024-01-31',0,'',2),(43,60,8000,24,9,'2024-01-28',0,'',6),(44,50,10000,25,16,'2024-04-30',0,'',21),(45,50,12000,26,18,'2024-09-01',0,'',17);
/*!40000 ALTER TABLE `chitietphieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucnang`
--

DROP TABLE IF EXISTS `chucnang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucnang` (
  `maChucNang` int NOT NULL AUTO_INCREMENT,
  `tenchucnang` varchar(45) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `maGr` int NOT NULL,
  PRIMARY KEY (`maChucNang`),
  KEY `fk_group_idx` (`maGr`),
  CONSTRAINT `fk_group` FOREIGN KEY (`maGr`) REFERENCES `group` (`maGroup`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucnang`
--

LOCK TABLES `chucnang` WRITE;
/*!40000 ALTER TABLE `chucnang` DISABLE KEYS */;
INSERT INTO `chucnang` VALUES (1,'Menu',0,1),(2,'Hóa đơn',0,1),(3,'Sản phẩm',0,2),(4,'Nhà cung cấp',0,2),(5,'Phiếu nhập',0,2),(6,'Thông tin nhân viên',0,3),(7,'Tài khoản nhân viên',0,3),(8,'Phân quyền',0,3),(9,'Thông tin khách hàng',0,4),(10,'Khuyến mãi',0,4),(11,'Doanh thu',0,5),(12,'Đăng xuất',0,6);
/*!40000 ALTER TABLE `chucnang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `maChucVu` int NOT NULL AUTO_INCREMENT,
  `tenChucVu` varchar(45) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maChucVu`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'admin',0),(2,'thủ kho',0),(3,'quầy',0),(4,'quản lí',0),(5,'thu ngân',0),(6,'bảo vệ',1),(7,'nhân viên an ninh',1);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `group`
--

DROP TABLE IF EXISTS `group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `group` (
  `maGroup` int NOT NULL AUTO_INCREMENT,
  `tenGroup` varchar(45) NOT NULL,
  `icon` varchar(255) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maGroup`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `group`
--

LOCK TABLES `group` WRITE;
/*!40000 ALTER TABLE `group` DISABLE KEYS */;
INSERT INTO `group` VALUES (1,'Order','./src/SOURCE/icon/shopping_cart.png',0),(2,'Kho','./src/SOURCE/icon/delivery.png',0),(3,'Nhân Viên','./src/SOURCE/icon/staff.png',0),(4,'Khách hàng','./src/SOURCE/icon/customer.png',0),(5,'Thống kê','./src/SOURCE/icon/trend.png',0),(6,'Cài đặt','./src/SOURCE/icon/setting.png',0);
/*!40000 ALTER TABLE `group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoadon`
--

DROP TABLE IF EXISTS `hoadon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoadon` (
  `maHoaDon` int NOT NULL AUTO_INCREMENT,
  `maNhanVien` int NOT NULL,
  `tongTien` double(12,2) NOT NULL,
  `maKhachHang` int DEFAULT NULL,
  `maKhuyenMai` int DEFAULT NULL,
  `ngayMua` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ghiChu` varchar(100) DEFAULT NULL,
  `maTichDiem` int DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maHoaDon`),
  KEY `maNhanVien` (`maNhanVien`,`maKhachHang`,`maKhuyenMai`),
  KEY `fk_hoaDon_khachHang` (`maKhachHang`),
  KEY `fk_haoDon_KhuyenMai` (`maKhuyenMai`),
  KEY `hoadon_tichdiem_idx` (`maTichDiem`),
  CONSTRAINT `hoadon_ibfk_1` FOREIGN KEY (`maKhachHang`) REFERENCES `khachhang` (`maKhachHang`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hoadon_ibfk_2` FOREIGN KEY (`maKhuyenMai`) REFERENCES `khuyenmai` (`maKhuyenMai`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hoadon_ibfk_3` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hoadon_tichdiem` FOREIGN KEY (`maTichDiem`) REFERENCES `tichdiem` (`matichdiem`)
) ENGINE=InnoDB AUTO_INCREMENT=76 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (56,4,428000.00,NULL,NULL,'2023-12-12 22:40:32','',NULL,0),(57,4,112000.00,NULL,NULL,'2023-12-12 22:44:28','',NULL,0),(58,3,274000.00,NULL,NULL,'2023-12-12 22:58:52','',NULL,0),(59,3,474000.00,NULL,NULL,'2023-12-12 22:59:48','',NULL,0),(60,3,226980.00,7,NULL,'2023-12-12 23:00:51','',13,0),(61,3,309430.00,11,NULL,'2023-12-12 23:01:47','',13,0),(62,3,185000.00,NULL,NULL,'2023-12-12 23:02:44','',NULL,0),(63,9,277000.00,NULL,NULL,'2023-12-12 23:04:56','',NULL,0),(64,9,230000.00,NULL,NULL,'2023-12-12 23:05:23','',NULL,0),(65,9,494700.00,11,NULL,'2023-12-12 23:06:48','',3,0),(66,9,184000.00,NULL,NULL,'2023-12-12 23:08:03','',NULL,0),(67,9,405000.00,NULL,NULL,'2023-12-12 23:10:14','',NULL,0),(68,9,255000.00,NULL,NULL,'2023-12-12 23:12:01','',NULL,0),(69,10,382000.00,NULL,NULL,'2023-12-12 23:15:23','',NULL,0),(70,10,354000.00,NULL,NULL,'2023-12-12 23:16:11','',NULL,0),(71,10,165000.00,NULL,NULL,'2023-12-12 23:17:22','',NULL,0),(72,10,470000.00,NULL,NULL,'2023-12-12 23:19:00','',NULL,0),(73,4,401000.00,NULL,NULL,'2023-12-12 23:21:29','',NULL,0),(74,4,120000.00,NULL,NULL,'2023-12-12 23:22:33','',NULL,0),(75,1,127980.00,12,11,'2023-12-13 16:12:01','',13,0);
/*!40000 ALTER TABLE `hoadon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKhachHang` int NOT NULL AUTO_INCREMENT,
  `SDT` varchar(10) COLLATE utf8mb3_unicode_ci NOT NULL,
  `tenKhachHang` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `diemTichLuy` int NOT NULL,
  `maUuDai` int NOT NULL,
  PRIMARY KEY (`maKhachHang`),
  KEY `fk_khachhang_uudai_idx` (`maUuDai`),
  CONSTRAINT `fk_khachhang_uudai` FOREIGN KEY (`maUuDai`) REFERENCES `uudai` (`maUuDai`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'0908898765','Nguyễn Minh Thắng',145,1),(2,'0976898735','Lê Trung',1237,2),(3,'0955444333','Hoàng Minh Tiến',4522,4),(4,'0945663712','Lê Hoàng An',6,1),(7,'0917661222','Hà Xuân Anh',3,1),(10,'0963714255','Lê Anh Nam',1,1),(11,'0917685441','Lê Hoàng Minh',11,1),(12,'0944111517','Nguyễn Ngọc Tuấn',3,1);
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khuyenmai`
--

DROP TABLE IF EXISTS `khuyenmai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khuyenmai` (
  `maKhuyenMai` int NOT NULL AUTO_INCREMENT,
  `tenKhuyenMai` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `ngayBatDau` datetime NOT NULL,
  `ngayHetHan` datetime NOT NULL,
  `soLuong` int NOT NULL,
  `phanTram` double(10,2) NOT NULL,
  `ishidden` tinyint(1) NOT NULL,
  `soLuongDaDung` int NOT NULL,
  PRIMARY KEY (`maKhuyenMai`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES (11,'Ngày 13/12','2023-12-13 00:00:00','2023-12-14 00:00:00',50,8.00,0,1),(12,'Giáng sinh 2023','2023-12-25 00:00:00','2023-12-27 00:00:00',100,12.00,0,0),(13,'Năm mới 2024','2023-12-31 00:00:00','2024-01-04 00:00:00',200,15.00,0,0),(14,'Ngày nhà giáo Việt Nam 2023','2023-11-20 00:00:00','2023-11-21 00:00:00',200,8.00,0,0);
/*!40000 ALTER TABLE `khuyenmai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `maNhaCungCap` int NOT NULL AUTO_INCREMENT,
  `tenNhaCungCap` varchar(255) NOT NULL,
  `SDT` varchar(12) NOT NULL,
  `email` varchar(255) NOT NULL,
  `diaChi` varchar(255) NOT NULL,
  `trangThai` tinyint(1) NOT NULL,
  `ngayTao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`maNhaCungCap`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES (1,'Nước Lọc Dasani','0908898765','dasani87@gmail.com','234 Hà Huy Tập, Hà Nội',0,'2023-10-08 12:56:09'),(2,'Cơm AA','0987898767','AARice@gmail.com','421 Nguyễn Cư Trinh',0,'2023-12-04 17:15:22'),(3,'Xúc xích GOLI','0946523611','goli@gmail.com','Quận 12, TP Hồ Chí Minh',0,'2023-12-04 04:33:24'),(4,'Bánh bao AHA FOOD','0935611274','aha@gmail.com','Quận 1, TP Hồ Chí Minh',0,'2023-11-29 05:03:14'),(5,'Nước giải khát Coca cola','0914562374','cocacola2@gmail.com','Quận 3, TP Hồ Chí Minh',0,'2023-11-29 05:03:55'),(7,'Sandwich Aka','0925661783','aka7@gmail.com','Quận 9, TP Hồ Chí Minh',0,'2023-12-09 15:45:27'),(8,'Bánh ngọt KanJi','0999512671','kanj6@gmail.com','Quận Hoàn Kiếm, Hà Nội',0,'2023-12-12 15:06:42'),(9,'Mì hộp Noofie','0888547661','noofie34@gmail.com','Quận Liên Chiểu, TP Đà Nẵng',0,'2023-12-12 15:22:59');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNhanVien` int NOT NULL AUTO_INCREMENT,
  `tenNhanVien` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `maChucVu` int NOT NULL,
  `gioiTinh` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `ngaySinh` date NOT NULL,
  `diaChi` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `email` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `soDienThoai` varchar(12) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `ngayTao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `img` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Lê Xuân Anh',1,'1','1994-12-06','Quận 7, TP Hồ Chí Minh','xunan94h@gmail.com','0993566471',0,'2023-11-10 08:33:25','./src/SOURCE/nhanvien/nv1.png'),(2,'Hoàng Minh Huy',2,'1','1996-11-05','Quận 8, TP Hồ Chí Minh','mhuy96@gmail.com','0914523617',0,'2023-11-10 08:35:19','./src/SOURCE/nhanvien/nv2.png'),(3,'Nguyễn Tấn Hiệu',3,'1','2003-11-04','Quận 3, TP Hồ Chí Minh','tuilahiju7@gmail.com','0913517899',0,'2023-11-10 08:37:03','./src/SOURCE/nhanvien/nv3.png'),(4,'Lê Văn Tâm',3,'1','2002-03-05','Quận 1, TP Hồ Chí Minh','tamle22@gmail.com','0935663719',0,'2023-11-10 08:38:37','./src/SOURCE/nhanvien/nv4.png'),(5,'Bùi Lê Bích Nhung',5,'0','2003-06-08','Quận Tân Bình, TP Hồ Chí Minh','bnhun03@gmail.com','0925663781',0,'2023-11-10 08:40:05','./src/SOURCE/nhanvien/nv5.png'),(6,'Nguyễn Ngọc Minh An',4,'0','2000-03-08','Quận Bình Tân, TP Hồ Chí Minh','man2k@gmail.com','0912788372',0,'2023-11-10 08:42:35','./src/SOURCE/nhanvien/nv6.png'),(7,'Nguyễn Thị Xinh',3,'0','2001-03-05','Quận 6, TP Hồ Chí Minh','txinh011@gmail.com','0995342671',0,'2023-11-10 08:47:31','./src/SOURCE/nhanvien/nv7.png'),(8,'Lê Hoàng Minh',2,'1','2002-06-10','Quận 6, TP Hồ Chí Minh','hmin02@gmail.com','0935667112',1,'2023-11-10 08:55:22','./src/SOURCE/nhanvien/nv8.png'),(9,'Nguyễn Ngọc Hoàng',3,'1','1992-03-12','Quận 3, TP Hồ Chí Minh','nhoang92@gmail.com','0356417284',0,'2023-11-10 08:56:45','./src/SOURCE/nhanvien/nv9.png'),(10,'Lê Hoàng Thắng',3,'1','1994-12-02','Quận 3, TP Hồ Chí Minh','hthang7@gmail.com','0944225671',0,'2023-12-02 06:38:20','./src/SOURCE/nhanvien/nv10.png'),(11,'Hoàng Tiến Duy',3,'1','2002-12-02','Quận 1, TP Hồ Chí Minh','htien22@gmail.com','0955444222',1,'2023-12-09 16:01:17','./src/SOURCE/img/346622247_827944658758967_2235607167663505813_n-768x768.jpg');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phanloai`
--

DROP TABLE IF EXISTS `phanloai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phanloai` (
  `maPhanLoai` int NOT NULL AUTO_INCREMENT,
  `tenPhanLoai` varchar(255) NOT NULL,
  PRIMARY KEY (`maPhanLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phanloai`
--

LOCK TABLES `phanloai` WRITE;
/*!40000 ALTER TABLE `phanloai` DISABLE KEYS */;
INSERT INTO `phanloai` VALUES (1,'Khác'),(2,'Chai'),(3,'Túi'),(4,'Hộp'),(5,'Chai nhỏ'),(6,'Gói giấy');
/*!40000 ALTER TABLE `phanloai` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phanquyen`
--

DROP TABLE IF EXISTS `phanquyen`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phanquyen` (
  `maPhanQuyen` int NOT NULL AUTO_INCREMENT,
  `maChucVu` int NOT NULL,
  `maChucNang` int NOT NULL,
  PRIMARY KEY (`maPhanQuyen`),
  KEY `fk_chucnang_idx` (`maChucNang`),
  KEY `fk_chucvu_idx` (`maChucVu`),
  CONSTRAINT `fk_chucnang` FOREIGN KEY (`maChucNang`) REFERENCES `chucnang` (`maChucNang`),
  CONSTRAINT `fk_chucvu` FOREIGN KEY (`maChucVu`) REFERENCES `chucvu` (`maChucVu`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phanquyen`
--

LOCK TABLES `phanquyen` WRITE;
/*!40000 ALTER TABLE `phanquyen` DISABLE KEYS */;
INSERT INTO `phanquyen` VALUES (1,1,1),(2,1,2),(3,1,3),(4,1,4),(6,1,6),(8,1,8),(9,1,9),(10,1,10),(14,2,5),(17,3,1),(25,4,6),(27,4,10),(28,4,11),(34,1,7),(35,1,12),(36,2,12),(37,3,12),(38,4,12),(39,5,12),(40,4,2),(41,5,2),(42,4,3),(43,4,4),(44,1,5),(45,1,11),(46,4,9),(47,5,5),(48,5,11);
/*!40000 ALTER TABLE `phanquyen` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `maPhieuNhap` int NOT NULL AUTO_INCREMENT,
  `ngayNhap` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `tongTien` double NOT NULL,
  `maNhaCungCap` int NOT NULL,
  `maNhanVien` int NOT NULL,
  `ghiChu` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maPhieuNhap`),
  KEY `maNhaCungCap` (`maNhaCungCap`,`maNhanVien`),
  KEY `maNhaCungCap_2` (`maNhaCungCap`,`maNhanVien`),
  KEY `maNhanVien` (`maNhanVien`),
  CONSTRAINT `phieunhap_ibfk_1` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`),
  CONSTRAINT `phieunhap_ibfk_2` FOREIGN KEY (`maNhaCungCap`) REFERENCES `nhacungcap` (`maNhaCungCap`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES (21,'2023-12-12 22:10:43',2180000,2,2,'',0),(22,'2023-12-01 22:13:34',540000,7,2,'',0),(23,'2023-11-18 22:14:53',880000,4,2,'',0),(24,'2023-11-15 22:16:23',720000,8,2,'',0),(25,'2023-12-12 22:19:21',500000,5,2,'',0),(26,'2023-12-12 22:56:11',600000,1,2,'',0);
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `maSanPham` int NOT NULL AUTO_INCREMENT,
  `tenSanPham` varchar(50) NOT NULL,
  `giaBan` double NOT NULL,
  `soLuong` int NOT NULL,
  `ngayThem` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isHidden` tinyint(1) NOT NULL,
  `img` varchar(255) NOT NULL,
  `maPhanLoai` int NOT NULL,
  `giaNhap` double NOT NULL,
  PRIMARY KEY (`maSanPham`),
  KEY `fk_phanloai_idx` (`maPhanLoai`),
  CONSTRAINT `fk_phanloai` FOREIGN KEY (`maPhanLoai`) REFERENCES `phanloai` (`maPhanLoai`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Cơm cá hồi nướng',35000,4,'2023-10-08 12:34:37',0,'./src/SOURCE/img/CT-Tuần-Tuần-06.03.2023-Resize-Web-SPM-900x900px-02-768x768.png',3,28000),(2,'Bánh canh gạo tôm xào trứng',0,0,'2023-10-08 12:34:37',0,'./src/SOURCE/img/Banh-anh-gao-tom-va-trung-768x768.png',4,0),(3,'Chả cá cuộn phô mai Hokkaido',0,0,'2023-10-08 12:35:20',0,'./src/SOURCE/img/CT-Tuần-Tuần-19.09.2022-Resize-Web-SPM-900x900px-03-768x768.png',3,0),(4,'Mì xá xíu hoành thánh tôm thịt',0,0,'2023-10-08 12:35:20',0,'./src/SOURCE/img/348621924_6499184153446267_1290294645071371077_n.jpg',4,0),(5,'Bánh bông lan chuối hạt đính đường',25000,2,'2023-10-08 12:36:13',0,'./src/SOURCE/img/CT-Tuần-Tuần-07.11.2022-Resize-Web-SPM-900x900px-02-768x768.png',3,6000),(6,'Mì xào qà quay',0,0,'2023-10-08 12:36:13',0,'./src/SOURCE/img/Mi-xao-ga-quay-768x768.png',4,0),(7,'Bánh mì que gà Roti',0,0,'2023-10-08 12:37:17',0,'./src/SOURCE/img/Banh-mi-pho-mai-thap-cam.png',3,0),(8,'Cơm cuộn phô mai Omusumi',20000,11,'2023-10-08 12:37:17',0,'./src/SOURCE/img/CT-Tuần-Tuần-22.08.2022-Resize-Web-SPM-900x900px-01.png',3,16000),(9,'MoChi TaiYaHi nhân kem phô mai',12000,6,'2023-10-08 12:38:13',0,'./src/SOURCE/img/Mochi.png',3,8000),(10,'Bánh Bao nhân sô cô la',15000,6,'2023-10-08 12:38:13',0,'./src/SOURCE/img/CT-Tuần-Tuần-06.03.2023-Resize-Web-SPM-900x900px-01.png',3,12000),(11,'Cơm mực xào sa tế',38000,7,'2023-10-08 12:39:30',0,'./src/SOURCE/img/CT-Tuần-Tuần-12.12.2022-Resize-Web-SPM-02-768x768.png',3,35000),(12,'Bánh bao Doraemon',12000,4,'2023-10-08 12:39:30',0,'./src/SOURCE/img/Fanpage-Post-Tháng-1-04-768x768.png',3,8000),(15,'Sandwich hỗn hợp',30000,6,'2023-12-09 15:39:54',0,'./src/SOURCE/img/CT-Tuần-Tuần-05.04.2021-Resize-Web-SPM-900x900px-03-768x768.png',3,18000),(16,'Cocacola 390ml',12000,21,'2023-12-12 15:48:32',0,'./src/SOURCE/img/Coca-Cola-chai-390ml-400x400.jpg',2,10000),(17,'Betagen 140ml',0,0,'2023-12-12 15:49:57',0,'./src/SOURCE/img/Betagen-SCU-tu-nhien-140ml-400x400.jpg',5,0),(18,'Dasani 1,5l',15000,17,'2023-12-12 15:50:34',0,'./src/SOURCE/img/Dasani-15L-01-1-400x400.jpg',2,12000);
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `taikhoan`
--

DROP TABLE IF EXISTS `taikhoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `taikhoan` (
  `tenDangNhap` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `matKhau` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_unicode_ci NOT NULL,
  `ngayTao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isBlock` tinyint(1) NOT NULL,
  `maNhanVien` int NOT NULL,
  PRIMARY KEY (`tenDangNhap`),
  KEY `maNhanVien` (`maNhanVien`),
  CONSTRAINT `fk_taiKhoan_nhanVien` FOREIGN KEY (`maNhanVien`) REFERENCES `nhanvien` (`maNhanVien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `taikhoan`
--

LOCK TABLES `taikhoan` WRITE;
/*!40000 ALTER TABLE `taikhoan` DISABLE KEYS */;
INSERT INTO `taikhoan` VALUES ('bnhun03','tuilathungannhung','2023-11-12 06:42:36',1,5),('hiju7','ToilaHiju7','2023-12-04 02:03:51',0,3),('mhuy345','tkhuy','2023-11-12 06:39:22',0,2),('minan2k','tuilaquanliminan','2023-11-11 09:25:22',0,6),('nhoang92','tuilanvquayhoang','2023-11-12 10:39:26',0,9),('tiendi77','didi77','2023-12-09 16:06:33',0,11),('vtam','tuilanvquaytam','2023-11-11 06:37:19',0,4),('xunanh37','adman123','2023-11-10 08:57:45',0,1);
/*!40000 ALTER TABLE `taikhoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tichdiem`
--

DROP TABLE IF EXISTS `tichdiem`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tichdiem` (
  `matichdiem` int NOT NULL AUTO_INCREMENT,
  `Tien` double NOT NULL,
  `diemTichLuy` int NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`matichdiem`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tichdiem`
--

LOCK TABLES `tichdiem` WRITE;
/*!40000 ALTER TABLE `tichdiem` DISABLE KEYS */;
INSERT INTO `tichdiem` VALUES (1,0,1,0),(2,350000,5,0),(3,500000,7,0),(4,750000,10,0),(11,1500000,15,0),(12,950000,11,1),(13,150000,3,0),(14,1700000,17,0),(16,600000,8,0),(18,1900000,19,0);
/*!40000 ALTER TABLE `tichdiem` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `uudai`
--

DROP TABLE IF EXISTS `uudai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `uudai` (
  `maUuDai` int NOT NULL AUTO_INCREMENT,
  `mocUuDai` int NOT NULL,
  `tiLeGiam` int NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maUuDai`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uudai`
--

LOCK TABLES `uudai` WRITE;
/*!40000 ALTER TABLE `uudai` DISABLE KEYS */;
INSERT INTO `uudai` VALUES (1,0,3,0),(2,1000,5,0),(3,2000,8,0),(4,4000,10,0),(5,8000,15,0),(6,6500,12,1),(7,10000,20,1);
/*!40000 ALTER TABLE `uudai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-11  7:38:58
