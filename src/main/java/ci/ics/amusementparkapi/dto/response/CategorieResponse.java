package ci.ics.amusementparkapi.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieResponse {
    private Long id;
    private String type;
    private String description;
}

