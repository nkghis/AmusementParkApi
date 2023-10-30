package ci.ics.amusementparkapi.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailCommandeResponse {
    private Long id;
    private Long passId;
    private String pass;
    private Integer quantite;
}
