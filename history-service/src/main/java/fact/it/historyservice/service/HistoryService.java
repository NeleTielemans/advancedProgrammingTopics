package fact.it.historyservice.service;

import fact.it.historyservice.dto.*;
import fact.it.historyservice.model.History;
import fact.it.historyservice.repository.HistoryRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final WebClient webClient;

    @Value("${personservice.baseurl}")
    private String personServiceBaseUrl;
    @Value("${dogservice.baseurl}")
    private String dogServiceBaseUrl;
    @Value("${competitionservice.baseurl}")
    private String competitionServiceBaseUrl;

    public String createNewHistory(HistoryRequest historyRequest) {

        PersonResponse[] personResponseArray = webClient.get()
                .uri("http://" + personServiceBaseUrl + "/api/person",
                        uriBuilder -> uriBuilder.queryParam("id", historyRequest.getPersonId()).build())
                .retrieve()
                .bodyToMono(PersonResponse[].class)
                .block();
        if (personResponseArray == null || personResponseArray.length == 0) {
            return "Person not found";
        }

        DogResponse[] dogResponseArray = webClient.get()
                .uri("http://" + dogServiceBaseUrl + "/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("id", historyRequest.getDogId()).build())
                .retrieve()
                .bodyToMono(DogResponse[].class)
                .block();
        if (dogResponseArray == null || dogResponseArray.length == 0) {
            return "Dog not found";
        }

        CompetitionResponse[] competitionResponses = webClient.get()
                .uri("http://" + competitionServiceBaseUrl + "/api/inventory",
                        uriBuilder -> uriBuilder.queryParam("id", historyRequest.getCompetitionId()).build())
                .retrieve()
                .bodyToMono(CompetitionResponse[].class)
                .block();
        if (competitionResponses == null || competitionResponses.length == 0) {
            return "Competition not found";
        }



        History history = History.builder()
                .competitionId(historyRequest.getCompetitionId())
                .program(historyRequest.getProgram())
                .personId(historyRequest.getPersonId())
                .dogId(historyRequest.getDogId())
                .score(historyRequest.getScore())
                .build();
        historyRepository.save(history);
        return "History created succesfully";

    }

    public List<HistoryResponse> getAllHistories() {
        List<History> histories = historyRepository.findAll();

        return histories.stream()
                .map(this::mapToHistoryResponse)
                .collect(Collectors.toList());
    }

    private HistoryResponse mapToHistoryResponse(History history) {
        return HistoryResponse.builder()
                .id(history.getId())
                .competitionId(history.getCompetitionId())
                .program(history.getProgram())
                .personId(history.getPersonId())
                .dogId(history.getDogId())
                .score(history.getScore())
                .build();
    }
}
