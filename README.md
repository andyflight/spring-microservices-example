# A Simple project of microservices with Spring Boot

## Description
This project contains two branches:
 - docker-compose-microservices
 - kubernetes-microservices

Each branch contains a simple instruction to run the application and urls to test the application.

### KUBERNETES-MICROSERVICES

### Prerequisites

You need to have a Kubernetes cluster running. You can use Minikube or any other Kubernetes provider.
In this example I was using GCloud with Google Kubernetes Engine (GKE).

### How to run the application

To run this project you need to connect to your cluster and then run this commands from project root folder:
```bash
cd currency-exchange-service
kubectl apply -f deployment.yaml

cd ../currency-conversion-service
kubectl apply -f deployment.yaml
```

You will find the address with this comand:
```bash
kubectl get svc
```

### Enpoints

#### Exchange Service

- http://<address>:8000/currency-exchange/from/USD/to/EUR

#### Conversion Service

- http://<address>:8100/currency-conversion/from/USD/to/EUR/quantity/10

### Configurations

This project has a conf folder `k8s-configs` that have different version deployment.yaml.