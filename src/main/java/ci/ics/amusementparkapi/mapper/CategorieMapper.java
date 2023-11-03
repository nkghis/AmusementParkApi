package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.CategorieResponse;
import ci.ics.amusementparkapi.entity.Categorie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategorieMapper {
    CategorieResponse OUT (Categorie categorie);
    List<CategorieResponse> OUT_LIST (List<Categorie> categories);
}
