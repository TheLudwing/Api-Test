



FROM openjdk:17-slim

COPY --from=build /app/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar
COPY data/miapp.db ./data/miapp.db
EXPOSE 8080
CMD["java", "-jar","/app/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar"]
