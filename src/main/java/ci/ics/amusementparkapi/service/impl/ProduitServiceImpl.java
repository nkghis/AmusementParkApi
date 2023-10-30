package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.entity.Categorie;
import ci.ics.amusementparkapi.entity.Produit;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.ProduitMapper;
import ci.ics.amusementparkapi.repository.CategorieRepository;
import ci.ics.amusementparkapi.repository.ProduitRepository;
import ci.ics.amusementparkapi.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private  ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;
    private ProduitMapper produitMapper;
    @Override
    public ProduitResponse create(ProduitRequest input) throws FieldDuplicateException {

        //Get Produit By Nom
        Produit p = produitRepository.findByNom(input.getNom());


        //Check If produit exist
        if (p != null){

            //Return Error
            String message = "Le produit  ayant pour nom : " + input.getNom() + " existe déja";
            throw new FieldDuplicateException(message);

        }else {
            //Persist Produit
            Categorie categorie = categorieRepository.getReferenceById(input.getCategorie());
            Produit produit = Produit.builder()
                    .nom(input.getNom().toUpperCase())
                    .prix(input.getPrix())
                    .image(input.getImage())
                    .description(input.getDescription())
                    .categorie(categorie)
                    .build();
            return produitMapper.OUT(produitRepository.save(produit));
        }

    }

    @Override
    public ProduitResponse get(Long id) throws EntityNotFoundException {

        // Get optional
        Optional<Produit> produit = produitRepository.findById(id);

        //Check if objet exist
        if (produit.isPresent()){
            //return ProduitResponse
            return produitMapper.OUT(produit.get());
        }else {

            //Return error message
            String message = "Le produit est introuvable ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }


    }

    @Override
    public List<ProduitResponse> all() {
        List<Produit> produits = produitRepository.findAll();
        return produitMapper.LIST_OUT(produits);
    }
}
