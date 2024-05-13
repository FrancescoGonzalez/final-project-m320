# Final Project M320 - Francesco González

## Description

This project is a hotel reservation system developed using Java and Spring Boot.
I attached an H2 database to the project to store the data, located in the `resources` folder.
The project is divided in three categories, Room, Customer and Controller, and these categories are subdivided three parts, The controller, the service and the repository:
- The controller is responsible for receiving the requests and sending them to the service.
- The service is responsible for processing the requests and sending them to the repository.
- The repository is responsible for accessing the database with queries and returning the data.

The repository is made with interfaces, witch are implemented in the repository folder with Jbdc.

I created the interface `Bookable`, witch permits a better usability of the code, maybe in a future for creating a new type of bookable, like apartments or houses.

For more usability with a Front-End, on every controller I added a `@CrossOrigin` annotation, to permit the access from a different origin.

The application runs on `localhost:8080` and if you like I created a frontend for this project, you can find it [here](https://github.com/FrancescoGonzalez/final-project-m320-webapp)

## Endpoints

The application has the following endpoints:

### Room
- `POST /room`: Create a new room
- `GET /room`: Get all rooms
- `GET /room/{id}`: Get a specific room by its ID
### Customer
- `POST /customer`: Create a new customer
- `GET /customer`: Get all customers
- `GET /customer/{id}`: Get a specific customer by its ID
### Reservation
- `POST /reservation`: Create a new reservation
- `GET /reservation`: Get all reservations
- `GET /reservation/{id}`: Get a specific reservation by its ID
- `GET /reservation/{id}/price`: Calculate the total price of a reservation
- `PUT /reservation/{id}`: Update a specific reservation
- `DELETE /reservation/{id}`: Delete a specific reservation
- `GET /reservation/availability`: Check the availability of a reservation

## Running the application

To run the application, you first need to do a n `mvn clean install` to download the dependencies and build the project.
Then, you can run the application with `mvn spring-boot:run`, or by starting the `Starter` class on your IDE.

## Author

This application was created by Francesco González (I2a-MI2) and sent on the 13th of May '24.