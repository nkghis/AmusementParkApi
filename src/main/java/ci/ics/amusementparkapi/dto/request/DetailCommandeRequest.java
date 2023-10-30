package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailCommandeRequest {
    @NotNull
    private Long pass;
    @NotNull
    @Positive
    private Integer quantite;
}
