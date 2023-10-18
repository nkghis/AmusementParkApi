package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
}
