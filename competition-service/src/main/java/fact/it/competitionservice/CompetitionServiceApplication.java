package fact.it.competitionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;

@SpringBootApplication
public class CompetitionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompetitionServiceApplication.class, args);
    }

}
