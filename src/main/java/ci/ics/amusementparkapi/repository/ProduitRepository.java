package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
}
