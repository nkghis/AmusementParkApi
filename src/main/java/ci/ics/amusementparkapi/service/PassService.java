package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.request.DetailPassRequest;
import ci.ics.amusementparkapi.dto.request.PassRequest;
import ci.ics.amusementparkapi.dto.response.PassResponse;
import ci.ics.amusementparkapi.entity.DetailPass;
import ci.ics.amusementparkapi.entity.Pass;
import ci.ics.amusementparkapi.entity.Produit;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;

import java.util.List;

public interface PassService {

    PassResponse createPass(PassRequest request) throws FieldDuplicateException;
    PassResponse get (Long id) throws EntityNotFoundException;

    List<PassResponse> all();


    void createPassDetail(Pass pass, List<DetailPassRequest> detailPassRequests);

    List<DetailPass> findAllByPass(Pass pass);
    //List<DetailPass> findAllDetailPassByPass(Pass pass);
}
