package ci.ics.amusementparkapi.dto.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassResponse {

    private Long id;
    private String nom;
    private Integer prix;
    private String image;
    private String description;
    private String createdDate;
    private String type;
    private List<DetailPassResponse> detailPass;
}
