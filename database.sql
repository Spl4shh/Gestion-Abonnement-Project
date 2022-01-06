-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Client :  devbdd.iutmetz.univ-lorraine.fr
-- Généré le :  Jeu 06 Janvier 2022 à 21:42
-- Version du serveur :  10.3.32-MariaDB
-- Version de PHP :  7.1.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `nataneli1u_td_cpoa`
--

-- --------------------------------------------------------

--
-- Structure de la table `Abonnement`
--

CREATE TABLE IF NOT EXISTS `Abonnement` (
  `id_abonnement` int(11) NOT NULL,
  `date_debut` date NOT NULL,
  `date_fin` date NOT NULL,
  `id_client` int(11) NOT NULL,
  `id_revue` int(4) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Abonnement`
--

INSERT INTO `Abonnement` (`id_abonnement`, `date_debut`, `date_fin`, `id_client`, `id_revue`) VALUES
(43, '2021-11-23', '2021-12-12', 44, 1),
(44, '2021-12-07', '2023-11-18', 45, 44);

-- --------------------------------------------------------

--
-- Structure de la table `Client`
--

CREATE TABLE IF NOT EXISTS `Client` (
  `id_client` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `no_rue` varchar(8) DEFAULT NULL,
  `voie` varchar(80) DEFAULT NULL,
  `code_postal` varchar(10) DEFAULT NULL,
  `ville` varchar(30) DEFAULT NULL,
  `pays` varchar(30) DEFAULT NULL
) ENGINE=MyISAM AUTO_INCREMENT=48 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Client`
--

INSERT INTO `Client` (`id_client`, `nom`, `prenom`, `no_rue`, `voie`, `code_postal`, `ville`, `pays`) VALUES
(44, 'Mikael', 'Jackson', '1', ', rue de la harrissa', '12345', 'Jolie Ville', 'Egypte'),
(43, 'Gérard', 'Patrick', '5', ', rue du frêne', '56789', 'Perdue', 'Zoneblanche'),
(45, 'Josh', 'Richard', '9', ', avenue de chez moi', '88596', 'Tik Ville', 'France'),
(46, 'Tom', 'Tom', '5485', ', fb. du quartier', '88542', 'Jolie Pays', 'Tunisie'),
(47, 'Chiot', 'Chicago', '1', ', alors la', '12345', 'Pouet Ville', 'Portugal');

-- --------------------------------------------------------

--
-- Structure de la table `Periodicite`
--

CREATE TABLE IF NOT EXISTS `Periodicite` (
  `id_periodicite` int(2) NOT NULL,
  `libelle` varchar(20) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=46 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Periodicite`
--

INSERT INTO `Periodicite` (`id_periodicite`, `libelle`) VALUES
(1, 'Mensuel'),
(2, 'Journalier'),
(3, 'Hebdomadaire');

-- --------------------------------------------------------

--
-- Structure de la table `Revue`
--

CREATE TABLE IF NOT EXISTS `Revue` (
  `id_revue` int(4) NOT NULL,
  `titre` varchar(40) NOT NULL,
  `description` varchar(400) NOT NULL,
  `tarif_numero` decimal(4,2) DEFAULT NULL,
  `visuel` varchar(200) DEFAULT NULL,
  `id_periodicite` int(2) NOT NULL
) ENGINE=MyISAM AUTO_INCREMENT=45 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Revue`
--

INSERT INTO `Revue` (`id_revue`, `titre`, `description`, `tarif_numero`, `visuel`, `id_periodicite`) VALUES
(1, 'Le Chat Matinal', 'Revue contenant uniquement des photos de chat pour vous egayer', 15.00, '', 1),
(44, 'La Patate', 'Il était une patate', 8.00, '', 2);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Abonnement`
--
ALTER TABLE `Abonnement`
  ADD PRIMARY KEY (`id_abonnement`);

--
-- Index pour la table `Client`
--
ALTER TABLE `Client`
  ADD PRIMARY KEY (`id_client`);

--
-- Index pour la table `Periodicite`
--
ALTER TABLE `Periodicite`
  ADD PRIMARY KEY (`id_periodicite`);

--
-- Index pour la table `Revue`
--
ALTER TABLE `Revue`
  ADD PRIMARY KEY (`id_revue`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Abonnement`
--
ALTER TABLE `Abonnement`
  MODIFY `id_abonnement` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=45;
--
-- AUTO_INCREMENT pour la table `Client`
--
ALTER TABLE `Client`
  MODIFY `id_client` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=48;
--
-- AUTO_INCREMENT pour la table `Periodicite`
--
ALTER TABLE `Periodicite`
  MODIFY `id_periodicite` int(2) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=46;
--
-- AUTO_INCREMENT pour la table `Revue`
--
ALTER TABLE `Revue`
  MODIFY `id_revue` int(4) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=45;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
