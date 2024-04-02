package models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Max;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Coordinates {
    @NotNull
    @Max(30)
    private Double x; //Максимальное значение поля: 30, Поле не может быть null
    private float y;
}
