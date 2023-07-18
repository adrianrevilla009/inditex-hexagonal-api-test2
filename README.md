# Hexagonal architecture microservice for duagon code test for inditex
==================================

### Adrian Revilla

[**Github**](https://github.com/adrianrevilla009)

[**Linkdn**](https://www.linkedin.com/in/adrian-revilla-8a4097130)

Project features
------------
------------
The chosen approach is to implement a hexagonal architecture to separate domain to
the other layers giving more abstraction to the code.

There are separated profiles to run them depending on desired environment.

There is a .github directory with PR and push triggers on develop and master. Besides that,
when master is triggered, sonarqube analysis is triggered and a docker image is generated and pushed to registry (for this, is required to
set credentials in github repository)

For accessing to swagger UI to check API documentation:

http://localhost:8080/inditex-api/swagger-ui/index.html

Git historic (.git) is maintained to check git flow management

Source code contains:
- API controller
- Bean configurator
- Domain, dtos, ports and services
- Infrastructure for persistence layer with entities and repositories
- Swagger documentation

Test code contains:
- Unit testing
- Integration testing
- API testing

A postman collection is included to reach api endpoints.

A dockerfile to containerize the java app.

Kubernetes manifest collection to run the app on a cluster.

Execution
------------
------------
1. To run it locally:

To package the app, just type:
```
mvn clear build
```
Then run the app:
```
java -jar target_directory/api-test-0.0.1-SNAPSHOT.jar
```
Then run any postman collection http request

2. To run it locally in a k8s cluster:

To package the app, just type:
```
mvn clear build
```

Then generate image and push it with docker to docker hub:
```
docker build -f multistage.Dockerfile -t adrian2606/inditex-hexagonal-api-test .
docker tag adrian2606/inditex-hexagonal-api-test:latest adrian2606/inditex-hexagonal-api-test:v1
docker push adrian2606/inditex-hexagonal-api-test:v1
```

Then init a local cluster (for example minikube), apply manifests and forward public exposed service:
```
minikube start --memory 6876 --cpus 4 --profile adrian --kubernetes-version v1.25.1
kubectl apply -f ./k8s/
kubectl -n dev port-forward svc/product 8080:8080
```
Then run any postman collection http request

Code quality
------------
------------
To analyze project and ensure some code quality a sonarqube server is configured with a docker container.
```
docker run -d --name sonarqube -p 9000:9000 sonarqube
```
Create a project by accessing to http://localhost:9000/ and generate a token

Then run in the project path:
```
sonar-scanner
```

