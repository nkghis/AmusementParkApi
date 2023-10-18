package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.categorie.CategorieINPUT;
import ci.ics.amusementparkapi.entity.Categorie;
import ci.ics.amusementparkapi.repository.CategorieRepository;
import ci.ics.amusementparkapi.service.CategorieService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategorieServiceImpl implements CategorieService {

    private CategorieRepository categorieRepository;
    @Override
    public void create(CategorieINPUT input) {

        categorieRepository.save(
                Categorie.builder()
                        .type(input.getType())
                        .description(input.getDescription())
                        .build()
        );

    }
}
