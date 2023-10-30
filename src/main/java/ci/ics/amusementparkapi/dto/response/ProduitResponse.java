package ci.ics.amusementparkapi.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProduitResponse {

    private Long id;
    private String nom;
    private Integer prix;
    private String description;
    private String categorie;
}
