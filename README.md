# style-alert

## Back-end

Es necesario instalar: 
- openJDK11
- MySQL
- Maven
- Docker

Para poder ejecutar el proyecto es necesario: 

1. Crear usuario y contraseña en MySQL
2. Configurar la conexión a la base de datos "stylealert"
3. Ejecutar "scriptQueFacilitaLaVida.sh"

## Front-end

- Instalar [nodejs](https://nodejs.org/en/download/)

Esto instala también el gestor de paquetes `npm`

- Instalar vue-cli, una herramienta para facilitar el manejo de los proyectos: `npm install -g @vue/cli`

Con esto desde la terminal se puede abrir una interfaz gráfica usando `vue ui`. Desde esta se pueden crear e importar proyectos, manejar sus dependencias, ejecutar y buildearlos, etc.

Para trabajar con el proyecto, tras hacer el clone hay que colocarse en `/style-alert/frontend` y hacer `npm install` para instalar todas las dependencias. (Estas están en el archivo `package.json`).

Para ejecutar el programa se usa el comando `npm run serve`. Con esto se puede abrir la web generada por el proyecto en `localhost:8080`.

Para buildear el proyecto, el comando es `npm run build`. La build se genera en el directorio `/dist`