# Rent-Manager

## Lancer le projet

Ce projet utilise Maven en système de construction et Tomcat comme serveur web. <br>
Pour lancer l’application web : <br>
Taper la commande `mvn tomcat7:run`  et se rendre à l’adresse http://localhost:8080/rentmanager.

## Contraintes fonctionnelles

- Un client n’ayant pas 18 ans peut être créé (fonction jQuery isAdult() )
- Un client ayant une adresse mail déjà prise ne peut pas être créé (fonction jQuery checkEmail() )
- Le nom et le prénom d’un client doivent faire au moins 3 caractères (Attribut html required pattern)
- Une voiture ne peut pas être réservée plus de 7 jours de suite par le même utilisateur (fonction jQuery checkDate())
- Si un client ou un véhicule est supprimé, alors il faut supprimer les réservations associées (ON DELETE)
- Une voiture doit avoir un modèle et un constructeur, son nombre de place doit être compris entre 2 et 9 (Attributs html min et max)

## Contraintes non fonctionnelles

- Une voiture ne peut pas être réservée 30 jours de suite sans pause
- Une voiture ne peut pas être réservée 2 fois le même jour

## Pistes d’amélioration
	
- Contraintes non réussis
- Barre de recherche pour rechercher clients par nom
-  Barre de recherche pour rechercher véhicule par sa marque ou son modèle
