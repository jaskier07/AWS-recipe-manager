package pl.kania.base.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ProductQuantityPK implements Serializable {

    private Long product;
    private Long recipe;

}
