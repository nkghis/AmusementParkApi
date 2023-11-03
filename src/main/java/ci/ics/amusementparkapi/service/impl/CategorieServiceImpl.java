package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CategorieAllRequest;
import ci.ics.amusementparkapi.dto.request.CategorieRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CategorieResponse;
import ci.ics.amusementparkapi.entity.Categorie;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.CategorieMapper;
import ci.ics.amusementparkapi.repository.CategorieRepository;
import ci.ics.amusementparkapi.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    private CategorieMapper categorieMapper;
    @Override
    public CategorieResponse create(CategorieRequest request) throws FieldDuplicateException {

        Optional <Categorie> categorie = categorieRepository.findByType(request.getType());
        if (categorie.isPresent()){
            //Return Error
            String message = "La catégorie ayant pour type : " + request.getType() + " existe déja";
            throw new FieldDuplicateException(message);
        }else {
            return categorieMapper.OUT( categorieRepository.save(
                    Categorie.builder()
                            .type(request.getType())
                            .description(request.getDescription())
                            .build()
            ));

        }

    }

    @Override
    public List<CategorieResponse> all() {
        return categorieMapper.OUT_LIST(categorieRepository.findAll());
    }

    @Override
    public CategorieResponse get(Long id) throws EntityNotFoundException {

        Optional<Categorie> categorie = categorieRepository.findById(id);
        if (categorie.isPresent()){
            return categorieMapper.OUT(categorie.get());
        }else {
            //Return error message
            String message = "La Catégorie ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }

    @Override
    public List<CategorieResponse> createAll(CategorieAllRequest categorieAllRequest) {

        return categorieAllRequest.getCategories().stream().map(request -> {
            Categorie categorie = new Categorie();
            categorie.setType(request.getType());
            categorie.setDescription(request.getDescription());
            return categorieMapper.OUT(categorieRepository.save(categorie));
        }).toList();
    }
}
