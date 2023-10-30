package ci.ics.amusementparkapi.mapper;

import ci.ics.amusementparkapi.dto.response.CommandeResponse;
import ci.ics.amusementparkapi.dto.response.DetailCommandeResponse;
import ci.ics.amusementparkapi.entity.Commande;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CommandeMapper {


    @Mapping(source = "commande.id" , target = "id")
    @Mapping(source = "commande.montant" , target = "montant")
    @Mapping(source = "commande.montantRemise" , target = "montantRemise")
    @Mapping(source = "commande.montantTotal" , target = "montantTotal")
    @Mapping(source = "commande.date" , target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss" )
    @Mapping(source = "commande.estReduit" , target = "estReduit")
   /* @Mapping(source = "commande.codeCoupon" , target = "codeCoupon")*/
    @Mapping(expression = "java(commande.getCaisse().getNom())"  , target = "caisse")
    @Mapping(expression = "java(commande.getCaissier().toNomComplet())"  , target = "caissier")
    @Mapping(expression = "java(commande.getTypePaiement().getNom())"  , target = "typePaiement")
    @Mapping(source = "detailCommandes" , target = "detailCommandes")
    CommandeResponse OUT (Commande commande, List<DetailCommandeResponse> detailCommandes);
}
