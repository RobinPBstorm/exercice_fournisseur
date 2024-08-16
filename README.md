# Gestion de fournisseur (Exercice sur l'Orienté Objet en Java)
Créer une classe Fournisseur qui représente un fournisseur. Un fournisseur doit avoir les attributs suivants :

id (entier)
nom (chaîne de caractères)
email (chaîne de caractères)
telephone (chaîne de caractères)

(BONUS)Créer une classe FournisseurService qui contient la logique métier pour la gestion des fournisseurs, y compris les méthodes CRUD :

creerFournisseur(Fournisseur fournisseur)
lireFournisseur(int id)
mettreAJourFournisseur(int id,Fournisseur fournisseur)
supprimerFournisseur(int id)
listerFournisseurs()
Ajouter des validations lors de la création et de la mise à jour des fournisseurs :

Le nom ne doit pas être vide.
L'email doit avoir un format valide (exemple : example@domaine.com).
Le numéro de téléphone doit être composé uniquement de chiffres et contenir entre 10 et 15 caractères.

Créer un fournisseur.
Lire les informations d'un fournisseur en spécifiant son ID.
Mettre à jour les informations d'un fournisseur.
Supprimer un fournisseur.
Lister tous les fournisseurs.
Choisir le type de validation à appliquer.

Menu Interactif :
Voici un exemple de ce à quoi pourrait ressembler le menu interactif :

1. Créer un fournisseur
2. Lire un fournisseur
3. Mettre à jour un fournisseur
4. Supprimer un fournisseur
5. Lister tous les fournisseurs
6. Choisir le type de validation (standard/stricte)
7. Quitter

Consignes :
Utilisez les principes de la POO pour structurer votre code.
Assurez-vous que les validations sont correctement implémentées et déclenchent des messages d'erreur appropriés en cas de non-conformité.
Commentez votre code pour expliquer les choix de conception et les méthodes utilisées.
Utilisez les exceptions pour gérer les erreurs (par exemple, fournisseur non trouvé).

BONUS : Demander a l'utilisateur de valider son choix en cas d ajout / modification ou suppression 
En montrant les potentielles valeurs qui vont être écrasée.
