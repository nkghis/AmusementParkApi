package ci.ics.amusementparkapi.service;

import ci.ics.amusementparkapi.dto.produit.ProduitINPUT;
import ci.ics.amusementparkapi.dto.produit.ProduitOUTPUT;

import java.util.List;

public interface ProduitService {

    void create(ProduitINPUT input);

    List<ProduitOUTPUT> all();

}
