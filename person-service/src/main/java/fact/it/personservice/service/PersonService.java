package fact.it.personservice.service;

import fact.it.personservice.dto.PersonRequest;
import fact.it.personservice.dto.PersonResponse;
import fact.it.personservice.model.Person;
import fact.it.personservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonService {
    private final PersonRepository personRepository;

    public List<PersonResponse> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return persons.stream().map(this::mapToPersonResponse).toList();
    }

    public List<PersonResponse> getPersonById(List<String> ids) {
        List<Person> persons = personRepository.findAllById(ids);
        return persons.stream().map(this::mapToPersonResponse).toList();
    }

    public void createPerson(PersonRequest personRequest) {
        Person person = Person.builder()
                .firstName(personRequest.getFirstName())
                .lastName(personRequest.getLastName())
                .email(personRequest.getEmail())
                .build();

        personRepository.save(person);
    }

    private PersonResponse mapToPersonResponse(Person person) {
        return PersonResponse.builder()
                .id(person.getId())
                .firstName(person.getFirstName())
                .lastName(person.getLastName())
                .email(person.getEmail())
                .build();
    }

}
