# Etapa 1: Build da aplicação Java com Maven
FROM maven:3.8.5-openjdk-17 AS build

WORKDIR /app

# Copia todo o projeto
COPY . .

# Executa o build da aplicação usando Maven
RUN mvn clean install

# Etapa 2: Criação do container final
FROM openjdk:17-jdk-slim

# Expor a porta da aplicação
EXPOSE 8080

# Definir variáveis de ambiente do banco de dados
ENV DATABASE_URL=jdbc:postgresql://localhost:5432/mindcare
ENV DATABASE_USER=admin
ENV DATABASE_PASSWORD=Lila349*

# Copia o JAR da aplicação gerado na etapa de build
COPY --from=build /app/target/mindcare-0.0.1-SNAPSHOT.jar app.jar

# Define o comando de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
