# Sistema de Administracion de Transportes

## Integrantes
- Fernández López Adrián Octavio
- Garrido Morales Diego Edmundo
- Gutiérrez de la Loma Samuel
- Vidal Herrera Viviana Abiguel

## Requisitos

### Desarrollo

- Netbeans 8 (No se ha probado pero debe funcionar en Netbeans 7.4)
- JDK 7 (JDK 8 recomendado)
- Oracle Glassfish 4
- MySQL 5 (Debe funcionar en otros servidores cambiando persistance.xml)

### Produccion

- Un servidor compatible con Java EE 7 (WildFly, Tomcat 8, WebSphere, etc)
- JRE 7 (JRE 8 recomendado)
- MySQL 5 (Debe funcionar en otros servidores cambiando persistance.xml)

## Instalacion

1. Debe descargar el proyecto en .zip o a traves de https://github.com/DOUXSYSTEM/SIAT.git usando Git
2. Abra el proyecto con NetBeans 8 (No se ha probado en 7.4, no funciona en <=7.3)
3. Una vez descargado el proyecto, debera restaurar las dependencias de Maven
    - Esto se hace dando click derecho sobre el proyecto => `Build with dependencies`
4. Debe indicar su usuario y contraseña de la base de datos
    4.1. Dentro del proyecto, en la carpeta `Other Sources`=>`src\main\resources`, hay un archivo llamado `persistance.xml`
    4.2. Seleccione la pestaña `Source` y modifique los cambos correspondientes a `User` y `Password` del XML
        - Si desea usar otra base de datos (Como SQL Server o PostgreSQL) debe cambiar tambien la directiva del Driver
        - En teoria, esto debe de reestablecer la base de datos, pero si por algun motivo no fue asi, hay un fichero DumpXXXXX.sql en la carpeta raiz de este proyecto
5. Ejecuta el proyecto, deberia de funcionar.