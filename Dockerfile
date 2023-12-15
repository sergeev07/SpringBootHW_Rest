FROM openjdk:19-jdk-alpine

LABEL authors="aleksadr"

EXPOSE 7777
ADD build/libs/SpringBoot_REST-0.0.1-SNAPSHOT.jar rest_app.jar
ENTRYPOINT ["java","-jar","rest_app.jar"]