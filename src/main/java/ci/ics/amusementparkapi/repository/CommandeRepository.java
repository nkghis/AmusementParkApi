package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}
