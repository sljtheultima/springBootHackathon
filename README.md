# springBootHackathon
Task allocation:

Feature 1 - Wong Xin Xian
* Implemented Spring Boot REST service that provide CRUD support
* Communicate with the database to perform CRUD actions

Feature 2 - Sim Li Jin (Hal)
* Implemented data-access code to query, insert, update, delete user info to a local MongoDB database (localhost:27017/test)
* Added data at the start of the application to populate the database
* List of methods that been implemented:
    * Create New User
    * Get All Users
    * Get User by Username
    * Get User by Full Name
    * Update User's info
    * Delete User
    
Feature 3 - Goh Chong Rui
* Implemented Spring Boot REST service that calls into back-end stock market API using RestTemplate
* Only registerd users are allowed to use this service
* Rest controller file - FinancialRestController.java
* Base Url- Yahoo Finance, https://rapidapi.com/apidojo/api/yahoo-finance1
* Endpoints - /market/get-earnings,/market/get-popular-watchlist,/stock/v2/get-historicaldata,/stock/get-news,/news
           
