# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG TEST-ARG
COPY $JAR_FILE app.jar
ENV jdbc.host=$TEST-ARG
ENTRYPOINT ["java","-jar","/app.jar"]