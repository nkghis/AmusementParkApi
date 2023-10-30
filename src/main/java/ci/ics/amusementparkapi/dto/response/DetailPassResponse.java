package ci.ics.amusementparkapi.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DetailPassResponse {
    private Long id;
    private String produit;
    private Integer quantite;
}
