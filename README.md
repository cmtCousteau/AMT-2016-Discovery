# AMT Discovery 2016

## How to use

First step you need to download the project. Next you must have docker and docker-compose installed.

Next go to the directory *AMT-2016-Discovery* and use the following command : ``docker-compose.exe up --build``.

After downling a few thing the web application should be running.
To access the web app you should use this adress :   
``http://192.168.99.100:9090/AMT_labo1_webApp-1.0-SNAPSHOT/``.

To access the command console use the this one ``http://192.168.99.100:9990/console/App.html``.  
username : *admin*  
password : *admin*

##Base de données

![Screenshot](doc/db.png)

## fonctionnement de l'architecture

![Screenshot](doc/diagramme.png)


## api REST
* **GET** : notre api REST contient 2 *GET*,l'un retourne tous les utilisateurs contenaut dans la base de données, et l'autre retourne les informations
d'un seul utilisateur en fonction de l'ID reçu dans l'URL.
* **POST** : notre api REST contient une méthode *POST* qui permet la création d'un nouvel utilisateur dans la base de données.
* **DELETE** : notre api REST contient une méthode *DELETE* qui permet de supprimer un utilisateur de la base de données en fonctions
de l'ID reçu dans l'URL.
* **PUT** : notre api REST contient une méthode *PUT* qui permet actuellement de modifier tous les champs de l'utilisateur d'un seul coup(sauf l'ID),
nous ne faisont pas de test pour voir quel champs sont défini dans le JSON et lesquels ne sont pas définis.

## Choix et améliorations à faire
* Premièrement au niveau de l'architecture du code nous avons utilisé une seule DTO, cette DTO contient le mot de 
pass de l'utilisateur (ce qui nous permet de le changer facilement avec l'api REST), ce qui n'est pas terrible. Nous avons procéder ainsi pour des raisons de simplicité mais
également parce que notre login se fait encore avec un servlet et n'utilise pas encore l'api REST.

* L'ID de l'utilisateur peut également être modifier à l'intérieur du code, ce qui est faux, mais j'ai eu besoin
de cette fonctionnalité lors de la création d'un utilisateur, en effet comme l'ID et déféni de manière automatique
je ne peux pas las définir tous de suite dans l'objet DTO, je dois dabord aller la chercher dans la base de données
et ensuite l'attribué au nouvel objet DTO contenant l'utilisateur.

* Une fois un utilisateur créé il faut clicker sur le bouton login et entrer à nouveau ces informations, ce qui pourraît
être amélioré en logguant l'utilisateur directement à la création du compte.

* La méthode *PUT* du CRUD ne vérifie pas si le nouveau username n'est pas déjà utilisé, on peut donc se retrouver avec 2 personnes avec le même username.

## Test de l'api REST avec postman