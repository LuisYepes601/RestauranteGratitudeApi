

FROM eclipse-temurin:17-jdk

# Copia el archivo .jar generado desde la etapa anterior
COPY target/demp-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
