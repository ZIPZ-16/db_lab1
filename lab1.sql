-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Хост: 127.0.0.1:3306
-- Час створення: Січ 21 2019 р., 02:12
-- Версія сервера: 5.7.16
-- Версія PHP: 7.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- База даних: `lab1`
--

-- --------------------------------------------------------

--
-- Структура таблиці `groups`
--

CREATE TABLE `groups` (
  `id` int(10) NOT NULL,
  `shifr` varchar(255) NOT NULL,
  `spec_id` int(10) NOT NULL,
  `kafedra_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `kafedry`
--

CREATE TABLE `kafedry` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `faculty` varchar(255) DEFAULT NULL,
  `zav` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `spec`
--

CREATE TABLE `spec` (
  `id` int(11) NOT NULL,
  `code` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `otrasl` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблиці `students`
--

CREATE TABLE `students` (
  `id` int(10) NOT NULL,
  `name` varchar(255) NOT NULL,
  `group_id` int(10) NOT NULL,
  `year` date DEFAULT NULL,
  `rating` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Індекси збережених таблиць
--

--
-- Індекси таблиці `groups`
--
ALTER TABLE `groups`
  ADD PRIMARY KEY (`id`),
  ADD KEY `spec_id` (`spec_id`),
  ADD KEY `kafedra_id` (`kafedra_id`);

--
-- Індекси таблиці `kafedry`
--
ALTER TABLE `kafedry`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `spec`
--
ALTER TABLE `spec`
  ADD PRIMARY KEY (`id`);

--
-- Індекси таблиці `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`id`),
  ADD KEY `group_id` (`group_id`);

--
-- AUTO_INCREMENT для збережених таблиць
--

--
-- AUTO_INCREMENT для таблиці `groups`
--
ALTER TABLE `groups`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблиці `kafedry`
--
ALTER TABLE `kafedry`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблиці `spec`
--
ALTER TABLE `spec`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT для таблиці `students`
--
ALTER TABLE `students`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT;
--
-- Обмеження зовнішнього ключа збережених таблиць
--

--
-- Обмеження зовнішнього ключа таблиці `groups`
--
ALTER TABLE `groups`
  ADD CONSTRAINT `groups_ibfk_1` FOREIGN KEY (`spec_id`) REFERENCES `spec` (`id`),
  ADD CONSTRAINT `groups_ibfk_2` FOREIGN KEY (`kafedra_id`) REFERENCES `kafedry` (`id`);

--
-- Обмеження зовнішнього ключа таблиці `students`
--
ALTER TABLE `students`
  ADD CONSTRAINT `students_ibfk_1` FOREIGN KEY (`group_id`) REFERENCES `groups` (`id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
