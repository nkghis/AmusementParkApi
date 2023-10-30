package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaisseRequest {

    @NotNull
    private String matricule;
    @NotNull
    private String nom;
}
