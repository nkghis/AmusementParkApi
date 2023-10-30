package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CaissierRequest;
import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.entity.Caissier;
import ci.ics.amusementparkapi.enums.Sexe;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.CaissierMapper;
import ci.ics.amusementparkapi.repository.CaissierRepository;
import ci.ics.amusementparkapi.service.CaisseService;
import ci.ics.amusementparkapi.service.CaissierService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CaissierServiceImpl implements CaissierService {

    private CaissierRepository caissierRepository;
    private CaissierMapper caissierMapper;
    @Override
    public CaissierResponse create(CaissierRequest request) throws FieldDuplicateException {
        Optional<Caissier> c = caissierRepository.findByMatricule(request.getMatricule());
        if (c.isPresent()){

            //Return Error
            String message = "Le Caissier  ayant pour matricule : " + request.getMatricule() + " existe déja";
            throw new FieldDuplicateException(message);

        }else {
            Caissier caissier = Caissier.builder()
                    .matricule(request.getMatricule())
                    .nom(request.getNom())
                    .prenom(request.getPrenom())
                    /*.dateNaissance(request.getDateNaissance())*/
                    .dateNaissance(LocalDate.parse(request.getDateNaissance()))
                    .sexe(Sexe.valueOf(request.getSexe()))
                    .build();

            caissier = caissierRepository.save(caissier);
            return caissierMapper.OUT(caissier);
        }

    }

    @Override
    public List<CaissierResponse> all() {
        return caissierMapper.OUT_LIST(caissierRepository.findAll());
    }

    @Override
    public CaissierResponse get(Long id) throws EntityNotFoundException {

        Optional<Caissier> caissier = caissierRepository.findById(id);
        if (caissier.isPresent()){

            return caissierMapper.OUT(caissier.get());
        }else {

            //Return error message
            String message = "Le Caissier  ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }
}
