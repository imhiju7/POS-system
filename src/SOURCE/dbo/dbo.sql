-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: qlcuahangtienloi
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
  `donGia` double(12,2) NOT NULL,
  `maHoaDon` int NOT NULL,
  `ghiChu` varchar(50) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`maCTHoaDon`),
  KEY `fk_CTHoaDon_hoaDon` (`maHoaDon`),
  KEY `maSanPham` (`maSanPham`,`maHoaDon`),
  CONSTRAINT `chitiethoadon_ibfk_1` FOREIGN KEY (`maSanPham`) REFERENCES `sanpham` (`maSanPham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chitiethoadon_ibfk_2` FOREIGN KEY (`maHoaDon`) REFERENCES `hoadon` (`maHoaDon`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitiethoadon`
--

LOCK TABLES `chitiethoadon` WRITE;
/*!40000 ALTER TABLE `chitiethoadon` DISABLE KEYS */;
INSERT INTO `chitiethoadon` VALUES (1,1,50,15000.00,1,NULL),(2,2,35,13000.00,1,NULL);
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
  `donGia` double(12,2) NOT NULL,
  `maPhieuNhap` int NOT NULL,
  `maSanPham` int NOT NULL,
  `ngayHetHan` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ishidden` tinyint(1) NOT NULL,
  `ghiChu` varchar(45) COLLATE utf8mb3_unicode_ci DEFAULT NULL,
  `soLuongTonKho` int NOT NULL,
  PRIMARY KEY (`maCTPhieuNhap`),
  KEY `maPhieuNhap` (`maPhieuNhap`,`maSanPham`),
  KEY `fk_CTPhieuNhap_sanPham` (`maSanPham`),
  CONSTRAINT `chitietphieunhap_ibfk_1` FOREIGN KEY (`maSanPham`) REFERENCES `sanpham` (`maSanPham`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `chitietphieunhap_ibfk_2` FOREIGN KEY (`maPhieuNhap`) REFERENCES `phieunhap` (`maPhieuNhap`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
INSERT INTO `chitietphieunhap` VALUES (1,50,12000.00,1,1,'2023-12-29 00:00:00',0,NULL,23);
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
  PRIMARY KEY (`maChucNang`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucnang`
--

LOCK TABLES `chucnang` WRITE;
/*!40000 ALTER TABLE `chucnang` DISABLE KEYS */;
INSERT INTO `chucnang` VALUES (1,'quản lí trang order',0),(2,'quản lí sản phẩm',0),(3,'quản lí hóa đơn',0),(4,'quản lí phiếu nhập',0),(5,'quản lí nhà cung cấp',0),(6,'quản lí khuyến mãi',0),(7,'quản lí khách hàng',0),(8,'quản lí phân quyền',0),(9,'quản lí tài khoản',0),(10,'quản lí nhân viên',0),(11,'quản lí tài khoản cá nhân',0),(12,'quản lí doanh thu',0),(13,'trang đăng xuất',0),(14,'quản lí chức vụ',0);
/*!40000 ALTER TABLE `chucnang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chucvu`
--

DROP TABLE IF EXISTS `chucvu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chucvu` (
  `maChucVu` int NOT NULL,
  `tenChucVu` varchar(45) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maChucVu`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chucvu`
--

LOCK TABLES `chucvu` WRITE;
/*!40000 ALTER TABLE `chucvu` DISABLE KEYS */;
INSERT INTO `chucvu` VALUES (1,'admin',0),(2,'thủ kho',0),(3,'quầy',0),(4,'quản lí',0),(5,'thu ngân',0);
/*!40000 ALTER TABLE `chucvu` ENABLE KEYS */;
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoadon`
--

LOCK TABLES `hoadon` WRITE;
/*!40000 ALTER TABLE `hoadon` DISABLE KEYS */;
INSERT INTO `hoadon` VALUES (1,3,0.00,NULL,NULL,'2023-11-10 00:00:00',NULL,NULL,0),(2,3,150000.00,1,5,'2023-12-04 00:00:00',NULL,NULL,0);
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
  `isBlock` tinyint(1) NOT NULL,
  PRIMARY KEY (`maKhachHang`),
  KEY `fk_khachhang_uudai_idx` (`maUuDai`),
  CONSTRAINT `fk_khachhang_uudai` FOREIGN KEY (`maUuDai`) REFERENCES `uudai` (`maUuDai`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'0908898765','Nguyễn Minh Thắng',145,1,0),(2,'0976898735','Lê Trung Anh',1237,2,0),(3,'0955444333','Hoàng Minh Tiến',4522,4,0),(4,'0934665437','Hoàng Minh An',0,1,0),(5,'0944335678','Lê Xuân Mai',0,1,0);
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
  `isdelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maKhuyenMai`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khuyenmai`
--

LOCK TABLES `khuyenmai` WRITE;
/*!40000 ALTER TABLE `khuyenmai` DISABLE KEYS */;
INSERT INTO `khuyenmai` VALUES (1,'Khuyến mãi 20/11','2023-11-19 00:00:00','2023-11-21 00:00:00',100,10.00,0,1),(2,'Khuyến mãi tháng 12','2023-12-01 00:00:00','2023-12-06 00:00:00',150,19.00,0,0),(3,'Khuyến mãi giáng sinh','2023-12-22 00:00:00','2023-12-26 00:00:00',100,9.00,1,0),(4,'Khuyến mãi cuối tháng 11','2023-11-29 00:00:00','2023-12-05 00:00:00',150,5.00,0,0),(5,'Khuyến mãi ngày 04/12','2023-12-03 00:00:00','2023-12-05 00:00:00',200,16.00,0,0);
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
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maNhaCungCap`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES (1,'Nhà cung cấp VISTA','0908898765','vista@gmail.com','234 Hà Huy Tập, Hà Nội',0,'2023-10-08 12:56:09',0),(2,'Nhà cung cơm nắm AA','0987898767','KILO@gmail.com','421 Nguyễn Cư Trinh',1,'2023-11-30 01:02:59',0),(3,'Nhà cung cấp xúc xích GOLI','0946523611','goli@gmail.com','Quận 12, TP Hồ Chí Minh',0,'2023-12-04 04:33:24',0),(4,'Nhà cung cấp bánh giò AHA FOOD','0935611274','aha@gmail.com','Quận 1, TP Hồ Chí Minh',0,'2023-11-29 05:03:14',0),(5,'Nhà cung cấp nước giải khát BILI','0914562374','bili@gmail.com','Quận 3, TP Hồ Chí Minh',0,'2023-11-29 05:03:55',0);
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
  `isBlock` tinyint(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `ngayTao` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `img` varchar(255) COLLATE utf8mb3_unicode_ci NOT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Lê Xuân Anh',1,'1','1994-12-06','Quận 7, TP Hồ Chí Minh','xunan94h@gmail.com','0993566471',0,0,'2023-11-10 08:33:25',''),(2,'Hoàng Minh Huy',2,'1','1996-11-05','Quận 8, TP Hồ Chí Minh','mhuy96@gmail.com','0914523617',0,0,'2023-11-10 08:35:19',''),(3,'Nguyễn Tấn Hiệu',3,'1','2003-11-04','Quận 3, TP Hồ Chí Minh','tuilahiju7@gmail.com','0913517899',0,0,'2023-11-10 08:37:03',''),(4,'Lê Văn Tâm',3,'1','2002-03-05','Quận 1, TP Hồ Chí Minh','tamle22@gmail.com','0935663719',0,0,'2023-11-10 08:38:37',''),(5,'Bùi Lê Bích Nhung',5,'0','2003-06-08','Quận Tân Bình, TP Hồ Chí Minh','bnhun03@gmail.com','0925663781',0,0,'2023-11-10 08:40:05',''),(6,'Nguyễn Ngọc Minh An',4,'0','2000-03-08','Quận Bình Tân, TP Hồ Chí Minh','man2k@gmail.com','0912788372',0,0,'2023-11-10 08:42:35',''),(7,'Nguyễn Thị Xinh',3,'0','2001-03-05','Quận 6, TP Hồ Chí Minh','txinh01@gmail.com','0995342671',0,0,'2023-11-10 08:47:31',''),(8,'Lê Hoàng Thắng',2,'0','2002-06-10','Quận 6, TP Hồ Chí Minh','hthang02@gmail.com','0935667112',0,1,'2023-11-10 08:55:22',''),(9,'Nguyễn Ngọc Hoàng',3,'1','1992-03-12','Quận 3, TP Hồ Chí Minh','nhoang92@gmail.com','035641728',1,0,'2023-11-10 08:56:45','');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
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
  `isDelete` tinyint(1) NOT NULL,
  PRIMARY KEY (`maPhanQuyen`),
  KEY `fk_chucnang_idx` (`maChucNang`),
  KEY `fk_chucvu_idx` (`maChucVu`),
  CONSTRAINT `fk_chucnang` FOREIGN KEY (`maChucNang`) REFERENCES `chucnang` (`maChucNang`),
  CONSTRAINT `fk_chucvu` FOREIGN KEY (`maChucVu`) REFERENCES `chucvu` (`maChucVu`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phanquyen`
--

LOCK TABLES `phanquyen` WRITE;
/*!40000 ALTER TABLE `phanquyen` DISABLE KEYS */;
INSERT INTO `phanquyen` VALUES (1,1,1,0),(2,1,2,0),(3,1,3,0),(4,1,4,0),(5,1,5,0),(6,1,6,0),(7,1,7,0),(8,1,8,0),(9,1,9,0),(10,1,10,0),(11,1,11,0),(12,1,12,0),(13,1,13,0),(14,2,4,0),(15,2,11,0),(16,2,13,0),(17,3,1,0),(18,3,3,0),(19,3,11,0),(20,3,13,0),(21,4,14,0),(22,1,14,0),(23,4,2,0),(24,4,5,0),(25,4,6,0),(26,4,7,0),(27,4,10,0),(28,4,11,0),(29,4,12,0),(30,4,13,0),(31,5,3,0),(32,5,4,0),(33,5,12,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES (1,'2023-11-28 00:00:00',150000,1,2,NULL,0);
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
  `giaBan` int NOT NULL,
  `soLuong` int NOT NULL,
  `ngayThem` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `isHidden` tinyint(1) NOT NULL,
  `isDelete` tinyint(1) NOT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`maSanPham`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,'Cơm cuộn rong biển',23000,21,'2023-10-08 12:34:37',0,0,''),(2,'Bánh tráng đỏ Tây Ninh',12500,232,'2023-10-08 12:34:37',0,0,''),(3,'Chai nước Coca',15000,120,'2023-10-08 12:35:20',0,0,''),(4,'Chai nước Pessi',16500,122,'2023-10-08 12:35:20',0,0,''),(5,'Bánh bông lan cuộn kem phô mai',45000,50,'2023-10-08 12:36:13',0,0,''),(6,'Bánh Tiramisu',120000,40,'2023-10-08 12:36:13',0,0,''),(7,'Thuốc Lá Hà Nội',32000,23,'2023-10-08 12:37:17',0,0,''),(8,'Kem đánh răng PS',32500,320,'2023-10-08 12:37:17',0,0,''),(9,'Bánh Snack Tôm',43200,222,'2023-10-08 12:38:13',0,0,''),(10,'Bánh Kem size nhỏ',120000,21,'2023-10-08 12:38:13',0,0,''),(11,'Kẹo bạc hà',12000,322,'2023-10-08 12:39:30',0,0,''),(12,'Kẹo Gừng',3100,150,'2023-10-08 12:39:30',0,0,''),(13,'Thuốc lá con mèo',23100,312,'2023-10-08 12:40:17',1,0,''),(14,'Bánh kẹp',43000,31,'2023-10-08 12:40:17',0,1,'');
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
  `isDelete` tinyint(1) NOT NULL,
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
INSERT INTO `taikhoan` VALUES ('bnhun03','tuilathungannhun','2023-11-12 06:42:36',0,0,5),('hiju7','tuilanvquayhiju','2023-11-11 06:35:19',0,0,3),('mhuy34','tuilathukhohuy','2023-11-12 06:39:22',0,0,2),('minan2k','tuilaquanliminan','2023-11-11 09:25:22',0,0,6),('nhoang92','tuilanvquayhoang','2023-11-12 10:39:26',1,0,9),('vtam','tuilanvquaytam','2023-11-11 06:37:19',0,0,4),('xunanh37','tuilaadminxuna','2023-11-10 08:57:45',0,0,1);
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
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tichdiem`
--

LOCK TABLES `tichdiem` WRITE;
/*!40000 ALTER TABLE `tichdiem` DISABLE KEYS */;
INSERT INTO `tichdiem` VALUES (1,200000,3,0),(2,350000,5,0),(3,500000,7,0),(4,800000,10,0),(5,1200000,12,0),(6,1500000,15,0),(7,2000000,20,0),(8,2500000,25,0),(9,3000000,30,0),(10,3500000,35,0);
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `uudai`
--

LOCK TABLES `uudai` WRITE;
/*!40000 ALTER TABLE `uudai` DISABLE KEYS */;
INSERT INTO `uudai` VALUES (1,0,3,0),(2,1000,5,0),(3,2000,8,0),(4,4000,10,0),(5,8000,15,0);
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

-- Dump completed on 2023-12-01 14:42:15
