# Etapa 1: Build da aplicação usando Maven
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copiar os arquivos do projeto para dentro do container
COPY pom.xml .
COPY src ./src

# Gerar o .jar da aplicação
RUN mvn clean package -DskipTests

# Etapa 2: Imagem final com apenas o jar
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copiar o jar gerado da etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Expor a porta que o Spring Boot usa
EXPOSE 8080

# Rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]