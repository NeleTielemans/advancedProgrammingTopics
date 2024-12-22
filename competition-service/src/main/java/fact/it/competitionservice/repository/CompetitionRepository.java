package fact.it.competitionservice.repository;

import fact.it.competitionservice.model.Competition;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CompetitionRepository extends MongoRepository<Competition, String> {
    List<Competition> findById(List<String> ids);
}
