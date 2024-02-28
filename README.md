# Front and API Testing

Este proyecto fue diseñado en Java en su verison 18, utilizando Maven como gestor de dependencias y se implementó la 
libreria RestAssured para realizar las pruebas API.

**Instrucciones para la Ejecucion de las pruebas**

Las pruebas se pueden ejecutar de 2 formas:

* Ejecutando la clases **ApiTest** y **PurchaseProcessTest** que se encuentran ubicadas en el path: 
**src/test/java/test_api/** y  **src/test/java/test_UI/** Se utiliza JUnit para su ejecución
* Por medio de la terminal ejecutando el comando mvn clean test el cual ejecuta todos los test del proyecto.

Una ves ejecutadas las pruebas, se creará un carpeta llamada **reports** dentro del proyecto, la cual genera un archivo 
.html que contiene el reporte de las pruebas, que al abrirlo en el IDE y seleccionando un navegador de preferencia se 
puede visualizar el informe de las pruebas ejecutadas.