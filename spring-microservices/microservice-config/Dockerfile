FROM eclipse-temurin:17

LABEL author="WilderVlz"

COPY target/microservice-config-0.0.1-SNAPSHOT.jar config-app.jar

ENTRYPOINT ["java", "-jar", "config-app.jar"]

EXPOSE 8888