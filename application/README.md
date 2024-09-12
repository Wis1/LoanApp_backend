# Loan Calculator Application
The Loan Calculator Application is a simple RESTful API built using Spring Boot. It allows for loan calculations, managing clients and their loans, and fetching currency exchange rates.

## Technologies
* Java 11
* Spring Boot 2.5.9
* Gradle (build tool)
* MySQL Database 8.0.28
* JUnit 4.13.1
* RESTful API (for communication)
* Lombok 1.18.22

## Project Structure
The project consists of the following main controllers:

1. CalcApiController: Controller for handling loan calculations.

   * Endpoints:
     * GET /v1/calcApi/{amountLoan}/{loanLength} - Calculates loan installment based on loan amount and length.
     * GET /v1/calcApi/{calculateId} - Retrieves loan calculation from database based on ID.

2. CalculateController: Controller for managing loan operations.

   * Endpoints:
     * GET /v1/calculate - Retrieves all loan calculations.
     * GET /v1/calculate/onecalculate/{id} - Retrieves details of a single loan calculation based on ID.
     * GET /v1/calculate/{id} - Retrieves all calculations for a specific client based on client ID.
     * POST /v1/calculate/{clientId} - Adds a new loan calculation for a given client.
     * DELETE /v1/calculate/{calculateId} - Deletes a loan calculation based on ID.
     * PUT /v1/calculate - Updates an existing loan calculation.
     
3. ClientController: Controller for managing client operations.

    * Endpoints:
      * GET /v1/client - Retrieves all clients.
      * POST /v1/client - Adds a new client.
      * PUT /v1/client - Updates existing client data.
      * DELETE /v1/client/{clientId} - Deletes a client based on ID.
      
4. NBPController: Controller for fetching currency exchange rates from the National Bank of Poland (NBP).

   * Endpoints:
     * GET /v1/nbp/usd/{usd} - Retrieves the USD exchange rate.
     * GET /v1/nbp/eur/{eur} - Retrieves the EUR exchange rate.
     * GET /v1/nbp/chf/{chf} - Retrieves the CHF exchange rate.
     * GET /v1/nbp/information - Retrieves information about the main exchange rates.

## Configuration
The project uses MySQL as the database. You need to have MySQL Server installed locally or accessible remotely.

1. Make sure you have Java 11 installed.
2. Compile the project using Gradle: gradle clean build.
3. Configure MySQL database connection in application.properties:
arduino
````
spring.datasource.url=jdbc:mysql://localhost:3306/db_name
spring.datasource.username=db_username
spring.datasource.password=db_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
````
Replace db_name, db_username, and db_password with your MySQL database details.

## Running the Application
To run the application:

1. Open the project in IntelliJ IDEA.
2. Configure your MySQL database settings in application.properties as shown above.
3. Run the main application class (Application.java) as a Spring Boot application.
4. The application will be accessible at http://localhost:8080.

## Database
The application uses MySQL as the database. Ensure MySQL Server is running and the database schema is created according to the entity mappings.

## Additional Notes
The application supports various HTTP request methods (GET, POST, PUT, DELETE) for managing loan calculations, clients, and fetching currency exchange rates.
Uses @RestController annotations for creating RESTful controllers.
Cross-origin requests are enabled for the NBP controller (@CrossOrigin("*")) to allow access from different domains.