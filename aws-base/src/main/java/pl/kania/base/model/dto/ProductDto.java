package pl.kania.base.model.dto;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;

@NoArgsConstructor(force = true)
@AllArgsConstructor
@Value
public class ProductDto {
    Long id;
    String name;
}
