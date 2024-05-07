package org.gonzalez.finalprojectm320.model;

public record Room(
    int id,
    int number,
    String type,
    int maxPeople,
    double priceForPerson
) implements Bookable{

  @Override
  public double calculateTotalPrice(int numberOfPeople, int days) {
    return priceForPerson * (double) (numberOfPeople * days);
  }

  @Override
  public double getPriceForPerson() {
    return priceForPerson;
  }

  @Override
  public int getMaxPeople() {
    return maxPeople;
  }
}