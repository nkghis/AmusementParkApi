package ci.ics.amusementparkapi.dto.request;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategorieAllRequest {

    private List<CategorieRequest> categories;
}
