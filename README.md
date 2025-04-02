# A Simple project of microservices with Spring Boot

## Description
This project contains two branches:
 - docker-compose-microservices
 - kubernetes-microservices

Each branch contains a simple instruction to run the application and urls to test the application.

# A Simple project of microservices with Spring Boot

## Description
This project contains two branches:
- docker-compose-microservices
- kubernetes-microservices

Each branch contains a simple instruction to run the application and urls to test the application.


### DOCKER-COMPOSE-MICROSERVICES

To run this project simply run the following command:
docker-compose up
Verify that you have docker and docker-compose installed and have required rights to run the command.


### Exchange Service
- [Exchange Service 1](http://localhost:8000/currency-exchange/from/USD/to/UAH)  
  _http://localhost:8000/currency-exchange/from/USD/to/UAH_

### Conversion Service
- [Conversion Service](http://localhost:8100/currency-exchange/from/USD/to/UAH/quantity/10.50)  
  _http://localhost:8100/currency-exchange/from/USD/to/UAH/quantity/10.50_

### Eureka
- [Eureka Dashboard](http://localhost:8761/)  
  _http://localhost:8761/_

### Gateway
- [currency-exchange](http://localhost:8765/currency-exchange/from/USD/to/UAH)  
  _http://localhost:8765/currency-exchange/from/USD/to/UAH_
- [currency-conversion](http://localhost:8765/currency-conversion/from/USD/to/UAH/quantity/10.50)  
  _http://localhost:8765/currency-conversion/from/USD/to/UAH/quantity/10.50_

### Zipkin
- [Zipkin](http://localhost:9411/)  
  _http://localhost:9411/_