package org.gonzalez.finalprojectm320.model;

public class Customer {
    private String name;
    private String surname;
    private int birthYear;
    private String nationality;

    public Customer(String name, String surname, int birthYear, String nationality) {
        this.name = name;
        this.surname = surname;
        this.birthYear = birthYear;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getNationality() {
        return nationality;
    }
}
