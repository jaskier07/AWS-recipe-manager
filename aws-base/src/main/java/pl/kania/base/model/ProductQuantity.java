package pl.kania.base.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@IdClass(ProductQuantityPK.class)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProductQuantity {

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_PRODUCT", referencedColumnName = "id")
    private Product product;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST})
    @JoinColumn(name = "ID_RECIPE", referencedColumnName = "id")
    private Recipe recipe;

    @Column(name = "AMOUNT")
    private double amount;

    @Column(name = "AMOUNT_TYPE")
    private AmountType amountType;

    public ProductQuantity(Product product, Recipe recipe, double amount, AmountType amountType) {
        this.product = product;
        this.recipe = recipe;
        this.amount = amount;
        this.amountType = amountType;
    }
}
