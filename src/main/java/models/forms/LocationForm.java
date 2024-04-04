package models.forms;

import manager.Console;
import models.Location;

import java.util.Objects;

public class LocationForm extends Form<Location>{
    public LocationForm(Console console) {
        super(console);
    }

    @Override
    public Location build() {
        return new Location(
                askLong("координата x", " (поле не может быть пустым)", Objects::nonNull),
                askDouble("координата y", " (поле не может быть пустым)", Objects::nonNull),
                askString("название локации", " (поле не может быть пустым)", s -> !s.isEmpty())
        );
    }
}
