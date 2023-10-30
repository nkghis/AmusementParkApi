package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.ProduitService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/produits")
public class ProduitController {

    private ProduitService produitService;

    @PostMapping("/")
    public ResponseEntity<ProduitResponse> createProduit(@RequestBody @Valid ProduitRequest produitRequest) throws FieldDuplicateException {
        return new ResponseEntity<>(produitService.create(produitRequest), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<ProduitResponse>> allProduits(){
        return ResponseEntity.ok(produitService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProduitResponse> getProduit(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(produitService.get(id));
    }

}
