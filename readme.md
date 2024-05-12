# Final Project M320 - Francesco González

## Description

This project is a hotel reservation system developed using Java and Spring Boot.
I attached an H2 database to the project to store the data, located in the `databaseM320` folder.
The project is divided in three categories, Room, Customer and Controller, and these categories are subdivided three parts, The controller, the service and the repository:
- The controller is responsible for receiving the requests and sending them to the service.
- The service is responsible for processing the requests and sending them to the repository.
- The repository is responsible for accessing the database with queries and returning the data.

The repository is made with interfaces, witch are implemented in the repository folder with Jbdc.

I created the interface `Bookable`, witch permits a better usability of the code, maybe in a future for creating a new type of bookable, like apartments or houses.

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
- `PUT /customer/{id}`: Update a specific customer
### Reservation
- `POST /reservation`: Create a new reservation
- `GET /reservation`: Get all reservations
- `GET /reservation/{id}`: Get a specific reservation by its ID
- `GET /reservation/{id}/price`: Calculate the total price of a reservation
- `PUT /reservation/{id}`: Update a specific reservation
- `DELETE /reservation/{id}`: Delete a specific reservation
- `GET /reservation/availability`: Check the availability of a reservation