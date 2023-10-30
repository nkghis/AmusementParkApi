package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.CouponRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CouponResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.CouponService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/coupons")
public class CouponController {
    private CouponService couponService;

    @PostMapping("/")
    public ResponseEntity<CouponResponse> createCoupon(@RequestBody @Valid CouponRequest request) throws FieldDuplicateException {
        return new ResponseEntity<>(couponService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CouponResponse>> allCoupons(){
        return ResponseEntity.ok(couponService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CouponResponse> getCoupon(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(couponService.get(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<CouponResponse> CheckCouponByCode(@PathVariable String code) throws EntityNotFoundException {

        return ResponseEntity.ok(couponService.getCouponByCode(code));
    }


    @GetMapping("/{code}/{statut}")
    public ResponseEntity<CouponResponse> CheckCouponByCodeAndStatut(@PathVariable String code, @PathVariable Boolean statut) throws EntityNotFoundException {

        return ResponseEntity.ok(couponService.getCouponByCodeAndStatut(code, statut));
    }


}
