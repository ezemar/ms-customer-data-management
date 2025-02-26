# Use uma imagem base do OpenJDK
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho no container
WORKDIR /app

# Copie o JAR do microserviço para o container
COPY target/ms-customer-data-management-*.jar ms-customer-data-management.jar

# Exponha a porta configurada no application.yaml
EXPOSE 8899

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "ms-customer-data-management.jar"]
