package pl.kania.populartopicdetectorfacade.topic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kania.populartopicdetectorfacade.topic.ResultSource;

@Repository
public interface ResultSourceRepository extends JpaRepository<ResultSource, Long> {
}
