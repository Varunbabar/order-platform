# Order Platform

A microservices-based order management backend, built step by step to learn and demonstrate Java, Spring Boot, Node.js, MongoDB, RabbitMQ and Docker.

## Planned Architecture

| Service | Tech | Purpose |
|---|---|---|
| api-gateway | Spring Cloud Gateway | Single entry point, routing, JWT check |
| user-service | Spring Boot + MongoDB | Registration, login, JWT |
| product-service | Spring Boot + MongoDB | Product catalog and stock |
| order-service | Spring Boot + MongoDB | Places orders, publishes events |
| notification-service | Node.js | Consumes order events, sends notifications |
| RabbitMQ | Message broker | Event communication between services |

Everything will run with Docker Compose.

## Roadmap

- [x] Phase 0: repository setup and project structure
- [ ] Phase 1: Docker basics, MongoDB in a container
- [ ] Phase 2: user-service, Dockerized
- [ ] Phase 3: Docker Compose and product-service
- [ ] Phase 4: REST communication between services
- [ ] Phase 5: order-service and RabbitMQ events
- [ ] Phase 6: Node.js notification-service
- [ ] Phase 7: API Gateway and JWT security
- [ ] Phase 8: CI with GitHub Actions, architecture diagram

## How to run

Coming soon.

## Author

Varun Babar - https://github.com/Varunbabar
