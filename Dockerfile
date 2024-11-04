
FROM openjdk:17-jdk-slim as builder


WORKDIR /app


COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./


RUN ./mvnw dependency:go-offline -B


COPY src ./src


RUN chmod +x mvnw && ./mvnw clean package -DskipTests


FROM openjdk:17-jdk-slim


WORKDIR /app


COPY --from=builder /app/target/mindcare-0.0.1-SNAPSHOT.jar app.jar


ENV JAVA_OPTS=""


EXPOSE 8080


ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
