FROM openjdk:21

EXPOSE 8081

ADD ./target/event-notificator-0.0.1-SNAPSHOT.jar /app/app.jar
ENTRYPOINT ["java", "-jar", "/app/app.jar"]