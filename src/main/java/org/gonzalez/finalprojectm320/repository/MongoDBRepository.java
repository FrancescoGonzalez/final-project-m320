package org.gonzalez.finalprojectm320.repository;

import com.mongodb.client.*;
import org.bson.Document;
import org.gonzalez.finalprojectm320.model.Customer;
import org.gonzalez.finalprojectm320.model.Reservation;
import org.gonzalez.finalprojectm320.model.Room;

import java.util.ArrayList;
import java.util.List;

public class MongoDBRepository implements RepositoryInterface{
    private MongoCollection<Document> rooms;
    private MongoCollection<Document> customers;
    private MongoCollection<Document> reservations;

    public MongoDBRepository() {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("Hotel");

        this.rooms = db.getCollection("Room");
        this.customers = db.getCollection("Customer");
        this.reservations = db.getCollection("Reservation");
    }

    public void createCustomer(Customer c) {
        Document document = new Document();
        document.put("id", c.getId());
        document.put("name", c.getName());
        document.put("surname", c.getSurname());
        document.put("birth-year", c.getBirthYear());
        document.put("nationality", c.getNationality());
        customers.insertOne(document);
    }

    @Override
    public void createRoom(Room r) {
        Document document = new Document();
        document.put("number", r.getNumber());
        document.put("max-people", r.getMaxPeople());
        document.put("price-for-person", r.getPriceForPerson());
        rooms.insertOne(document);
    }

    @Override
    public void createReservation(Reservation r) {
        Document document = new Document();
        document.put("reservation-number", r.getReservationNumber());
        document.put("customer", r.getCustomerId());
        document.put("number-of-people", r.getNumberOfPeople());
        document.put("room-number", r.getRoomNumber());
        document.put("begin-date", r.getBeginDate());
        document.put("end-date", r.getEndDate());
        reservations.insertOne(document);
    }

    @Override
    public List<Customer> getCustomers() {
        List<Customer> res = new ArrayList<>();
        for (Document d : customers.find()) {
            res.add(new Customer(
                    d.getString("id"),
                    d.getString("name"),
                    d.getString("surname"),
                    d.getInteger("birth-year"),
                    d.getString("nationality")
            ));
        }
        return res;
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> res = new ArrayList<>();
        for (Document d : reservations.find()) {
            res.add(new Reservation(
                    d.getInteger("reservation-number"),
                    d.getString("customer"),
                    d.getInteger("number-of-people"),
                    d.getInteger("room-number"),
                    d.getString("begin-date"),
                    d.getString("end-date")
            ));
        }
        return res;
    }

    @Override
    public Reservation getReservation(int id) {
        return null;
    }

    @Override
    public void updateReservation(int id, Reservation newReservation) {

    }

}
