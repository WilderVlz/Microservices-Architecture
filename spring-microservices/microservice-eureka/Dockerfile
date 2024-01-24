FROM eclipse-temurin:17

LABEL author="WilderVlz"

COPY target/microservice-eureka-0.0.1-SNAPSHOT.jar eureka-app.jar

ENTRYPOINT ["java", "-jar", "eureka-app.jar"]

EXPOSE 8761