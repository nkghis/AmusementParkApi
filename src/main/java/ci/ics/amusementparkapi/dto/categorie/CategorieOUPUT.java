package ci.ics.amusementparkapi.dto.categorie;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieOUPUT {
    private Long id;
    private String type;
    private String description;
}

