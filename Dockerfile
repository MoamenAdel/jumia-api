FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar

#DB stage
FROM ubuntu:trusty
RUN sudo apt-get -y update
RUN sudo apt-get -y upgrade
RUN sudo apt-get install -y sqlite3 libsqlite3-dev
RUN mkdir /db
RUN /usr/bin/sqlite3 /db/sqlitesample.db
CMD /bin/bash

COPY ${JAR_FILE} jumia-api.jar
ENTRYPOINT [ "java","-jar","/jumia-api.jar" ]