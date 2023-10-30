package ci.ics.amusementparkapi.repository;

import ci.ics.amusementparkapi.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCode(String code);
    Optional<Coupon> findByCodeAndStatut(String code, Boolean Statut);
}
