



# ---------- STAGE 1: build ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# ---------- STAGE 2: run ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
# copia el jar ejecutable
COPY --from=build src/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar
# copia la base de datos (ajusta la ruta si tu .db está en otro lado)
COPY --from=build data/miapp.db ./data/miapp.db
# expón el puerto que usa Spring Boot
EXPOSE 8080
# arranca el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
