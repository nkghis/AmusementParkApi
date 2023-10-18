package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.produit.ProduitOUTPUT;
import ci.ics.amusementparkapi.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    @Mapping(source = "produit.categorie.type", target = "categorie")
    ProduitOUTPUT OUT (Produit produit);

    List<ProduitOUTPUT> LIST_OUT (List<Produit> produits);
}
