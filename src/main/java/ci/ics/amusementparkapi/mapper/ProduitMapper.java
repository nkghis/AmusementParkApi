package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.entity.Produit;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProduitMapper {
    @Mapping(source = "produit.categorie.type", target = "categorie")
    ProduitResponse OUT (Produit produit);

    List<ProduitResponse> LIST_OUT (List<Produit> produits);
}
