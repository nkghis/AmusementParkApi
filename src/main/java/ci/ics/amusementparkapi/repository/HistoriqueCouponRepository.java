package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.HistoriqueCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoriqueCouponRepository extends JpaRepository<HistoriqueCoupon, Long> {
}
