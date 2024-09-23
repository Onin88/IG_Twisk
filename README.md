# Projet d'Interface Graphique "Twisk"

### Auteur x Programmeur
- BELUCHE Quentin

> [!NOTE]
> Voici le lien pour une explication plus clarifiée par notre licence : https://licence-master-informatique.formation.univ-lorraine.fr/portfolio/projet-twisk-2020-21/
> (Ce site contient des images du projet).


## Explications
Ce projet est une simulation à événements discrets.

L’utilisateur dispose d’une interface graphique pour créer et dessiner un monde. Un monde est composé de différentes étapes dans lesquelles vont circuler des “clients”.

Les étapes représentent des activités : piscine, toboggan, zoo qui vont pouvoir accueillir des clients. Certaines activités ont un nombre de places limité et sont donc 
précédées par un service de distribution de jetons, un guichet, modélisé par une file d’attente. Lorsque l’utilisateur a terminé la création de son monde, il peut demander
à simuler l’évolution des clients dans les différentes étapes.

La programmation de l’application a été faite en java, sous Intellij Idea et avec la bibliothèque graphique javaFX. Les clients sont représentés par des processus C qui 
cheminent dans le monde de l’utilisateur, et se synchronisent et communiquent grâce à l’usage de sémaphores et d’un segment de mémoire partagée.
