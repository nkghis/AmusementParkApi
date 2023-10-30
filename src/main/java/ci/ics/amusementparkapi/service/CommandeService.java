package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.CommandeRequest;
import ci.ics.amusementparkapi.dto.request.DetailCommandeRequest;
import ci.ics.amusementparkapi.dto.response.CommandeResponse;
import ci.ics.amusementparkapi.entity.Commande;
import ci.ics.amusementparkapi.entity.Coupon;
import ci.ics.amusementparkapi.entity.DetailCommande;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;

import java.util.List;

public interface CommandeService {

    CommandeResponse createCommande(CommandeRequest request) throws EntityNotFoundException;
    List<CommandeResponse> allCommandes();

    CommandeResponse getCommande(Long id) throws EntityNotFoundException;

    List<DetailCommande> allDetailCommandeByCommande(Commande commande);

    void createCommandeDetail(Commande commande, List<DetailCommandeRequest> requests);

    void updateCouponStatut(Coupon coupon);

    void createHistoriqueCoupon(Coupon coupon, Commande commande);


}
