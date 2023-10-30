package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.CouponRequest;
import ci.ics.amusementparkapi.dto.response.CouponResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface CouponService {

    CouponResponse create (CouponRequest request) throws FieldDuplicateException;
    CouponResponse get (Long id) throws EntityNotFoundException;

    List<CouponResponse> all();

    CouponResponse getCouponByCode(String codeCoupon) throws EntityNotFoundException;

    CouponResponse getCouponByCodeAndStatut(String codeCoupon, Boolean statut) throws EntityNotFoundException;
}
