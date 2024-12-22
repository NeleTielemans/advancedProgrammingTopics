package fact.it.historyservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HistoryResponse {
    private long id;
    private String competitionId;
    private String program;
    private String personId;
    private String dogId;
    private int score;
}
