package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long> {
}
