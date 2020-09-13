# springBootHackathon: Task Allocation

### Week 3 Hackathon

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


### Week 4 Hackathon

Project Lombok - Chong Rui and Xin Xian
* Made use of Project Lombok to implement logging and to simplify code using @Getter,@Setter and @ToString annotations
* used sl4j to log success (Status code) and error messages (Status code) of the respectuve endpoints onto the console 

Dockerfile & docker-compose - Zhou Nan and Li Jin (Hal)
* Containerize the application and database through using Dockerfiles: Dockerfile-mongodb & Dockerfile-app which will build using .jar file
* Orchestrate the containers using docker-compose.yaml
* On labs.play-with-docker.com run "docker-compose up -d" with files Dockerfile-app, Dockerfile-mongodb, demo-0.0.1-SNAPSHOT.jar and docker-compose.yaml
* Reduced the image size of mongodb and java with the use of alpine linux. However, we revert the mongodb to the normal as it doesn't work with Openshift.

Openshift - All
* Separated Dockerfiles into 2 different repositories
  * MongoDB: https://github.com/gohc0079/mymongodb
  * Application: https://github.com/gohc0079/SpringDockerRepo
* Application is able to run on OpenShift and accessed once the port for the application is exposed

AWS - All
* Spin up an EC2 instance and initialise the docker daemon inside the instance
  * Link to EC2 instance:http://15.206.202.111:8080/AllUsers
  * Not an effective solution in the long run if the application would require to scale up, in terms of cost and effort placed
* Alternatively, there are other features that are available in AWS that can be used but was not done due to time constraint and requiring spending of money
  * An EC2 instance with Jenkins pipeline configure such that it will make the necessary changes based on a commit from the git repo
  * Hosting the Spring Boot on to AWS Elastic Container Service, which acts as a standalone application
     * Alternatively, another possibility would be to use AWS lambda services and expose the response url
  * Hosting the Mongo DB on to AWS Dynamo DB, as it supports NoSQL database
