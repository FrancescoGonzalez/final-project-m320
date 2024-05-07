package org.gonzalez.finalprojectm320.model;

import java.time.LocalDate;


public record Customer(
    int id,
    String firstName,
    String lastName,
    LocalDate birthDate,
    String nationality
) {}
