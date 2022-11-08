# Tasca_S5_01_N1 
## Spring boot API rest + Aplicació web

![N|Solid](https://logistreak.com/images/icon/mysql.png)

![foxdemo](https://github.com/foxdemo/foxdemo.github.io/blob/master/assets/images/avatar.png)
En aquesta tasca faràs un CRUD (Create, Read, Update, Delete) que pugui ser cridat com a API Rest i, també, com aplicació web..


## Objetius
- Protocol HTTP / REST.
- JPA.
- CRUD amb Spring.
- MySQL.
- Thymeleaf.


## Exercici CRUD amb H2 i MYSQL

Tenim una entitat anomenada Sucursal, que disposa de les següents propietats:

- Integer pk_SucursalID
- String nomSucursal
- String paisSucursal

També tenim una DTO anomenada SucursalDTO, que tindrà les mateixes propietats que l’entitat Sucursal, afegint-ne una:

- String tipusSucursal.

Aquesta propietat, en funció del país de la sucursal, haurà d’indicar si és “UE” o “Fora UE”. Per a fer això, pots tenir una llista privada a la mateixa DTO (per exemple: List<String> països), amb els països que formen part de la UE.

Aprofitant l’especificació JPA, hauràs de persistir l’entitat Sucursal a una base de dades MySql, seguint el patró MVC.

El consell és que SucursalDTO la facis servir al Controller y la Vista, i Sucursal al Repository. La capa de serveis serà l’encarregada de fer la traducció entre les dues.

Per a això, depenent del package principal, crearàs una estructura de packages, on ubicaràs les classes que necessitis:

-  cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.controllers
-  cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.domain
-  cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.dto
-  cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.services
-  cat.itacademy.barcelonactiva.cognoms.nom.s05.t01.n01.model.repository

![](https://github.com/gonzashan/Tasca_S5_T01_N1/blob/main/screen-capture-S5-T01-N1/S05T01N01_Tree.png)
   
    <img src="https://github.com/gonzashan/Tasca_S5_T01_N1/blob/main/screen-capture-S5-T01-N1/S05T01N01_Tree.png" height="60" width="60" >

La classe ubicada al paquet controllers (SucursalController, per exemple), haurà de ser capaç de donar resposta a les següents peticions per actualitzar i consultar informació:

    http://localhost:9000/sucursal/add
    http://localhost:9000/sucursal/update
    http://localhost:9000/sucursal/delete/{id}
    http://localhost:9000/sucursal/getOne/{id}
    http://localhost:9000/sucursal/getAll

Com pots veure, a l’arxiu application.properties, hauràs de configurar que el port a utilitzar sigui el 9000.

La vista haurà d’estar desenvolupada amb Thymeleaf.

Per tal de fer-la més atractiva, pots usar opcionalment alguna llibreria CSS que t’ho faciliti, com bootstrap, tailwind, material, etc.

# Resultats
       http://localhost:9000/sucursal/delete/{id}
 <img src="https://github.com/gonzashan/Tasca_S5_T01_N1/blob/main/screen-capture-S5-T01-N1/delete.png" height="60" width="60" >
