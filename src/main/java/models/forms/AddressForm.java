package models.forms;

import manager.Console;
import models.Address;
import models.Location;

public class AddressForm extends Form<Address> {
    private final Console console;

    public AddressForm(Console console) {
        super(console);
        this.console = console;
    }

    @Override
    public Address build() {
        return new Address(
                askString("почтовый индекс", " (поле не может быть пустым)", s -> !s.isEmpty()),
                askLocation()
        );
    }

    private Location askLocation() {
        return new LocationForm(console).build();
    }
}
