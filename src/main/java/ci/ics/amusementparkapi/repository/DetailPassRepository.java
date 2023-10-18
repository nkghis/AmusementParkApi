package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.DetailPass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailPassRepository extends JpaRepository<DetailPass, Long> {
}
