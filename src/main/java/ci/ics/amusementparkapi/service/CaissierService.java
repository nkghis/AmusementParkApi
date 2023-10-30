package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.CaissierRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface CaissierService {

    CaissierResponse create (CaissierRequest request) throws FieldDuplicateException;
    List<CaissierResponse> all();

    CaissierResponse get(Long id) throws EntityNotFoundException;
}
