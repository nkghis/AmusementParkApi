package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Pass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassRepository extends JpaRepository<Pass, Long> {
}
