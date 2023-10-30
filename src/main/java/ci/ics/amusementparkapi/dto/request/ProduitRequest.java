package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProduitRequest {

    @NotNull(message = "Le nom est un champ requis")
    private String nom;
    @NotNull (message = "Le prix est un champ requis")
    @Positive
    /*@Digits(fraction = 0, integer = 0)*/
    //@Pattern(regexp = "[0-9]+", message = "Ce champ doit contenir que des chiffres")
    private Integer prix;


    private String image;


    private String description;

    @NotNull
    private Long categorie;
}
