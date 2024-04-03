package models;


import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import manager.IdManager;
import org.hibernate.validator.constraints.UniqueElements;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Comparator;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class Organization implements Comparable<Organization> {
    @Min(1)
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @NotNull
    @NotBlank
    private String name; //Поле не может быть null, Строка не может быть пустой
    @NotNull
    private Coordinates coordinates; //Поле не может быть null
    @NotNull
    private java.util.Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @DecimalMin(value = "0.01")
    private double annualTurnover; //Значение поля должно быть больше 0
    @NotNull
    @NotBlank
    private String fullName; //Строка не может быть пустой, Поле не может быть null
    @NotNull
    @Min(1)
    private Integer employeesCount; //Поле не может быть null, Значение поля должно быть больше 0
    @NotNull
    private OrganizationType type; //Поле может быть null
    @NotNull
    private Address postalAddress; //Поле не может быть null

//    public Organization(String name, Coordinates coordinates, double annualTurnover, String fullName, Integer employeesCount, OrganizationType type, Address postalAddress) {
//        this.id = IdManager.generateId();
//        this.name = name;
//        this.coordinates = coordinates;
//        this.annualTurnover = annualTurnover;
//        this.fullName = fullName;
//        this.employeesCount = employeesCount;
//        this.type = type;
//        this.postalAddress = postalAddress;
//    }

    @Override
    public int compareTo(Organization other) {
        return Comparator.comparingDouble(Organization::getAnnualTurnover)
                .thenComparing(Organization::getEmployeesCount)
                .thenComparingLong(Organization::getId)
                .compare(this, other);
    }

//    @Override
//    public String toString() {
//        return "Organization{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", coordinates=" + coordinates +
//                ", creationDate=" + creationDate +
//                ", annualTurnover=" + annualTurnover +
//                ", fullName='" + fullName + '\'' +
//                ", employeesCount=" + employeesCount +
//                ", type=" + type +
//                ", postalAddress=" + postalAddress +
//                '}';
//    }
}