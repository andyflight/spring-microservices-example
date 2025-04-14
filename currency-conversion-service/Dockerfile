# Build stage
FROM maven:3.9.9-amazoncorretto-21-alpine AS build
WORKDIR /home/app

# Basic dependencies compiling
COPY ./pom.xml /home/app/pom.xml
COPY ./src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java /home/app/src/main/java/com/in28minutes/microservices/currencyconversionservice/CurrencyConversionServiceApplication.java
RUN mvn -f /home/app/pom.xml clean package

# Compile on change
COPY . /home/app
RUN mvn -f /home/app/pom.xml clean package

# Run stage
FROM azul/zulu-openjdk-alpine:21-jre-latest
EXPOSE 8100

COPY --from=build /home/app/target/*.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /app.jar"]