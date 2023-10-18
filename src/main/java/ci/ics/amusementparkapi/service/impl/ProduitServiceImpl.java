package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.produit.ProduitINPUT;
import ci.ics.amusementparkapi.dto.produit.ProduitOUTPUT;
import ci.ics.amusementparkapi.entity.Categorie;
import ci.ics.amusementparkapi.entity.Produit;
import ci.ics.amusementparkapi.mapper.ProduitMapper;
import ci.ics.amusementparkapi.repository.CategorieRepository;
import ci.ics.amusementparkapi.repository.ProduitRepository;
import ci.ics.amusementparkapi.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    private  ProduitRepository produitRepository;
    private CategorieRepository categorieRepository;
    private ProduitMapper produitMapper;
    @Override
    public void create(ProduitINPUT input) {

        Categorie categorie = categorieRepository.getReferenceById(input.getCategorie());
        Produit produit = Produit.builder()
                .nom(input.getNom())
                .prix(input.getPrix())
                .image(input.getImage())
                .description(input.getDescription())
                .categorie(categorie)
                .build();
        /*Produit produit = new Produit();
        produit.setNom(input.getNom());
        produit.setPrix(input.getPrix());
        produit.setImage(input.getImage());
        produit.setDescription(input.getDescription());
        produit.setCategorie(categorie);*/
        produitRepository.save(produit);
    }

    @Override
    public List<ProduitOUTPUT> all() {
        List<Produit> produits = produitRepository.findAll();
        return produitMapper.LIST_OUT(produits);
    }
}
