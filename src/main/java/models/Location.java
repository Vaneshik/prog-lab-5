package models;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class Location {
    @NotNull
    private Long x; //Поле не может быть null
    @NotNull
    private Double y; //Поле не может быть null
    @NotNull
    @NotBlank
    private String name; //Строка не может быть пустой, Поле может быть null
}
