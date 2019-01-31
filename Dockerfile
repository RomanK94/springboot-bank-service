FROM openjdk:8-jdk-alpine

VOLUME /tmp

LABEL maintainer=rkuznetsov

EXPOSE 8080

ARG JAR_FILE=target/springboot-bank-service-1.0-SNAPSHOT.jar

ADD ${JAR_FILE} springboot-bank-service.jar

ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/springboot-bank-service.jar"]