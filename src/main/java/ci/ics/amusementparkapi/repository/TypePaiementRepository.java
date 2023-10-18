package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.TypePaiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypePaiementRepository extends JpaRepository<TypePaiement, Long> {
}
