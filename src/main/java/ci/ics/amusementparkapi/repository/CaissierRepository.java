package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Caissier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CaissierRepository extends JpaRepository<Caissier, Long> {
}
