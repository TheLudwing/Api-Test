



# ---------- STAGE 1: build ----------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
COPY db ./data               # ← asegúrate de que tu .db esté en db/miapp.db
RUN mvn clean package -DskipTests

# ---------- STAGE 2: run ----------
FROM eclipse-temurin:17-jre
WORKDIR /app
# copia el jar ejecutable
COPY --from=build /app/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar
# copia la base de datos
COPY --from=build /app/db/miapp.db ./db/miapp.db
# expón el puerto que usa Spring Boot
EXPOSE 8080
# arranca el jar
ENTRYPOINT ["java", "-jar", "app.jar"]
