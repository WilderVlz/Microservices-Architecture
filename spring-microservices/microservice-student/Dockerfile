FROM eclipse-temurin:17

LABEL author="WilderVlz"

COPY target/microservice-student-0.0.1-SNAPSHOT.jar student-app.jar

ENTRYPOINT ["java", "-jar", "student-app.jar"]

EXPOSE 8030