FROM openjdk:8-jdk-alpine
ADD target/fournisseur-service.jar fournisseur-service.jar
EXPOSE 8020
ENTRYPOINT ["java" , "-jar" , "fournisseur-service.jar"]