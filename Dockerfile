# Usar uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim as builder

# Definindo o diretório de trabalho
WORKDIR /app

# Copiando o arquivo pom.xml para resolver as dependências
COPY pom.xml ./
COPY .mvn .mvn
COPY mvnw ./

# Baixando as dependências do Maven sem compilar
RUN ./mvnw dependency:go-offline -B

# Copiando o diretório src para a imagem
COPY src ./src

# Compilando a aplicação, ignorando os testes para acelerar o processo
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Usar uma nova imagem base do OpenJDK 17 para executar a aplicação
FROM openjdk:17-jdk-slim

# Definindo o diretório de trabalho na nova imagem
WORKDIR /app

# Copiando o jar da aplicação da fase de build
COPY --from=builder /app/target/mindcare-0.0.1-SNAPSHOT.jar app.jar

# Definindo variáveis de ambiente para opções do Java
ENV JAVA_OPTS=""

# Expondo a porta 8080 para acesso externo
EXPOSE 8080

# Comando de entrada para executar a aplicação
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
