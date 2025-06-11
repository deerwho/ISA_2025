-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2025 at 10:57 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `film`
--

CREATE TABLE `film` (
  `id` int(11) NOT NULL,
  `naziv` varchar(50) NOT NULL,
  `trajanje` int(11) NOT NULL,
  `reziser` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `film`
--

INSERT INTO `film` (`id`, `naziv`, `trajanje`, `reziser`) VALUES
(1, 'Avengers: Endgame', 185, 'Entoni Ruso, Dzo Ruso'),
(2, 'Ko to tamo peva', 100, 'Slobodan Sijan');

-- --------------------------------------------------------

--
-- Table structure for table `karta`
--

CREATE TABLE `karta` (
  `id` int(11) NOT NULL,
  `korisnikID` int(11) NOT NULL,
  `filmID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `karta`
--

INSERT INTO `karta` (`id`, `korisnikID`, `filmID`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `korisnicifilmovi`
--

CREATE TABLE `korisnicifilmovi` (
  `korisnikID` int(11) NOT NULL,
  `filmID` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnicifilmovi`
--

INSERT INTO `korisnicifilmovi` (`korisnikID`, `filmID`, `id`) VALUES
(1, 1, 1),
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `korisnik`
--

CREATE TABLE `korisnik` (
  `id` int(11) NOT NULL,
  `ime` varchar(25) NOT NULL,
  `prezime` varchar(25) NOT NULL,
  `email` varchar(50) NOT NULL,
  `godine` int(11) NOT NULL,
  `lozinka` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `korisnik`
--

INSERT INTO `korisnik` (`id`, `ime`, `prezime`, `email`, `godine`, `lozinka`) VALUES
(1, 'Vojin', 'Cvetkovic', 'vojin@singimail.rs', 21, '123456789'),
(2, 'Petar', 'Petrovic', 'petar@gmail.com', 17, '123456789'),
(4, 'Nikola', 'Nikolic', 'nikola@gmail.com', 25, '123456789'),
(5, 'Nikola', 'Nikolic', 'nikola@gmail.com', 25, '123456789'),
(6, 'Vojin', 'Cvetkovic', 'vojin@singimail.rs', 21, '123456789'),
(7, 'Petar', 'Petrovic', 'petar@gmail.com', 17, '123456789'),
(8, 'Nikola', 'Nikolic', 'nikola@gmail.com', 25, '123456789'),
(9, 'Mita', 'Mitic', 'mmitic@gmail.com', 34, '123456789'),
(10, 'Vojin', 'Cvetkovic', 'vojin@singimail.rs', 21, '123456789'),
(11, 'Petar', 'Petrovic', 'petar@gmail.com', 17, '123456789'),
(12, 'Nikola', 'Nikolic', 'nikola@gmail.com', 25, '123456789'),
(16, 'Cira', 'Ciric', 'cciric@gmail.com', 25, '123456789');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `film`
--
ALTER TABLE `film`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `karta`
--
ALTER TABLE `karta`
  ADD PRIMARY KEY (`id`),
  ADD KEY `film_fk` (`filmID`),
  ADD KEY `korisnik_fk` (`korisnikID`);

--
-- Indexes for table `korisnicifilmovi`
--
ALTER TABLE `korisnicifilmovi`
  ADD PRIMARY KEY (`id`),
  ADD KEY `filmkorisnik_fk` (`korisnikID`),
  ADD KEY `korfilm_fk` (`filmID`);

--
-- Indexes for table `korisnik`
--
ALTER TABLE `korisnik`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `film`
--
ALTER TABLE `film`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `karta`
--
ALTER TABLE `karta`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `korisnicifilmovi`
--
ALTER TABLE `korisnicifilmovi`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `korisnik`
--
ALTER TABLE `korisnik`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `karta`
--
ALTER TABLE `karta`
  ADD CONSTRAINT `film_fk` FOREIGN KEY (`filmID`) REFERENCES `film` (`id`),
  ADD CONSTRAINT `korisnik_fk` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`id`);

--
-- Constraints for table `korisnicifilmovi`
--
ALTER TABLE `korisnicifilmovi`
  ADD CONSTRAINT `filmkorisnik_fk` FOREIGN KEY (`korisnikID`) REFERENCES `korisnik` (`id`),
  ADD CONSTRAINT `korfilm_fk` FOREIGN KEY (`filmID`) REFERENCES `film` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
