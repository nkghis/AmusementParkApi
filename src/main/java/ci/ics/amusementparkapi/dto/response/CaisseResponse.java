package ci.ics.amusementparkapi.dto.response;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaisseResponse {

    private Long id;
    private String matricule;
    private String nom;
}
