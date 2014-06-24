-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jun 24, 2014 at 11:57 PM
-- Server version: 5.6.16
-- PHP Version: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `host`
--

CREATE TABLE IF NOT EXISTS `host` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `address` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `active` int(11) NOT NULL,
  `downtime` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=3 ;

--
-- Dumping data for table `host`
--

INSERT INTO `host` (`ID`, `name`, `address`, `active`, `downtime`) VALUES
(1, 'test', '123.233.123.234', 1, 0),
(2, 'test2', '212.231.111.111', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `measurement`
--

CREATE TABLE IF NOT EXISTS `measurement` (
  `serviceID` int(11) NOT NULL,
  `hostID` int(11) NOT NULL,
  `datatime` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `value` int(11) NOT NULL,
  `status` varchar(15) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

-- --------------------------------------------------------

--
-- Table structure for table `monitor`
--

CREATE TABLE IF NOT EXISTS `monitor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `address` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `sync` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=4 ;

--
-- Dumping data for table `monitor`
--

INSERT INTO `monitor` (`id`, `name`, `address`, `sync`) VALUES
(1, 'monitor1', 'monitor1.address', 3),
(2, 'monitor1', 'monitor1.address', 0),
(3, 'asdasd', 'asdasd', 3);

-- --------------------------------------------------------

--
-- Table structure for table `monitorhosts`
--

CREATE TABLE IF NOT EXISTS `monitorhosts` (
  `MonitorID` int(11) NOT NULL,
  `HostId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `monitorhosts`
--

INSERT INTO `monitorhosts` (`MonitorID`, `HostId`) VALUES
(0, 2),
(0, 2),
(0, 2),
(0, 1),
(0, 2),
(0, 2),
(0, 1),
(0, 1),
(0, 2),
(0, 2),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1),
(0, 1);

-- --------------------------------------------------------

--
-- Table structure for table `problem`
--

CREATE TABLE IF NOT EXISTS `problem` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `serviceId` int(11) NOT NULL,
  `hostId` int(11) NOT NULL,
  `status` varchar(15) COLLATE utf8_polish_ci NOT NULL,
  `value` int(11) NOT NULL,
  `start` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `stop` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `ack` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=9 ;

--
-- Dumping data for table `problem`
--

INSERT INTO `problem` (`id`, `serviceId`, `hostId`, `status`, `value`, `start`, `stop`, `ack`) VALUES
(3, 32, 32, 'status', 32, 'start', 'start', 2),
(4, 32, 32, 'status', 32, 'start', 'start', 2),
(5, 32, 32, 'status', 32, 'start', 'start', 2),
(6, 32, 32, 'status', 32, 'start', 'start', 2),
(7, 32, 32, 'status', 32, 'start', 'start', 2),
(8, 3, 3, 'dsda', 3, 'asda', 'assa', 3);

-- --------------------------------------------------------

--
-- Table structure for table `service`
--

CREATE TABLE IF NOT EXISTS `service` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `command` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  `args` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `freq` int(11) NOT NULL,
  `hard` int(11) NOT NULL,
  `type` varchar(20) COLLATE utf8_polish_ci NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci AUTO_INCREMENT=5 ;

--
-- Dumping data for table `service`
--

INSERT INTO `service` (`ID`, `name`, `command`, `args`, `freq`, `hard`, `type`) VALUES
(1, 'name', 'command', 'args', 2, 1, 'type'),
(2, 'name', 'command', 'args', 2, 1, 'type'),
(3, 'name', 'command', 'args', 2, 1, 'type'),
(4, 'name', 'command', 'args', 2, 1, 'type');

-- --------------------------------------------------------

--
-- Table structure for table `servicehost`
--

CREATE TABLE IF NOT EXISTS `servicehost` (
  `ServiceID` int(11) NOT NULL,
  `HostID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

--
-- Dumping data for table `servicehost`
--

INSERT INTO `servicehost` (`ServiceID`, `HostID`) VALUES
(1, 1),
(1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `ID` int(11) NOT NULL,
  `name` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `email` varchar(30) COLLATE utf8_polish_ci NOT NULL,
  `mobile` int(11) NOT NULL,
  `xmpp` varchar(30) COLLATE utf8_polish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_polish_ci;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
