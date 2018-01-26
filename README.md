# rappi-challenge
Mi prueba técnica para el proceso de selección de Rappi.com

## Sinopsis

Este proyecto existe como mi prueba técnica para Rappi.com, y consiste en cumplir las tareas listadas en el sitio: https://www.hackerrank.com/challenges/cube-summation/problem

## Requerimientos

Este proyecto está hecho sobre
* Java 8
* Apache Maven 3.3+

## Run

Armado con spring-boot por simplicidad, el plugin maven para spring boot está configurado y se puede levantar el servicio con el comando de maven:
``` $ mvn spring-boot:run ```

En caso de ocurrir algún error, es bueno asegurarse de que todo está bien compilado. Así que se puede incluir el target _clean_ para maven.
``` $ mvn clean compile spring-boot:run ```

## Tests

Para correr los tests, también se usa maven.
``` $ mvn test ```

## Autor

Aníbal A. Lovaglio
alelovaglio@gmail.com
