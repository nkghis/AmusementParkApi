package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CommandeRequest;
import ci.ics.amusementparkapi.dto.request.DetailCommandeRequest;
import ci.ics.amusementparkapi.dto.response.CommandeResponse;
import ci.ics.amusementparkapi.dto.response.DetailCommandeResponse;
import ci.ics.amusementparkapi.entity.*;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.mapper.CommandeMapper;
import ci.ics.amusementparkapi.mapper.DetailCommandeMapper;
import ci.ics.amusementparkapi.repository.*;
import ci.ics.amusementparkapi.service.CommandeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CommandeServiceImpl implements CommandeService {
    private CommandeRepository commandeRepository;
    private DetailCommandeRepository detailCommandeRepository;
    private PassRepository passRepository;
    private CaisseRepository caisseRepository;
    private CaissierRepository caissierRepository;
    private TypePaiementRepository typePaiementRepository;
    private HistoriqueCouponRepository historiqueCouponRepository;
    private CouponRepository couponRepository;
    private CommandeMapper commandeMapper;
    private DetailCommandeMapper detailCommandeMapper;

    @Override
    public CommandeResponse createCommande(CommandeRequest request) throws EntityNotFoundException {

        //Get Coupon by String Coupon and Statut
        Optional<Coupon> coupon = couponRepository.findByCodeAndStatut(request.getCodeCoupon(), false);
        boolean result;
        //Check if coupon string is empty
        if (request.getCodeCoupon().isEmpty()){
            //Set isReduit value
            result = false;
        }else {
            //Set isReduit value
            result = true;

            //Check if coupon is valid
            if (coupon.isEmpty()){
                //Return error message
                String message = "La coupon ayant pour code : " + request.getCodeCoupon() + " est invalide";
                throw new EntityNotFoundException(message);
            }


        }
        //Set Commande
        Commande commande = Commande.builder()
                .montant(request.getMontant())
                .montantRemise(request.getMontantRemise())
                .montantTotal(request.getMontantTotal())
                .date(LocalDateTime.now())
                .estReduit(result)
                /*.codeCoupon(request.getCodeCoupon())*/
                .caisse(caisseRepository.getReferenceById(request.getCaisse()))
                .caissier(caissierRepository.getReferenceById(request.getCaissier()))
                .typePaiement(typePaiementRepository.getReferenceById(request.getTypePaiement()))
                .build();
        //Persist commande
     /*Commande commande1 = */ commandeRepository.save(commande);
      //Persist detail commande
      this.createCommandeDetail(commande, request.getDetailCommandes());

      //Get all detail commande by commande
      List<DetailCommande> detailCommandes = this.allDetailCommandeByCommande(commande);


      //Check if coupon is not empty
        if (!request.getCodeCoupon().isEmpty()){

            //update coupon instance
                this.updateCouponStatut(coupon.get());
                //Create coupon history
                this.createHistoriqueCoupon(coupon.get(), commande);

        }
      // return Commande in commande response
        return commandeMapper.OUT(commande, detailCommandeMapper.OUT_LIST(detailCommandes));
    }

    @Override
    public List<CommandeResponse> allCommandes() {

        //Get all commande
        List<Commande> commandes = commandeRepository.findAll() ;

        return commandes.stream().map(commande -> {
            //Get All detailCommande By Commande
            List<DetailCommande> detailCommandes = this.allDetailCommandeByCommande(commande);
            //Parse list of detail commande to detail commande response
            List<DetailCommandeResponse> detailCommandesResponse = detailCommandeMapper.OUT_LIST(detailCommandes);
            return commandeMapper.OUT(commande, detailCommandesResponse);
        }).toList();
    }

    @Override
    public CommandeResponse getCommande(Long id) throws EntityNotFoundException {
        Optional<Commande> c = commandeRepository.findById(id);
        if(c.isPresent()){
            //Get Commande
            Commande  commande = c.get();
            //Get all detailCommande By Commande
            List<DetailCommande> detailCommandes = this.allDetailCommandeByCommande(commande);
            // parse DetailCommande to detailCommande Response
            List<DetailCommandeResponse> detailCommandeResponses = detailCommandeMapper.OUT_LIST(detailCommandes);
            //return Commande Response
            return commandeMapper.OUT(commande, detailCommandeResponses);
        }else {

            //Return error message
            String message = "La commande ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }

    @Override
    public List<DetailCommande> allDetailCommandeByCommande(Commande commande) {
        return detailCommandeRepository.findAllByCommande(commande);
    }

    @Override
    public void createCommandeDetail(Commande commande, List<DetailCommandeRequest> requests) {
        requests.forEach(detailCommandeRequest -> {
            DetailCommande detailCommande = DetailCommande.builder()
                    .commande(commande)
                    .pass(passRepository.getReferenceById(detailCommandeRequest.getPass()))
                    .quantite(detailCommandeRequest.getQuantite())
                    .build();
            detailCommandeRepository.save(detailCommande);
        });
    }

    @Override
    public void updateCouponStatut(Coupon coupon) {
        coupon.setStatut(true);
        couponRepository.save(coupon);
    }

    @Override
    public void createHistoriqueCoupon(Coupon coupon, Commande commande) {

        HistoriqueCoupon historiqueCoupon = HistoriqueCoupon.builder()
                .coupon(coupon)
                .commande(commande)
                .date(LocalDateTime.now())
                .build();
        historiqueCouponRepository.save(historiqueCoupon);
    }
}
