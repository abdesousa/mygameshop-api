# My Game Shop API
## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)


## General info
I created this api to demonstrate my abilities of software developer defining a single service following the best practices.

- Security: Sec



##### API's

| API                 | Description                                                              |
| ------------------- | ------------------------------------------------------------------------ |
| 'product'           | List all of the available product on the database                        |
| 'product\{id}'  | Get information about a product based on the product ID.                 |


## Technologies

* Spring Boot (Actuator, Security, JPA)
* H2 (In memory)
* JUnit
* Jackson Mapper
* oAuth32
* Docker
* Swagger

Github repository
```shell
https://github.com/abdesousa/paytrex-transaction-api.git
```

## Setup

To build locally this repository you should execute ats-aggregator POM in order to build all dependencies.

```shell
mvn clean install -P <profiles>
```


