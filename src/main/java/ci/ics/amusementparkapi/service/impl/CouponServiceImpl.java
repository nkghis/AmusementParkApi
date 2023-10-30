package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CouponRequest;
import ci.ics.amusementparkapi.dto.response.CouponResponse;
import ci.ics.amusementparkapi.entity.Coupon;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.CouponMapper;
import ci.ics.amusementparkapi.repository.CouponRepository;
import ci.ics.amusementparkapi.service.CouponService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CouponServiceImpl implements CouponService {

    private CouponRepository couponRepository;
    private CouponMapper couponMapper;
    @Override
    public CouponResponse create(CouponRequest request) throws FieldDuplicateException {
        Optional<Coupon> couponOpt = couponRepository.findByCode(request.getCode());
        if (couponOpt.isPresent()){
            String message = "Le Coupon  ayant pour code : " +request.getCode() + " existe déja";
            throw new FieldDuplicateException(message);

        }else {

            Coupon coupon = Coupon.builder()
                    .code(request.getCode())
                    .pourcentage(request.getPourcentage())
                    .statut(false)
                    .build();

            return couponMapper.OUT(couponRepository.save(coupon));
        }
    }

    @Override
    public CouponResponse get(Long id) throws EntityNotFoundException {

        Optional<Coupon> couponOpt = couponRepository.findById(id);
        if (couponOpt.isPresent()){
            return couponMapper.OUT(couponOpt.get());
        }else {
            //Return error message
            String message = "Le Coupon ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }

    @Override
    public List<CouponResponse> all() {
        return couponMapper.OUT_LIST(couponRepository.findAll());
    }

    @Override
    public CouponResponse getCouponByCode(String codeCoupon) throws EntityNotFoundException {
        Optional<Coupon> coupon = couponRepository.findByCode(codeCoupon);
        if (coupon.isPresent()){
            return couponMapper.OUT(coupon.get());
        }else
        {
            //Return error message
            String message = "Le Coupon ayant pour code : " + codeCoupon + " est introuvable";
            throw new EntityNotFoundException(message);
        }


    }

    @Override
    public CouponResponse getCouponByCodeAndStatut(String codeCoupon, Boolean statut) throws EntityNotFoundException {
        Optional<Coupon> coupon = couponRepository.findByCodeAndStatut(codeCoupon, statut);

        if (coupon.isPresent()){
            return couponMapper.OUT(coupon.get());
        }else{
            //Return error message
            String message = "Le Coupon ayant pour code : " + codeCoupon + " et statut : "+ statut +" est introuvable";
            throw new EntityNotFoundException(message);
        }

    }
}
