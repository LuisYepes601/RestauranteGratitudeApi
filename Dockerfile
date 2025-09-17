
# Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
# Click nbfs://nbhost/SystemFileSystem/Templates/Other/Dockerfile to edit this template

# Imagen base con Java 17 (ajusta si usas otra versión)
FROM openjdk:17-jdk-slim

# Argumento para el JAR
ARG JAR_FILE=target/*.jar