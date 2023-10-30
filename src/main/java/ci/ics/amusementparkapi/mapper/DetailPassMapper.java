package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.DetailPassResponse;
import ci.ics.amusementparkapi.entity.DetailPass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailPassMapper {


    @Mapping(expression = "java(detailPass.getProduit().getNom())" , target = "produit")
    DetailPassResponse OUT (DetailPass detailPass);
    List<DetailPassResponse> OUT_LIST (List<DetailPass> detailPasses);

}
