# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
#ENV JDBC_URL 127.0.0.1:3306
#ENV jdbc.url 127.0.0.1:3306
CMD ["./mvnw", "spring-boot:run"]
