package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class DetailPassRequest {

    @NotNull
    private Long produit;
    @NotNull
    @Positive
    private Integer quantite;
}
