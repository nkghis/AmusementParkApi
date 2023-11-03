package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.CategorieAllRequest;
import ci.ics.amusementparkapi.dto.request.CategorieRequest;
import ci.ics.amusementparkapi.dto.response.CategorieResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface CategorieService {
    CategorieResponse create (CategorieRequest input) throws FieldDuplicateException;

    List<CategorieResponse> all();

    CategorieResponse get(Long id) throws EntityNotFoundException;

    List<CategorieResponse> createAll(CategorieAllRequest request);
}
