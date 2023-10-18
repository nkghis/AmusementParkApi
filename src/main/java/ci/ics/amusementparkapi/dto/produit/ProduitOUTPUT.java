package ci.ics.amusementparkapi.dto.produit;

import ci.ics.amusementparkapi.entity.Categorie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitOUTPUT {

    private Long id;
    private String nom;
    private Integer prix;
    private String description;
    private String categorie;
}
