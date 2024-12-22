package fact.it.historyservice.controller;

import fact.it.historyservice.dto.CompetitionResponse;
import fact.it.historyservice.dto.HistoryRequest;
import fact.it.historyservice.dto.HistoryResponse;
import fact.it.historyservice.model.History;
import fact.it.historyservice.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/history")
@RequiredArgsConstructor
public class HistoryController {
    private final HistoryService historyService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public String addHistory(@RequestBody HistoryRequest historyRequest) {
        return historyService.createNewHistory(historyRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<HistoryResponse> getAllProducts() {
        return historyService.getAllHistories();
    }
}
