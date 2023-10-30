package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface ProduitService {

    ProduitResponse create(ProduitRequest input) throws FieldDuplicateException;

    ProduitResponse get(Long id) throws EntityNotFoundException;

    List<ProduitResponse> all();


}
