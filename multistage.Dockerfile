# Imagen base para el contenedor de compilación
# Necesitamos tener los archivos protobuf obtenidos de /target de la compilacion
FROM maven:3.9.0-eclipse-temurin-17 as builder
WORKDIR /inditex-hexagonal-api-test/app
COPY /src /inditex-hexagonal-api-test/app/src
COPY pom.xml /inditex-hexagonal-api-test/app
RUN mvn -B clean package -DskipTests

# Imagen base para el contenedor de la aplicación
FROM eclipse-temurin:17-jdk
WORKDIR /usr/src/app/
COPY --from=builder /inditex-hexagonal-api-test/app/target/*.jar /usr/src/app/

EXPOSE 8080
CMD [ "java", "-jar", "api-test-1.0.0-RC.jar" ]
