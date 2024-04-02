package models;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Address implements Comparable<Address> {
    @NonNull
    private String zipCode; //Поле не может быть null
    @NonNull
    private Location town; //Поле может быть null

    @Override
    public int compareTo(Address o) {
        return zipCode.compareToIgnoreCase(o.zipCode);
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Address address)) return false;
//        return zipCode.equals(address.zipCode) && town.equals(address.town);
//    }
//
//    @Override
//    public int hashCode() {
//        return hash(zipCode.hashCode(), town.hashCode());
//    }

//    @Override``
//    public String toString() {
//        return "Address{" +
//                "zipCode='" + zipCode + '\'' +
//                ", town=" + town +
//                '}';
//    }``
}
