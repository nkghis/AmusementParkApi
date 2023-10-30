package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommandeRequest {

    @NotNull
    @Positive
    private Integer montant;
    @NotNull
    private Integer montantRemise;
    @NotNull
    private Integer montantTotal;
/*    @NotNull
    private boolean estReduit;*/

    private String codeCoupon;
    @NotNull
    private Long caisse;
    @NotNull
    private Long caissier;
    @NotNull
    private Long typePaiement;

    @NotNull
    private List<DetailCommandeRequest> detailCommandes;
}
