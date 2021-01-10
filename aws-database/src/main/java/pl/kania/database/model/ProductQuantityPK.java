package pl.kania.database.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
public class ProductQuantityPK implements Serializable {

    private Long product;
    private Long recipe;

}
