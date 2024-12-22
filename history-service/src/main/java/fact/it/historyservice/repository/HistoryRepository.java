package fact.it.historyservice.repository;

import fact.it.historyservice.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}