## Instructions
Add this to your context.xml in TomEE:


<Resource
      name="jdbc/starwars"
      auth="Container"
      type="javax.sql.DataSource"
      maxActive="100"
      maxIdle="30"
      maxWait="10000"
      driverClassName="com.mysql.cj.jdbc.Driver"
      url="jdbc:mysql://localhost:8889/starwars"
      username="root"
      password="root"
    />
 
 
And don't forget to download mysql connector and add to lib folder:
https://dev.mysql.com/downloads/connector/j/

And make a database:

-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: Mar 03, 2021 at 09:07 AM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `starwars`
--

-- --------------------------------------------------------

--
-- Table structure for table `jedi`
--

CREATE TABLE `jedi` (
  `customerId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `darkside` tinyint(1) NOT NULL,
  `bsn` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `jedi`
--

INSERT INTO `jedi` (`customerId`, `name`, `darkside`, `bsn`) VALUES
(1, 'Darth Vader', 1, 5),
(2, 'Luke Skywalker', 0, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `jedi`
--
ALTER TABLE `jedi`
  ADD PRIMARY KEY (`customerId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `jedi`
--
ALTER TABLE `jedi`
  MODIFY `customerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
