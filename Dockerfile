FROM openjdk:19-jdk-alpine

WORKDIR /app/spring-security-sandbox

RUN rm -rf /app/spring-security-sandbox/*

COPY ./target/spring-security-sandbox-0.0.1-SNAPSHOT.jar /app/spring-security-sandbox/spring-security-sandbox.jar

EXPOSE 8080

CMD ["java","-jar","/app/spring-security-sandbox/spring-security-sandbox.jar"]