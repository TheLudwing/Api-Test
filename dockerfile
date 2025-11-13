



FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/TestHomo-0.0.1-SNAPSHOT.jar app.jar
COPY db/miapp.db ./db/miapp.db
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
