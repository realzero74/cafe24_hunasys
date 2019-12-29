-- --------------------------------------------------------
-- 호스트:                          localhost
-- 서버 버전:                        10.4.8-MariaDB-1:10.4.8+maria~bionic - mariadb.org binary distribution
-- 서버 OS:                        debian-linux-gnu
-- HeidiSQL 버전:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- hunasys 데이터베이스 구조 내보내기
DROP DATABASE IF EXISTS `hunasys`;
CREATE DATABASE IF NOT EXISTS `hunasys` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;
USE `hunasys`;

-- 테이블 hunasys.CODES 구조 내보내기
DROP TABLE IF EXISTS `CODES`;
CREATE TABLE IF NOT EXISTS `CODES` (
  `group_cd` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `group_nm` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_cd` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `item_nm` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ordered` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`group_cd`,`item_cd`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 hunasys.CODES:~31 rows (대략적) 내보내기
DELETE FROM `CODES`;
/*!40000 ALTER TABLE `CODES` DISABLE KEYS */;
INSERT INTO `CODES` (`group_cd`, `group_nm`, `item_cd`, `item_nm`, `ordered`) VALUES
	('01', '구분', '01', '라벨', 1),
	('01', '구분', '02', '장비', 2),
	('01', '구분', '03', '리본', 3),
	('01', '구분', '04', '실사', 4),
	('01', '구분', '05', '기타', 5),
	('02', '용지1', '01', '아트지', 1),
	('02', '용지1', '02', '감열지', 2),
	('02', '용지1', '03', '투명PET', 3),
	('02', '용지1', '04', '백색PET', 4),
	('02', '용지1', '05', '은무데도롱지', 5),
	('02', '용지1', '06', '은광데도롱지', 6),
	('02', '용지1', '07', 'VOID', 7),
	('02', '용지1', '08', '유포지(PPT)', 8),
	('02', '용지1', '09', 'PVC(캘지)', 9),
	('02', '용지1', '10', '모조지', 10),
	('02', '용지1', '11', '꼬리표', 11),
	('03', '용지2', '01', '그라', 1),
	('03', '용지2', '02', '미색(황박)', 2),
	('03', '용지2', '03', '무접', 3),
	('04', '실사용지1', '01', '유포지', 1),
	('04', '실사용지1', '02', '캘지', 2),
	('05', '실사용지2', '01', '코팅없음', 1),
	('05', '실사용지2', '02', '무광코팅', 2),
	('05', '실사용지2', '03', '유광코팅', 3),
	('06', '지관', '01', '40지관', 1),
	('06', '지관', '02', '40지관(플라스틱)', 2),
	('06', '지관', '03', '75지관', 3),
	('06', '지관', '04', '75지관(플라스틱)', 4),
	('07', '납품방법', '01', '직납', 1),
	('07', '납품방법', '02', '방문', 2),
	('07', '납품방법', '03', '택배', 3);
/*!40000 ALTER TABLE `CODES` ENABLE KEYS */;

-- 테이블 hunasys.FILES 구조 내보내기
DROP TABLE IF EXISTS `FILES`;
CREATE TABLE IF NOT EXISTS `FILES` (
  `file_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `original_file_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '원본파일명',
  `original_file_ext` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '원본파일확장자',
  `saved_file_name` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '저장된파일명',
  `saved_file_path` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '저장된파일경로',
  PRIMARY KEY (`file_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 hunasys.FILES:~0 rows (대략적) 내보내기
DELETE FROM `FILES`;
/*!40000 ALTER TABLE `FILES` DISABLE KEYS */;
/*!40000 ALTER TABLE `FILES` ENABLE KEYS */;

-- 테이블 hunasys.ORDERS 구조 내보내기
DROP TABLE IF EXISTS `ORDERS`;
CREATE TABLE IF NOT EXISTS `ORDERS` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'idx',
  `item_cls` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '구분',
  `company` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '0' COMMENT '발주회사',
  `item_nm` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '품명',
  `item_spec` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '규격',
  `total_qty` int(11) DEFAULT NULL COMMENT '수량',
  `paper1` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '용지1',
  `paper2` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '용지2',
  `paper3` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '실사용지1',
  `paper4` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '실사용지2',
  `parer_roll` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '지관',
  `roll_qty` int(11) DEFAULT NULL COMMENT '1롤당 수량',
  `due_date` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '납기일',
  `delivery` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '납품방법',
  `description` varchar(4000) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '기타설명',
  `file1` bigint(20) DEFAULT NULL COMMENT '첨부파일1',
  `file2` bigint(20) DEFAULT NULL COMMENT '첨부파일2',
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '' COMMENT '작성자',
  `new_datetime` datetime NOT NULL DEFAULT current_timestamp() COMMENT '생성일/주문일/작성일',
  `mod_datetime` datetime DEFAULT NULL COMMENT '최근수정일',
  `end_datetime` datetime DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 hunasys.ORDERS:~4 rows (대략적) 내보내기
DELETE FROM `ORDERS`;
/*!40000 ALTER TABLE `ORDERS` DISABLE KEYS */;
INSERT INTO `ORDERS` (`order_id`, `item_cls`, `company`, `item_nm`, `item_spec`, `total_qty`, `paper1`, `paper2`, `paper3`, `paper4`, `parer_roll`, `roll_qty`, `due_date`, `delivery`, `description`, `file1`, `file2`, `user_id`, `new_datetime`, `mod_datetime`, `end_datetime`) VALUES
	(3, '01', 'qaweq', 'eqwqweqwe', 'qwe', 12, '02', NULL, NULL, NULL, '02', 1, '2019-12-28', '04', 'esrewsrt\nhjkh\nhu\nuh\nhu\nf6\ntvfgub\njnun\n', 0, 0, 'huna', '2019-12-25 09:27:55', NULL, NULL),
	(4, '01', 'aaaaaa', '메롱이당....ㅋㅋㅋ', 'ASD', 1, '02', NULL, NULL, NULL, '02', 10, '2019-12-31', '02', 'asd\nasdf\nasdf\n###\nAsdf\nㅁ나어ㅣㅏ허\n', 0, 0, 'huna', '2019-12-29 14:22:28', NULL, NULL),
	(5, '02', '내맘대로 회사', '', '', 0, '01', NULL, NULL, NULL, '01', 0, '', '01', '장비 입력', 0, 0, 'huna', '2019-12-29 14:34:36', NULL, NULL),
	(7, '01', '내맘대로 회사', '123ㄴㅁㅇㄹㄴㅇㄹ', 'ㅁㅁㅁㅁ', 11, '02', '02', NULL, NULL, '02', 11, '2019-12-31', '02', 'ㅁㄴㅇㄹ', 0, 0, 'huna', '2019-12-29 14:44:39', NULL, NULL);
/*!40000 ALTER TABLE `ORDERS` ENABLE KEYS */;

-- 테이블 hunasys.USERS 구조 내보내기
DROP TABLE IF EXISTS `USERS`;
CREATE TABLE IF NOT EXISTS `USERS` (
  `user_id` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '아이디',
  `user_pw` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '비밀번호',
  `user_comp` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '회사명',
  `user_cls` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'user' COMMENT '유저등급',
  `new_dt` datetime NOT NULL,
  `mod_dt` datetime DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- 테이블 데이터 hunasys.USERS:~2 rows (대략적) 내보내기
DELETE FROM `USERS`;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
INSERT INTO `USERS` (`user_id`, `user_pw`, `user_comp`, `user_cls`, `new_dt`, `mod_dt`) VALUES
	('huna', 'qwe123', '관리자', 'admin', '2019-11-29 15:19:02', '2019-11-29 15:19:12'),
	('user01', 'qwe123', '내맘대로 회사', 'user', '2019-11-29 15:19:02', '2019-11-29 15:19:12');
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
