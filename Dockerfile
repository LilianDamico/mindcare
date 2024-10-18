# Etapa de build
FROM maven:3.8.5-openjdk-17 AS build

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo pom.xml e baixa as dependências
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copia o restante do código fonte
COPY src ./src

# Compila o projeto e gera o arquivo .jar
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Define o diretório de trabalho para o container final
WORKDIR /app

# Expõe a porta que a aplicação usará
EXPOSE 8080

# Copia o arquivo .jar gerado no estágio de build anterior
COPY --from=build /app/target/mindcare-0.0.1-SNAPSHOT.jar app.jar

# Comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
