package org.gonzalez.finalprojectm320.model;

public interface Bookable {
  double calculateTotalPrice(int numberOfPeople, int days);
  double getPriceForPerson();
  int getMaxPeople();
}
