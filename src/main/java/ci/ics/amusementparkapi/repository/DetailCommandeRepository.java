package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Commande;
import ci.ics.amusementparkapi.entity.DetailCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailCommandeRepository extends JpaRepository<DetailCommande, Long> {

    List<DetailCommande> findAllByCommande(Commande commande);
}
