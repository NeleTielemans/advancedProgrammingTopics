package fact.it.personservice.repository;

import fact.it.personservice.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
    List<Person> findById(List<String> ids);
}
