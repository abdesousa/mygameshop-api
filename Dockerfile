FROM java:8
MAINTAINER abdesousa@gmail.com
VOLUME /tmp
ADD mygameshop-api-0.0.1.jar mygameshop-api.jar
RUN bash -c 'touch /mygameshop-api.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/mygameshop-api.jar"]