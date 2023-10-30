package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.entity.Caisse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaisseMapper {

    CaisseResponse OUT (Caisse caisse);
    List<CaisseResponse> OUT_LIST (List<Caisse> caisses);
}
