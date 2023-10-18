package ci.ics.amusementparkapi.dto.categorie;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieINPUT {

    private String type;
    private String description;
}
