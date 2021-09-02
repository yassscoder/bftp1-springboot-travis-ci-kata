# SpringBoot + Travis CI 

Este proyecto sirve como ejemplo para practicar integración continua con Travis CI y hacer tests de integración.

Haz un fork para trabajar con él.


## Paso 1

- El proyecto incluye unos tests de ejemplo. Debéis analizarlos y entender lo que hacen (y el código que hace que pasen).
- El equipo debe trabajar con un solo repositorio y configurar TravisCI para que cada nuevo
 `push` haga que automáticamente se ejecuten los tests en el servidor. [Más información...](https://docs.travis-ci.com/user/tutorial/)

  Podéis usar el siguiente archivo de configuración de Travis:
    
  ```
  language: java
  jdk: openjdk16
  before_script:
    - chmod +x gradlew
  script:
    - ./gradlew check
  ```
  
Comprobad que Travis está correctamente configurado y que ejecuta los tests correctamente.
  
## Paso 2

Dividíos en 2 equipos y trabajad de forma independiente. Recordad escribir los tests (de integración) primero y luego el código que los hace pasar. Haced push en la misma rama cada vez que completéis una parte del código que funcione.


### Equipo 1

Completad los siguientes endpoints:

| Método | path | body | respuesta | descripción |
|--------|------|------|-------------|-------------|
| POST   | `/products/buy` | `[{ "name": "camiseta", "price": "10.00" },{ "name": "pantalón", "price": "30.00" }]` | `{ "response": "Gracias por su compra. 2 productos por un total de 40 euros" }` | recibe una lista de productos y responde con el precio total  |
| POST   | `/products/buy` | `[{ "name": "camiseta", "price": "10.00", "discountHalfPrice": true },{ "name": "pantalón", "price": "30.00" }]` | `{ "response": "Gracias por su compra. 2 productos por un total de 35 euros" }` | El primer producto de la lista tiene un 50% de descuento |   


### Equipo 2

Completad los siguientes endpoints:

| Método | path | body | respuesta | descripción |
|--------|------|------|-------------|-------------|
| POST   | `/products/return` | `[{ "name": (NOMBRE1), "price": (PRECIO1) },{ "name": (NOMBRE2), "price": (PRECIO2) }]` | `{ "response": "Gracias por su devolución. Se han devuelto 2 productos por un total de (PRECIO1+PRECIO2) euros" }` | recibe una lista de productos que queremos devolver y responde con el precio total que nos ingresarán |
| POST   | `/products/return` | `[{ "name": (NOMBRE1), "price": (PRECIO1), "isReturnable": false },{ "name": (NOMBRE2), "price": (PRECIO2) }]` | `{ "response": "Gracias por su devolución. Se ha devuelto 1 producto por un total de (PRECIO2) euros" }` | El primer producto de la lista no se puede devolver, por lo que sólo nos devolverán el coste del segundo |   



  
