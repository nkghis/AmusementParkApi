package ci.ics.amusementparkapi.dto.request;

import ci.ics.amusementparkapi.enums.Sexe;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CaissierRequest {

    @NotNull
    private String matricule;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
 /*   @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateNaissance;*/

    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$", message = "Ce champ doit respecter le format : AAAA-MM-JJ")
    private String dateNaissance;

    @NotNull
    private String sexe;
}
