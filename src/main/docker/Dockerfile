FROM openjdk:8
MAINTAINER abdesousa@gmail.com
ADD target/mygameshop-api-0.0.1-SNAPSHOT.jar mygameshop-api.jar
EXPOSE 8090
ENTRYPOINT ["java","-jar","mygameshop-api.jar"]


#FROM openjdk:8-jdk-alpine
#MAINTAINER abdesousa@gmail.coms
#VOLUME /tmp
#ARG JAR_FILE
#COPY ${JAR_FILE} mygameshop-api.jar
#EXPOSE 8090
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mygameshop-api.jar"]