package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassRequest {

    @NotNull
    private String nom;
    @NotNull
    @Positive
    private Integer prix;



    private String image;
    private String description;

    @NotNull
    private Long type;

    @NotNull
    List<DetailPassRequest> detailPassRequests;
}
