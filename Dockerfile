# syntax=docker/dockerfile:1

FROM openjdk:8-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
ARG ARG_DB_HOST
ARG ARG_DB_USERNAME
ARG ARG_DB_PASSWORD
COPY $JAR_FILE app.jar
ENV DB_HOST=$ARG_DB_HOST
ENV DB_USERNAME=$ARG_DB_USERNAME
ENV DB_PASSWORD=$ARG_DB_PASSWORD
ENTRYPOINT ["java","-jar","/app.jar"]

# ARG : use to set variable in build time
# ENV: environment of app, pass in build time or run time
