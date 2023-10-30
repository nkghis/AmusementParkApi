package ci.ics.amusementparkapi.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CouponRequest {

    @NotBlank
    private String code;
    @NotNull
    @Positive
    private Integer pourcentage;

}
