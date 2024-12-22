package fact.it.personservice;

import fact.it.personservice.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
public class PersonServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonServiceApplication.class, args);
	}

}
