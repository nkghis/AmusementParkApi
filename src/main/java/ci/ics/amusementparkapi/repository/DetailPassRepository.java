package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.DetailPass;
import ci.ics.amusementparkapi.entity.Pass;
import ci.ics.amusementparkapi.entity.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailPassRepository extends JpaRepository<DetailPass, Long> {

     List<DetailPass> findAllByPass(Pass pass);
}
