# Spring Kotlin REST API

[![License: MIT](https://img.shields.io/badge/License-MIT-blue.svg)](/LICENSE)
[![Build Status](https://travis-ci.org/mkdika/spring5-kotlin-api.svg?branch=master)](https://travis-ci.org/mkdika/spring5-kotlin-api)
[![codecov](https://codecov.io/gh/mkdika/spring5-kotlin-api/branch/master/graph/badge.svg)](https://codecov.io/gh/mkdika/spring5-kotlin-api)
[![codebeat badge](https://codebeat.co/badges/6d2b15f0-63b8-4a44-be7a-3a9c0e077040)](https://codebeat.co/projects/github-com-mkdika-spring5-kotlin-api-master)

Spring 5 Kotlin REST API demo with Spring Boot 2 stacks. This project is consist of CRUD Web endpoint. 

![Imgur](https://i.imgur.com/F1ySiaN.png)


## Tech Stack

- Java8 (JDK 8 update 171)
- [Kotlin 1.2.70](https://kotlinlang.org/)
- [Spring Boot 2.0.5](http://spring.io/projects/spring-boot)
- [Gradle 4.8.1](https://gradle.org/)
- [H2DB](http://www.h2database.com/html/main.html)
- [Undertow Web Server](http://undertow.io/)
- [Jacoco](https://www.eclemma.org/jacoco/)

## Build, Test & Run the Application

### Build

```console
gradlew clean build
```

Find the built result at `/build/libs/spring-kotlin-api-1.0.0.jar`

### Automatic Test

```console
# run all test
gradlew test

# run coverage test report
gradlew jacocoTestReport
```

Find the test result report at `/build/reports/test/` for __test__ result, and `/build/reports/jacoco` 
for __Jacoco__ coverage test result report.

### Run the Application

```console
gradlew bootRun
```

Access from local url: `http://localhost:8080`


### Test REST API Locally

Test the REST API locally with [Curl](https://curl.haxx.se/download.html) or alternatively 
you can use [Insomnia](https://insomnia.rest/) Web API Test, feel free to download my 
Insomnia Workspace at [Here](https://goo.gl/Ck8L2J) and import into yours.


### REST API Endpoints

| HTTP Method | Path               | Description                          |
| ----------- | ------------------ | ------------------------------------ |
| GET         | /api/customer      | Get all existing customer data.      |
| GET         | /api/customer/{id} | Get existing customer data by Id.    |
| POST        | /api/customer      | Insert new customer data.            |
| PUT         | /api/customer/{id} | update existing customer data by Id. |
| DELETE      | /api/customer/{id} | Delete existing customer data by Id. |


## Reference

- [Spring Boot and Kotlin](https://www.baeldung.com/spring-boot-kotlin)
- [Creating a RESTful Web Service with Spring Boot](https://kotlinlang.org/docs/tutorials/spring-boot-restful.html)
- [Building Restful APIs with Kotlin, Spring Boot, Mysql, JPA and Hibernate](https://www.callicoder.com/kotlin-spring-boot-mysql-jpa-hibernate-rest-api-tutorial/)
- [Creating and Testing a Kotlin RESTful Web Services using Spring Boot](https://medium.com/@crsandeep/creating-and-testing-a-kotlin-restful-web-services-using-spring-boot-1a11aeda279e)
- [More readable tests with Kotlin](https://www.tengio.com/blog/more-readable-tests-with-kotlin/)
- [Test coverage in Kotlin with Jacoco](https://kevcodez.de/index.php/2018/08/test-coverage-in-kotlin-with-jacoco/)
- [Codecov Kotlin Example](https://github.com/codecov/example-kotlin)

## Copyright and License

Copyright 2018 Maikel Chandika (mkdika@gmail.com). Code released under the
MIT License. See [LICENSE](/LICENSE) file.