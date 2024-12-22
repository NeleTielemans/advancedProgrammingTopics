package fact.it.personservice.controller;

import fact.it.personservice.dto.PersonRequest;
import fact.it.personservice.dto.PersonResponse;
import fact.it.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createPerson(@RequestBody PersonRequest personRequest) {
        personService.createPerson(personRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> getPersonById(@RequestParam List<String> id) {
        return personService.getPersonById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<PersonResponse> getAllPersons() {
        return personService.getAllPersons();
    }


}
