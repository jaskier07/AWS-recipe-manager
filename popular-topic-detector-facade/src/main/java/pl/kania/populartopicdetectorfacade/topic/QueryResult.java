package pl.kania.populartopicdetectorfacade.topic;

import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class QueryResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Result cannot be blank")
    @Column(length = 100)
    private String result;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_SOURCE")
    private ResultSource source;

    @Column
    private LocalDateTime queryStartDate;

    @Column
    private LocalDateTime queryEndDate;

    @Column
    private LocalDateTime dateCreated;

    @PrePersist
    public void beforePersist() {
        dateCreated = LocalDateTime.now();
    }
}
