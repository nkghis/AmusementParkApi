package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.entity.Caissier;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CaissierMapper {

    CaissierResponse OUT (Caissier caissier);
    List<CaissierResponse> OUT_LIST ( List<Caissier> caissiers);
}
