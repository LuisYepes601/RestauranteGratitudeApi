
# Etapa 1: construir el proyecto con Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia todo el proyecto al contenedor
COPY . .

# Compila el proyecto sin ejecutar tests
RUN mvn clean package -DskipTests

# Etapa 2: imagen final con JDK
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copia el archivo .jar generado desde la etapa anterior
COPY --from=build /app/target/demp-0.0.1-SNAPSHOT.jar app.jar

# Exponer el puerto que usará Render
EXPOSE 8080

# Comando para ejecutar la app
ENTRYPOINT ["java", "-jar", "app.jar"]
