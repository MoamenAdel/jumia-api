FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} jumia-api.jar
ENTRYPOINT [ "java","-jar","/jumia-api.jar" ]