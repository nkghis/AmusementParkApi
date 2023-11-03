package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Long> {

    Optional<Categorie> findByType(String type);
}
