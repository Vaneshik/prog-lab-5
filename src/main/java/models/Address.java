package models;

import static java.util.Objects.hash;

public class Address implements Comparable<Address>{
    private String zipCode; //Поле не может быть null
    private Location town; //Поле может быть null

    public Address(String zipCode, Location town) {
        this.zipCode = zipCode;
        this.town = town;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Location getTown() {
        return town;
    }

    public void setTown(Location town) {
        this.town = town;
    }

    @Override
    public int compareTo(Address o) {
        return zipCode.compareToIgnoreCase(o.zipCode);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return zipCode.equals(address.zipCode) && town.equals(address.town);
    }

    @Override
    public int hashCode() {
        return hash(zipCode.hashCode(), town.hashCode());
    }

    @Override
    public String toString() {
        return "Address{" +
                "zipCode='" + zipCode + '\'' +
                ", town=" + town +
                '}';
    }
}
