package ci.ics.amusementparkapi.dto.response;

import ci.ics.amusementparkapi.entity.Caisse;
import ci.ics.amusementparkapi.entity.Caissier;
import ci.ics.amusementparkapi.entity.TypePaiement;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeResponse {
    private Long id;
    private Integer montant;
    private Integer montantRemise;
    private Integer montantTotal;
    private String date;
    private boolean estReduit;
    /*private String codeCoupon;*/
    private String caisse;
    private String caissier;
    private String typePaiement;
    List<DetailCommandeResponse> detailCommandes;
}
