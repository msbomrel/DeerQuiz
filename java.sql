-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Nov 24, 2016 at 03:49 PM
-- Server version: 5.7.16-0ubuntu0.16.04.1
-- PHP Version: 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `java`
--

-- --------------------------------------------------------

--
-- Table structure for table `questions`
--

CREATE TABLE `questions` (
  `id` int(100) NOT NULL,
  `question` varchar(100) NOT NULL,
  `option1` varchar(20) NOT NULL,
  `option2` varchar(20) NOT NULL,
  `option3` varchar(20) NOT NULL,
  `option4` varchar(20) NOT NULL,
  `correctanswer` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `questions`
--

INSERT INTO `questions` (`id`, `question`, `option1`, `option2`, `option3`, `option4`, `correctanswer`, `category`) VALUES
(13, 'What is the area of Nepal?', '147181 sq. km', '142123 sq. km', '142444 sq. km', '134333 sq. km', '147181 sq. km', 'Genereal Knowledge'),
(14, 'Who is the prime minister of Nepal?', 'Prachanda', 'Sushil Koirala', 'Baburam Bhattarai', 'Rishi Dhamala', 'Prachanda', 'Politics'),
(15, 'Which is the largest bilateral donor to Nepal?', 'India', 'China', 'Korea', 'Japan', 'Japan', 'GK'),
(16, ' How many  principal organs are in UNO ?', '4', '5', '6', '7', '6', 'GK'),
(17, 'Without being the member of UNO, which country can vote independently?', 'America', 'Nepal', 'China ', 'India', 'America', 'GK');

-- --------------------------------------------------------

--
-- Table structure for table `quizscore`
--

CREATE TABLE `quizscore` (
  `id` int(20) NOT NULL,
  `userid` int(20) NOT NULL,
  `scores` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `quizscore`
--

INSERT INTO `quizscore` (`id`, `userid`, `scores`) VALUES
(1, 21, 2),
(2, 21, 3),
(3, 21, 3),
(4, 21, 3),
(5, 30, 3),
(6, 21, 3),
(7, 21, 3),
(8, 21, 3),
(9, 21, 3),
(10, 21, 4),
(11, 21, 3);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `role`) VALUES
(21, 'admin', 'admin', 'done'),
(30, 'mohan', 'gopal', 'adm'),
(31, 'geeta', 'geeta', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `questions`
--
ALTER TABLE `questions`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `quizscore`
--
ALTER TABLE `quizscore`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `questions`
--
ALTER TABLE `questions`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `quizscore`
--
ALTER TABLE `quizscore`
  MODIFY `id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
