package ci.ics.amusementparkapi.dto.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaissierResponse {

    private Long id;
    private String matricule;
    private String nom;
    private String prenom;
    private String dateNaissance;
    private String sexe;
}
