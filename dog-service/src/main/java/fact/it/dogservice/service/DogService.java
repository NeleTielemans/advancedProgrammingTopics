package fact.it.dogservice.service;

import fact.it.dogservice.dto.DogRequest;
import fact.it.dogservice.dto.DogResponse;
import fact.it.dogservice.model.Dog;
import fact.it.dogservice.repository.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DogService {
    private final DogRepository dogRepository;

    public List<DogResponse> getAllDogs() {
        List<Dog> dogs = dogRepository.findAll();
        return dogs.stream().map(this::mapToDogResponse).toList();
    }

    public List<DogResponse> getDogById(List<String> ids) {
        List<Dog> dogs = dogRepository.findAllById(ids);
        return dogs.stream().map(this::mapToDogResponse).toList();
    }

    public void createDog(DogRequest dogRequest) {
        Dog dog = Dog.builder()
                .chipnr(dogRequest.getChipnr())
                .name(dogRequest.getName())
                .breed(dogRequest.getBreed())
                .gender(dogRequest.getGender())
                .ownerId(dogRequest.getOwnerId())
                .build();

        dogRepository.save(dog);
    }

    private DogResponse mapToDogResponse(Dog dogRequest) {
        return DogResponse.builder()
                .id(dogRequest.getId())
                .chipnr(dogRequest.getChipnr())
                .name(dogRequest.getName())
                .breed(dogRequest.getBreed())
                .gender(dogRequest.getGender())
                .ownerId(dogRequest.getOwnerId())
                .build();
    }
}
