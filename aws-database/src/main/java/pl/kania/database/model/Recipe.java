package pl.kania.database.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = "Result cannot be blank")
    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH }, mappedBy = "recipe")
    private Set<ProductQuantity> products = new HashSet<>();

    @Column(name = "DATE_CREATED", nullable = false)
    @Setter(AccessLevel.NONE)
    private LocalDateTime dateCreated;

    @PrePersist
    public void beforePersist() {
        dateCreated = LocalDateTime.now();
    }

    public Recipe(String name) {
        this.name = name;
    }
}
