package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface CaisseService {

    CaisseResponse create (CaisseRequest request) throws FieldDuplicateException;
    List<CaisseResponse> all();

    CaisseResponse get(Long id) throws EntityNotFoundException;
}
