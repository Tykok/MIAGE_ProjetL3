-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : Dim 31 jan. 2021 à 15:20
-- Version du serveur :  10.4.14-MariaDB
-- Version de PHP : 7.3.21

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `projetl3`
--

-- --------------------------------------------------------

--
-- Structure de la table `etudiants`
--

CREATE TABLE `etudiants` (
  `numEtudiant` varchar(50) COLLATE utf8_bin NOT NULL,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `mention`
--

CREATE TABLE `mention` (
  `nomMention` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `parcours`
--

CREATE TABLE `parcours` (
  `nomMention` varchar(50) COLLATE utf8_bin NOT NULL,
  `numParcours` int(11) NOT NULL,
  `nomParcours` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `niveauParcours` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `prerequis`
--

CREATE TABLE `prerequis` (
  `codeUE` varchar(50) COLLATE utf8_bin NOT NULL,
  `codeUE_prerequis` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `proposer`
--

CREATE TABLE `proposer` (
  `codeUE` varchar(50) COLLATE utf8_bin NOT NULL,
  `nomMention` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `num` varchar(50) COLLATE utf8_bin NOT NULL,
  `role` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `nom` varchar(50) COLLATE utf8_bin NOT NULL,
  `prenom` varchar(50) COLLATE utf8_bin NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `ue`
--

CREATE TABLE `ue` (
  `codeUE` varchar(50) COLLATE utf8_bin NOT NULL,
  `creditUE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- --------------------------------------------------------

--
-- Structure de la table `validationue`
--

CREATE TABLE `validationue` (
  `codeUE` varchar(50) COLLATE utf8_bin NOT NULL,
  `num` varchar(50) COLLATE utf8_bin NOT NULL,
  `Annnee` int(11) NOT NULL,
  `Semestre` tinyint(1) NOT NULL,
  `Valider` tinyint(1) DEFAULT NULL,
  `Moyenne` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `etudiants`
--
ALTER TABLE `etudiants`
  ADD PRIMARY KEY (`numEtudiant`);

--
-- Index pour la table `mention`
--
ALTER TABLE `mention`
  ADD PRIMARY KEY (`nomMention`);

--
-- Index pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD PRIMARY KEY (`nomMention`,`numParcours`);

--
-- Index pour la table `prerequis`
--
ALTER TABLE `prerequis`
  ADD PRIMARY KEY (`codeUE`,`codeUE_prerequis`),
  ADD KEY `codeUE_1` (`codeUE_prerequis`);

--
-- Index pour la table `proposer`
--
ALTER TABLE `proposer`
  ADD PRIMARY KEY (`codeUE`,`nomMention`),
  ADD KEY `nomMention` (`nomMention`);

--
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`num`);

--
-- Index pour la table `ue`
--
ALTER TABLE `ue`
  ADD PRIMARY KEY (`codeUE`);

--
-- Index pour la table `validationue`
--
ALTER TABLE `validationue`
  ADD PRIMARY KEY (`codeUE`,`num`,`Annnee`,`Semestre`),
  ADD KEY `num` (`num`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `parcours`
--
ALTER TABLE `parcours`
  ADD CONSTRAINT `parcours_ibfk_1` FOREIGN KEY (`nomMention`) REFERENCES `mention` (`nomMention`);

--
-- Contraintes pour la table `prerequis`
--
ALTER TABLE `prerequis`
  ADD CONSTRAINT `prerequis_ibfk_1` FOREIGN KEY (`codeUE`) REFERENCES `ue` (`codeUE`),
  ADD CONSTRAINT `prerequis_ibfk_2` FOREIGN KEY (`codeUE_prerequis`) REFERENCES `ue` (`codeUE`);

--
-- Contraintes pour la table `proposer`
--
ALTER TABLE `proposer`
  ADD CONSTRAINT `proposer_ibfk_1` FOREIGN KEY (`codeUE`) REFERENCES `ue` (`codeUE`),
  ADD CONSTRAINT `proposer_ibfk_2` FOREIGN KEY (`nomMention`) REFERENCES `mention` (`nomMention`);

--
-- Contraintes pour la table `validationue`
--
ALTER TABLE `validationue`
  ADD CONSTRAINT `validationue_ibfk_1` FOREIGN KEY (`codeUE`) REFERENCES `ue` (`codeUE`),
  ADD CONSTRAINT `validationue_ibfk_2` FOREIGN KEY (`num`) REFERENCES `etudiants` (`numEtudiant`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
