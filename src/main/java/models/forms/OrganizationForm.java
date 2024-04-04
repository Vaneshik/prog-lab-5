package models.forms;

import manager.Console;
import manager.IdManager;
import models.Address;
import models.Coordinates;
import models.Organization;
import models.OrganizationType;

import java.time.LocalDateTime;
import java.util.Date;

public class OrganizationForm extends Form<Organization> {
    private final Console console;

    public OrganizationForm(Console console) {
        super(console);
        this.console = console;
    }

    @Override
    public Organization build() {
        return new Organization(
                IdManager.generateId(),
                askString("название организации", " (поле не может быть пустым)", s -> !s.isEmpty()),
                askCoordinates(),
                new Date(),
                askDouble("годовой оборот", " (поле не может быть пустым, значение должно быть больше нуля)", x -> x > 0),
                askString("полное название организации", " (поле не может быть пустым)", s -> !s.isEmpty()),
                askInteger("количество сотрудников", " (поле не может быть пустым, значение должно быть больше нуля)", x -> x > 0),
                askOrganizationType(),
                askAddress()
        );
    }

    private Coordinates askCoordinates() {
        return new CoordinatesForm(console).build();
    }

    private Address askAddress() {
        return new AddressForm(console).build();
    }

    private OrganizationType askOrganizationType() {
        return (OrganizationType) askEnum("тип организации", OrganizationType.values(), s -> true);
    }
}
