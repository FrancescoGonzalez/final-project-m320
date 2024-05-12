# Final Project M320

## Description

This project is a hotel reservation system developed using Java, Spring Boot.
I attached an H2 database to the project to store the data, located in the `databaseM320` folder.

## Usage

The application has the following endpoints:

- `POST /room`: Create a new room
- `GET /room`: Get all rooms
- `GET /room/{id}`: Get a specific room by its ID
- `POST /reservation`: Create a new reservation
- `GET /reservation`: Get all reservations
- `GET /reservation/{id}`: Get a specific reservation by its ID
- `GET /reservation/{id}/price`: Calculate the total price of a reservation
- `PUT /reservation/{id}`: Update a specific reservation
- `DELETE /reservation/{id}`: Delete a specific reservation