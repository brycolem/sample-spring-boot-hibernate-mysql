FROM eclipse-temurin:17-jdk-alpine

EXPOSE 8080

CMD ["java", "-jar", "myapp-all.jar"]

WORKDIR /app
COPY build/libs/demo-0.0.1-SNAPSHOT.jar /app/myapp-all.jar
