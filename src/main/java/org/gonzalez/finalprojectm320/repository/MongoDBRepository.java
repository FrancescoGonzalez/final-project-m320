package org.gonzalez.finalprojectm320.repository;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.gonzalez.finalprojectm320.model.Customer;

public class MongoDBRepository {

    private final MongoDatabase db;
    private MongoCollection<Document> rooms;
    private MongoCollection<Document> customers;
    private MongoCollection<Document> reservations;

    public MongoDBRepository() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        this.db = mongoClient.getDatabase("Hotel");

        this.rooms = this.db.getCollection("Room");
        this.customers = this.db.getCollection("Customer");
        this.reservations = this.db.getCollection("Reservation");
    }

    public void createCustomer(Customer c) {
        Document document = new Document();
        document.put("name", c.getName());
        document.put("surname", c.getSurname());
        document.put("birth-year", c.getBirthYear());
        document.put("nationality", c.getNationality());
        customers.insertOne(document);
    }

}
