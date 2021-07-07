-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Mer 02 Juin 2021 à 02:16
-- Version du serveur :  5.6.17
-- Version de PHP :  5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `produit`
--

-- --------------------------------------------------------

--
-- Structure de la table `t_categorie`
--

CREATE TABLE IF NOT EXISTS `t_categorie` (
  `idC` int(11) NOT NULL AUTO_INCREMENT,
  `nomC` varchar(30) NOT NULL,
  PRIMARY KEY (`idC`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=25 ;

--
-- Contenu de la table `t_categorie`
--

INSERT INTO `t_categorie` (`idC`, `nomC`) VALUES
(1, 'info'),
(2, 'electro'),
(10, 'cat222'),
(13, 'telephonie'),
(18, 'info'),
(21, 'cat'),
(22, 'cat2'),
(23, 'cosmetique'),
(24, 'robotic');

-- --------------------------------------------------------

--
-- Structure de la table `t_produit`
--

CREATE TABLE IF NOT EXISTS `t_produit` (
  `idP` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(30) NOT NULL,
  `prix` double NOT NULL,
  `quantite` double NOT NULL,
  `nomC` varchar(30) NOT NULL,
  PRIMARY KEY (`idP`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Contenu de la table `t_produit`
--

INSERT INTO `t_produit` (`idP`, `nom`, `prix`, `quantite`, `nomC`) VALUES
(2, 'machine', 12, 1, 'electro'),
(5, 'robot', 50, 1, 'electro'),
(6, 'secheoir', 12, 1, 'electro'),
(7, 'rouge a levre', 10, 2, 'cosmetique'),
(8, 'machin', 15, 3, 'info');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
