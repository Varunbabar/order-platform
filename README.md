@'
# Order Platform

A backend for an online store, split into small services instead of one big application.

When someone places an order, the order service saves it and sends out a message saying "a new order was placed". The notification service picks up that message and tells the customer. The services never call each other's code directly, they only pass messages, so each one can be built, changed and run on its own.

## The services

- **user-service**: handles signup and login
- **product-service**: keeps the list of products and how many are in stock
- **order-service**: creates orders and sends the "order placed" message
- **notification-service**: listens for that message and sends the notification
- **api-gateway**: the one address the outside world talks to, which passes requests on to the right service

## Built with

Java and Spring Boot for most services, Node.js for notifications, MongoDB for storage, RabbitMQ for the messages, and Docker to run everything.

## Status

Just getting started. The project structure is in place and user-service is next. This section will be updated as each part starts working.

## Running it

Not ready yet. Once it is, the goal is a single command that starts all the services together.
'@ | Set-Content -Encoding ascii README.md
