package models.forms;

import manager.ConsoleManager;
import models.Coordinates;

/**
 * Форма для создания объекта класса {@link Coordinates}.
 */
public class CoordinatesForm extends Form<Coordinates> {
    public CoordinatesForm(ConsoleManager console) {
        super(console);
    }

    /**
     * Формирует объект класса {@link Coordinates}.
     *
     * @return Объект класса {@link Coordinates}
     */
    @Override
    public Coordinates build() {
        return new Coordinates(
                askDouble("координата x", " (поле не может быть пустым, максимальное значение = 30)", x -> x <= 30),
                askFloat("координата y", "", x -> true)
        );
    }
}
