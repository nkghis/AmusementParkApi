package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.DetailPassResponse;
import ci.ics.amusementparkapi.dto.response.PassResponse;
import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.entity.Pass;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassMapper {


    @Mapping(source = "pass.id" , target = "id")
    @Mapping(source = "pass.nom" , target = "nom")
    @Mapping(source = "pass.prix" , target = "prix")
    @Mapping(source = "pass.image" , target = "image")
    @Mapping(source = "pass.description" , target = "description")
    @Mapping(source = "pass.createdDate" , target = "createdDate", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(expression = "java(pass.getType().getNom())" , target = "type")
    @Mapping(source = "detailPass" , target = "detailPass")
    PassResponse OUT (Pass pass, List<DetailPassResponse> detailPass);
}
