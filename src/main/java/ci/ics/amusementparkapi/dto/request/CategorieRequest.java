package ci.ics.amusementparkapi.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieRequest {

    private String type;
    private String description;
}
