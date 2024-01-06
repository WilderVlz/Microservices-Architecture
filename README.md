# Microservices Project with Spring & Java

The system manages information about courses and students through an API Gateway. Below are details about the configuration and necessary steps to run the project successfully.

## Eureka Server
> The Eureka server will be available at the following address: http://localhost:8761/eureka.

## Database Configuration

### PostgreSQL

The PostgreSQL configuration is located in the file [msvc-course.yml](https://github.com/WilderVlz/Microservices-Architecture/blob/main/spring-microservices/microservice-config/src/main/resources/configurations/msvc-course.yml) Change the username and password for the database connection.

```yaml
  datasource:
  driver-class-name: org.postgresql.Driver
  url: jdbc:postgresql://localhost:5432/coursesDb
  username: YOUR_USERNAME
  password: YOUR_PASSWORD
```
 Ensure to create the coursesDb database before running this microservice. The initial data load information is in [import.sql](https://github.com/WilderVlz/Microservices-Architecture/blob/main/spring-microservices/microservice-course/src/main/resources/import.sql)

### MySQL

The MySQL configuration is in the file [msvc-student.yml](https://github.com/WilderVlz/Microservices-Architecture/blob/main/spring-microservices/microservice-config/src/main/resources/configurations/msvc-student.yml) 

```yaml
datasource:
  driver-class-name: com.mysql.cj.jdbc.Driver
  url: jdbc:mysql://localhost:3306/studentDb
  username: YOUR_USERNAME
  password: YOUR_PASSWORD
```
Before running this microservice, create the studentDb database. The initial data load is in [import.sql](https://github.com/WilderVlz/Microservices-Architecture/blob/main/spring-microservices/microservice-student/src/main/resources/import.sql)

## API Gateway
> The API Gateway will be running at the 8080 port.

## Microservices Deployment
### Ensure to follow the correct order when deploying the microservices:
This order ensures proper initialization and effective communication between the microservices.
1. **Configuration Microservice**
2. **Eureka Server**
3. **Courses (course) or Students (student) Microservice**: You can choose the order based on your needs.
4. **API Gateway**


## Important
-  #### Ensure to create the databases before running the microservices.
- #### The Eureka server must be running before executing the Courses or Students microservices.
- #### The databases will be automatically loaded with data specified in the import.sql files.
