package pl.kania.base.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.kania.base.model.dto.ProductDto;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NAME", length = 100)
    private String name;

    @Column(name = "DATE_CREATED")
    @Setter(AccessLevel.NONE)
    private LocalDateTime dateCreated;

    @PrePersist
    private void beforePersist() {
        dateCreated = LocalDateTime.now();
    }

    public Product(String name) {
        setName(name);
    }

    public void setName(String name) {
        this.name = name.toLowerCase();
    }

    public ProductDto dto() {
        return new ProductDto(id, name);
    }
}
