package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeRepository extends JpaRepository<Type, Long> {
}
