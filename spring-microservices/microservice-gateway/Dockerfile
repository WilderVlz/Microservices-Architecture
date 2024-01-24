FROM eclipse-temurin:17

LABEL author="WilderVlz"

COPY target/microservice-gateway-0.0.1-SNAPSHOT.jar gateway-app.jar

ENTRYPOINT ["java", "-jar", "gateway-app.jar"]

EXPOSE 8080