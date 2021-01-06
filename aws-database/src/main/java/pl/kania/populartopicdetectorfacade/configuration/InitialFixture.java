package pl.kania.populartopicdetectorfacade.configuration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import pl.kania.populartopicdetectorfacade.topic.QueryResult;
import pl.kania.populartopicdetectorfacade.topic.ResultSource;
import pl.kania.populartopicdetectorfacade.topic.SourceType;
import pl.kania.populartopicdetectorfacade.topic.dao.QueryResultRepository;
import pl.kania.populartopicdetectorfacade.topic.dao.ResultSourceRepository;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;

@Slf4j
@Service
public class InitialFixture {

    private final QueryResultRepository queryResultRepository;
    private final ResultSourceRepository resultSourceRepository;

    @Autowired
    public InitialFixture(QueryResultRepository queryResultRepository, ResultSourceRepository resultSourceRepository) {
        this.queryResultRepository = queryResultRepository;
        this.resultSourceRepository = resultSourceRepository;
        perform();
    }

    private void perform() {
        log.info("Performing initial fixture");

        ResultSource testSource = new ResultSource(SourceType.TEST);
        testSource = resultSourceRepository.save(testSource);

        LocalDateTime start = LocalDateTime.of(2020, 5, 25, 10, 0);
        QueryResult queryResult = new QueryResult();
        queryResult.setQueryStartDate(start);
        queryResult.setQueryEndDate(start.plusHours(1));
        queryResult.setSource(testSource);
        queryResult.setResult("testword1, testword2, testword3");
        queryResultRepository.save(queryResult);

        log.info("Initial fixture finished");
    }
}
