# style-alert

## Back-end

Es necesario instalar: 
- openJDK11
- MySQL
- Maven
- Docker

Para poder ejecutar el proyecto es necesario: 

1. Crear usuario y contraseña en MySQL.  Es importante habilitar al usuario de todos los permisos.
    `usuario: grupoA`
    `contraseña: 1234`

2. Configurar la conexión a la base de datos "stylealert"
    Host: localhost
    Puerto: 3306
   
    Hay que crear el schema: stylealert
   
3. Ejecutar "scriptQueFacilitaLaVida.sh". Mientras no haya script ejecutar los comandos de abajo:

``` 
    mvn clean install -U
```
Si no tienes instalado el maven en terminal, puedes usar los atajos de IntelliJ, pero recomiendo descargarlo.
``` 
    java -jar target/style-alert-1.0-SNAPSHOT.jar
```
