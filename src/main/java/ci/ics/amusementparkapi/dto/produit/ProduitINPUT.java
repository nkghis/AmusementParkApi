package ci.ics.amusementparkapi.dto.produit;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProduitINPUT {

    private String nom;
    private Integer prix;
    private String image;
    private String description;
    private Long categorie;
}
