# Baixando a imagem base
FROM maven:3.8.6-eclipse-temurin-17-alpine AS builder

# Setando diretório de trabalho no contêiner
WORKDIR /app

# Copiando o arquivo pom.xml para o contêiner
COPY pom.xml ./

# Copiando o diretório .mvn para o contêiner
COPY .mvn .mvn

# Copiando o arquivo mvnw para o contêiner
COPY mvnw ./

# Dando permissão de execução ao script mvnw
RUN chmod +x ./mvnw

# Baixando as dependências do Maven sem compilar
RUN ./mvnw dependency:go-offline -B

# Copiando o diretório src para o contêiner
COPY src ./src

# Executando a compilação do projeto
RUN ./mvnw clean package -DskipTests

# Comando de entrada
CMD ["java", "-jar", "target/mindcare-0.0.1-SNAPSHOT.jar"]
