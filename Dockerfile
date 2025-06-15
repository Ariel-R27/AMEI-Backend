# Usa una imagen base de OpenJDK
FROM openjdk:17-jdk-slim

# Establece el directorio de trabajo
WORKDIR /app

# Copia el archivo JAR generado a la imagen Docker
COPY target/amei-0.0.1-SNAPSHOT.jar /app/amei.jar

# Expone el puerto en el que Spring Boot corre por defecto
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "amei.jar"]