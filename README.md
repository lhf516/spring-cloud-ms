# spring-cloud-ms

## Versions of Tools in use
- **JDK**: `17`
- **Spring Boot**: `3.3.4`
- **Spring Cloud**: `2023.0.3`

## Tasks
- [x] Add Simple Provider - User
- [x] Add Simple Consumer - Movie
- [x] Add Provider - User
- [x] Add Consumer - Movie
- [x] Add Eureka Server
- [x] Add Eureka Server with High availability
- [x] Add Eureka Server with Authentication
- [x] Add User and Movie to handle metadata
- [x] Add XML to register and unregister microservices
  - [x] Register
    - `cat ./rest-api-test.xml | curl -v -X POST -H "Content-type: application/xml" -d @- http://localhost:8761/eureka/apps/rest-api-test`
  - [x] Unregister
    - `curl -v -X DELETE http://localhost:8761/eureka/apps/rest-api-test/itmuch:rest-api-test:9000`
- [x] Enable healthcheck to Eureka Server
- [x] Add sample of remove Jersey
- [x] Add ribbon to movie
- [ ] 