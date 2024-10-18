# Estágio de build
FROM maven:3.8.5-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Executa o Maven para construir o projeto
RUN mvn clean install

# Estágio final
FROM openjdk:17-jdk-slim

# Expõe a porta 8080
EXPOSE 8080

# Copia o jar do estágio de build
COPY --from=build /app/target/mindcare-0.0.1-SNAPSHOT.jar app.jar

# Define o ponto de entrada
ENTRYPOINT ["java", "-jar", "app.jar"]
