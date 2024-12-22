package fact.it.dogservice.repository;

import fact.it.dogservice.model.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface DogRepository extends MongoRepository<Dog, String> {
    List<Dog> findById(List<String> ids);
}