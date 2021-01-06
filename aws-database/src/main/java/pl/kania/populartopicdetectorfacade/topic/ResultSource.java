package pl.kania.populartopicdetectorfacade.topic;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class ResultSource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @Enumerated(value = EnumType.STRING)
    private SourceType type;

    @Column
    private LocalDateTime dateCreated;

    public ResultSource(SourceType type) {
        this.type = type;
    }

    @PrePersist
    private void beforePersist() {
        dateCreated = LocalDateTime.now();
    }
}
