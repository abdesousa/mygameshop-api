# My Game Shop API
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)


## General info
I created this api to demonstrate my abilities as software developer defining a single service following the best practices.

## Technologies

* Spring Boot (Actuator, Security, JPA)
* H2 (In memory)
* JUnit
* Flyway
* Jackson Mapper
* Basic Authentication
* Docker
* Swagger2

## Decisions Made:
* Security: Basic Authentication on the data in transit in order to ensure a reliable communication to the single test application. Think about the use of oAuth2 instead of basic authentication for 
solution which requires a high level of security.  
* Spring boot: Once I have a large background with java Springboot was the natural choose. With Spring is possible to create robust apis in few lines of code.
* H2: The best solution to integrate natively with spring-data.
* Flyway: To create the database as a code using the migrations 
* JUNIT: All of the unit tests were created using junit and Mockito.
* One single project: Once this is a small test to evaluate my skills I have invlude everything in one single project. It is recommended to split on small project in order to be possible increase the individual scalability. 
* Swagger 2: One of the most used framework to document apis.
* Lack Integration tests: Once it is possible to test the api through Swagger Integration tests weren't created.
* Commons exceptions instead of custom: It is a best practice that I try to follow everytime. 
* 

## API's
* product/: List all available products 
* product/{id}: Get information about a product based on the product ID.




## Github repository
```shell
https://github.com/abdesousa/paytrex-transaction-api.git
```









## How to build this project

To build locally this repository you should execute ats-aggregator POM in order to build all dependencies.

```shell
mvn clean install -P <profiles>
```


