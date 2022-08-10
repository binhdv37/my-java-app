# syntax=docker/dockerfile:1

FROM eclipse-temurin:17-jdk-jammy
ARG TEST-ARG
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:resolve
COPY src ./src
#ENV JDBC_URL 127.0.0.1:3306
#ENV jdbc.url 127.0.0.1:3306
ENV test=$TEST-ARG
CMD ["./mvnw", "spring-boot:run"]

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG TEST-ARG
COPY ${JAR_FILE} app.jar
ENV test=$TEST-ARG
ENTRYPOINT ["java","-jar","/app.jar"]