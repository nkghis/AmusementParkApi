package ci.ics.amusementparkapi.service.impl;

import ci.ics.amusementparkapi.dto.request.DetailPassRequest;
import ci.ics.amusementparkapi.dto.request.PassRequest;
import ci.ics.amusementparkapi.dto.response.PassResponse;
import ci.ics.amusementparkapi.entity.DetailPass;
import ci.ics.amusementparkapi.entity.Pass;
import ci.ics.amusementparkapi.entity.Produit;
import ci.ics.amusementparkapi.entity.Type;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.mapper.DetailPassMapper;
import ci.ics.amusementparkapi.mapper.PassMapper;
import ci.ics.amusementparkapi.mapper.ProduitMapper;
import ci.ics.amusementparkapi.repository.DetailPassRepository;
import ci.ics.amusementparkapi.repository.PassRepository;
import ci.ics.amusementparkapi.repository.ProduitRepository;
import ci.ics.amusementparkapi.repository.TypeRepository;
import ci.ics.amusementparkapi.service.PassService;
import ci.ics.amusementparkapi.utils.DateConvert;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PassServiceImpl implements PassService {

    private PassRepository passRepository;
    private ProduitRepository produitRepository;
    private DetailPassRepository detailPassRepository;
    private PassMapper passMapper;
    private ProduitMapper produitMapper;
    private DetailPassMapper detailPassMapper;
    private TypeRepository typeRepository;


    @Override
    public PassResponse createPass(PassRequest request) throws FieldDuplicateException {

        //Get pass by name
        Pass p = passRepository.findByNom(request.getNom());

        //Check if pass exist
        if (p != null){
            //Return Error if pass name exist
            String message = "Le Pass  ayant pour nom : " + request.getNom() + " existe déja";
            throw new FieldDuplicateException(message);
        }else {

            Type type = typeRepository.getReferenceById(request.getType());
            //Create pass
            Pass pass = Pass.builder()
                    .nom(request.getNom())
                    .prix(request.getPrix())
                    .description(request.getDescription())
                    .image(request.getImage())
                    .createdDate(LocalDateTime.now())
                    .image(request.getImage())
                    .type(type)
                    .build();

            //List<Produit> produits = new ArrayList<>();

           /* // Get list of product
            List<Produit> produits = request.getDetailPassRequests().stream().map(id ->{
                return produitRepository.getReferenceById(id);
            }).toList();*/



            //Persist pass
            Pass passs = passRepository.save(pass);

            //Get All DetailPass by pass
            List<DetailPass> detailPass = this.findAllByPass(passs);

            //Persist detailPass
            this.createPassDetail(passs, request.getDetailPassRequests());
            return passMapper.OUT(pass, detailPassMapper.OUT_LIST(detailPass) ) ;
        }


    }

    @Override
    public PassResponse get(Long id) throws EntityNotFoundException {

        Optional<Pass> oPass = passRepository.findById(id);
        if (oPass.isPresent()){

            //Get pass
            Pass pass = oPass.get();

            //Get All produits attach on pass
            List<DetailPass> detailPass = this.findAllByPass(pass);
            return passMapper.OUT(pass, detailPassMapper.OUT_LIST(detailPass));
            //return passMapper.;
        }else {

            //Return error message
            String message = "Le produit est introuvable ayant pour identifiant : " + id + " est introuvable";
            throw new EntityNotFoundException(message);
        }

    }

    @Override
    public List<PassResponse> all() {

        List<Pass> passes = passRepository.findAll();

        return passes.stream().map(pass -> {
            List<DetailPass> detailPasses = this.findAllByPass(pass);
            return passMapper.OUT(pass, detailPassMapper.OUT_LIST(detailPasses));
        }).toList();



       /* List<PassResponse> passResponses = new ArrayList<>();

        for (Pass pass : passes){

            List<DetailPass> detailPasses = this.findAllByPass(pass);
            PassResponse passResponse = passMapper.OUT(pass, detailPassMapper.OUT_LIST(detailPasses));
            *//*PassResponse passResponse = PassResponse.builder()
                    .id(pass.getId())
                    .nom(pass.getNom())
                    .prix(pass.getPrix())
                    .image(pass.getImage())
                    .description(pass.getDescription())
                    .type(pass.getType().getNom())
                    .createdDate(DateConvert.getStringDate(pass.getCreatedDate()))
                    .detailPass(detailPassMapper.OUT_LIST(detailPasses))
                    .build();*//*
            passResponses.add(passResponse);

        }

        return passResponses;*/
    }

    @Override
    public void createPassDetail(Pass pass, List<DetailPassRequest> detailPassRequests) {

        for (DetailPassRequest detail : detailPassRequests){
            //Get produit
            Produit produit = produitRepository.getReferenceById(detail.getProduit());
            DetailPass detailPass = DetailPass.builder()
                    .pass(pass)
                    .quantite(detail.getQuantite())
                    .produit(produit)
                    .build();
            detailPassRepository.save(detailPass);
        }
    }

    @Override
    public List<DetailPass> findAllByPass(Pass pass) {
        return detailPassRepository.findAllByPass(pass);
    }
}
