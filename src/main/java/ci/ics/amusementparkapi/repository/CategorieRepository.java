package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {
}
