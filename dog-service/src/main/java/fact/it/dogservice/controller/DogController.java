package fact.it.dogservice.controller;

import fact.it.dogservice.dto.DogRequest;
import fact.it.dogservice.dto.DogResponse;
import fact.it.dogservice.service.DogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dog")
@RequiredArgsConstructor
public class DogController {

    private final DogService dogService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createDog(@RequestBody DogRequest dogRequest) {
        dogService.createDog(dogRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<DogResponse> getDogById(@RequestParam List<String> id) {
        return dogService.getDogById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<DogResponse> getAllDogs() {
        return dogService.getAllDogs();
    }


}

