# Getting Started

### prerequisite

* Java 16
* Docker

### Run the application

`mvn spring-boot:run`

### Fono API

Fono API is un availble at the moment. so used wiremock to simulate the api calls. Use the below command to run the wiremock container.

`docker run -it --rm -p 8080:8080 -v $PWD/mocks/stubs:/home/wiremock rodolpheche/wiremock`

### Testing

* Fetch all the phones
> curl -X GET "http://localhost:8081/phones" -H  "accept: */*"

* Book the phone

> curl -X PUT "http://localhost:8081/phones/1/book" -H  "accept: */*" -H  "Content-Type: application/json" -d "{\"name\":\"foo\"}"

* cancel the booking

> curl -X PUT "http://localhost:8081/phones/1/cancel" -H  "accept: */*"
