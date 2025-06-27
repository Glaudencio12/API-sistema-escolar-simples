FROM eclipse-temurin:21-jdk
LABEL authors="Glaudencio"
COPY target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]