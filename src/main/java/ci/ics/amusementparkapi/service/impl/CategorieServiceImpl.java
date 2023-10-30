package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.CategorieRequest;
import ci.ics.amusementparkapi.entity.Categorie;
import ci.ics.amusementparkapi.repository.CategorieRepository;
import ci.ics.amusementparkapi.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    @Override
    public void create(CategorieRequest input) {

        categorieRepository.save(
                Categorie.builder()
                        .type(input.getType())
                        .description(input.getDescription())
                        .build()
        );

    }
}
