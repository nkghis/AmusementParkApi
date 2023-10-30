package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.DetailCommandeResponse;
import ci.ics.amusementparkapi.entity.DetailCommande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailCommandeMapper {

    @Mapping(expression = "java(detailCommande.getPass().getId())" , target = "passId")
    @Mapping(expression = "java(detailCommande.getPass().getNom())" , target = "pass")
    DetailCommandeResponse OUT (DetailCommande detailCommande);

    List<DetailCommandeResponse> OUT_LIST (List<DetailCommande> detailCommandes);
}
