package pl.kania.database.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum AmountType {
    ITEM("item"),
    GRAM("gram"),
    ML("ml");

    private final String name;
}
