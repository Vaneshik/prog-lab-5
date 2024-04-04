package models.forms;

import manager.Console;
import models.Coordinates;

import java.util.Objects;

public class CoordinatesForm extends Form<Coordinates> {
    public CoordinatesForm(Console console) {
        super(console);
    }

    @Override
    public Coordinates build() {
        return new Coordinates(
                askDouble("координата x", " (поле не может быть пустым, максимальное значение = 30)", x -> x < 30),
                askFloat("координата y", "", x -> true)
        );
    }
}
