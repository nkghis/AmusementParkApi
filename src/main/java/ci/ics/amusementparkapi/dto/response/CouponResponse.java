package ci.ics.amusementparkapi.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponResponse {

    private Long id;
    private String code;
    private Integer pourcentage;
    private String statut;
}
