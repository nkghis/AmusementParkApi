package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.entity.Caisse;
import ci.ics.amusementparkapi.entity.Caissier;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.CaisseMapper;
import ci.ics.amusementparkapi.repository.CaisseRepository;
import ci.ics.amusementparkapi.service.CaisseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class CaisseServiceImpl implements CaisseService {
    private CaisseRepository caisseRepository;
    private CaisseMapper caisseMapper;
    @Override
    public CaisseResponse create(CaisseRequest request) throws FieldDuplicateException {

        Optional<Caisse> caisse = caisseRepository.findByMatricule(request.getMatricule());
        if (caisse.isPresent()){
            //Return Error
            String message = "La Caisse  ayant pour matricule : " +request.getMatricule() + " existe déja";
            throw new FieldDuplicateException(message);

        }else {
            Caisse c = Caisse.builder()
                    .nom(request.getNom())
                    .matricule(request.getMatricule())
                    .build();

            c = caisseRepository.save(c);

            return caisseMapper.OUT(c);

        }

    }

    @Override
    public List<CaisseResponse> all() {
        return caisseMapper.OUT_LIST(caisseRepository.findAll());
    }

    @Override
    public CaisseResponse get(Long id) throws EntityNotFoundException {

        Optional<Caisse> caisse = caisseRepository.findById(id);
        if (caisse.isPresent()){
            return caisseMapper.OUT(caisse.get());
        }else {
            //Return error message
            String message = "La Caisse ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }
}
