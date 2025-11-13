



# ---------- STAGE 1: build ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY data ./data               # ← tu carpeta es data/, no db/
RUN mvn clean package -DskipTests

# ---------- STAGE 2: run ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
# copia el jar ejecutable
COPY --from=build /app/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar
# copia la base de datos
COPY --from=build /app/data/miapp.db ./data/miapp.db
# expón el puerto que usa Spring Boot
EXPOSE 8080
# arranca el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
