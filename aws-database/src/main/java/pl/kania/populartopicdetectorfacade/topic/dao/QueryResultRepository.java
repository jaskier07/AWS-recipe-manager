package pl.kania.populartopicdetectorfacade.topic.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.kania.populartopicdetectorfacade.topic.QueryResult;

@Repository
public interface QueryResultRepository extends JpaRepository<QueryResult, Long> {
}
