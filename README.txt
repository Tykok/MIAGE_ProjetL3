Ce fichier a pour but de préciser le fonctionnement de l'application

----------------------------------------------------------------------------------------------------------------------------
ETAPE 1

Lancer le .jar

Une fois lancé, choisir un des fichiers CSV où se trouve l'ensemble des autres fichiers CSV, ici les fichiers CSV ont été rangés dans le dossier nommé "Ressources/data".
PS : Le répertoire contenant l'ensemble des CSV (il doit OBLIGATOIREMENT contenir l'ensemble des CSV, sinon l'application risque de ne pas 
fonctionner)

Une fois ce répertoire choisit, il faut choisir un rôle (logique avec la combo box) :

Secrétaire : 
		- Login : Secretaire
		- Mot de passe : Admin

Directeur : 
		- Login : Directeur
		- Mot de passe : Admin

Bureau des examens : 
		- Login : Bureau
		- Mot de passe : Admin

----------------------------------------------------------------------------------------------------------------------------
ETAPE SECRETAIRE

La secrétaire peut voir l'ensemble des étudiants, et peut en ajouter un via le formulaire qu'elle a.
Pour inscrire un étudiant aux UE auquels il peut s'inscrire, elle peut double-clic sur un étudiant.

Par la suite elle peut inscrire un étudiant aux UE qu'elle aura cochés (checkBox), ou annuler et recommencer son choix.

En effectuant un clic droit sur un UE, il est aussi possible de voir les prérequis d'un UE.
----------------------------------------------------------------------------------------------------------------------------
ETAPE BUREAU DES EXAMENS

Le bureau des examens a accès à une liste des UE, via cette liste il peut double-clic sur un UE et voir les étudiants qui sont en cours de validation de cet UE,
il peut par la suite sélctionner avec un double-clic les étudiants qui auront validé cet UE ou recliquer sur la liste de droite pour effacer cette sélection.

En annulant, les deux listes sont remises à leur état initial.

En sauvegardant, l'ensemble des étudiants qui auront été selectionnés dans la liste de droite auront validés leurs UE

----------------------------------------------------------------------------------------------------------------------------
ETAPE DIRECTEUR

Tout comme la secrétaire, le directeur a accès à une liste d'étudiants.

En effectuant un double-clic dans la liste, il peut voir via trois onglets l'ensemble des UE  :

		- qu'un étudiant a validé
		- en cours
		- pour lequel il a les prérequis

En effectuant un clic droit sur un UE, il est aussi possible de voir les prérequis d'un UE.

----------------------------------------------------------------------------------------------------------------------------
AUTRE EXPLICATION

Le bouton retour permet de revenir à la vue précédente, et le bouton déconnexion permet de revenir à l'interface de connexion
