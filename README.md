# springBootHackathon
# Task allocation:

## WEEK 3 Hackathon

Feature 1 - Wong Xin Xian
* Implemented Spring Boot REST service that provides CRUD support for managing users- UserRestController.java
* User info includes: username, password, fullname - User.java
* Communicate with the MongoDB database to perform CRUD actions
* Included testing of UserRestController using TestRestTemplate - UserRestControllerTests.java

Feature 2 - Sim Li Jin (Hal)
* Implemented data-access code to query, insert, update, delete user info to a local MongoDB database (localhost:27017/test)
* Added data at the start of the application to populate the database
* List of methods that were implemented:
    * Create New User
    * Get All Users
    * Get User by Username
    * Get User by Full Name
    * Update User's info
    * Delete User
    
Feature 3 - Goh Chong Rui
* Implemented Spring Boot REST service that calls into back-end stock market API using RestTemplate
* Only registered users are allowed to use this service
* Rest controller file - FinancialRestController.java
* Base Url- Yahoo Finance, https://rapidapi.com/apidojo/api/yahoo-finance1
* Endpoints - /market/get-earnings,/market/get-popular-watchlist,/stock/v2/get-historicaldata,/stock/get-news,/news

## WEEK 4 Hackathon

Dockerfile & docker-compose - Zhou Nan
* Containerize the application and database through using Dockerfiles: Dockerfile-mongodb & Dockerfile-app which will building using .jar file
* Orchestrate the containers using docker-compose.yaml
* On labs.play-with-docker.com run "docker-compose up -d" with files Dockerfile-app, Dockerfile-mongodb, demo-0.0.1-SNAPSHOT.jar and docker-compose.yaml

Openshift - All
* Separated Dockerfiles into 2 different repositories
  * MongoDB: https://github.com/gohc0079/mymongodb
  * Application: https://github.com/gohc0079/SpringDockerRepo
* Application is able to run on OpenShift and accessed once the port for the application is exposed
