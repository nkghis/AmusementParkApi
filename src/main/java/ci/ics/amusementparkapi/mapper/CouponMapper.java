package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.CouponResponse;
import ci.ics.amusementparkapi.entity.Coupon;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CouponMapper {

    @Mapping(expression = "java(coupon.toString())"  , target = "statut")
    CouponResponse OUT (Coupon coupon);

    List<CouponResponse> OUT_LIST(List<Coupon> coupons);
}
