package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.CategorieAllRequest;
import ci.ics.amusementparkapi.dto.request.CategorieRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CategorieResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.CategorieService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategorieController {

    private CategorieService categorieService;


    @PostMapping("/")
    public ResponseEntity<CategorieResponse> createCategorie(@RequestBody @Valid CategorieRequest request) throws FieldDuplicateException {
        return new ResponseEntity<>(categorieService.create(request), HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<CategorieResponse>> createAllCategories(@RequestBody @Valid CategorieAllRequest requests) throws FieldDuplicateException {
        return new ResponseEntity<>(categorieService.createAll(requests), HttpStatus.CREATED);
    }


    @GetMapping("/")
    public ResponseEntity<List<CategorieResponse>> allCaisse(){
        return ResponseEntity.ok(categorieService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategorieResponse> getProduit(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(categorieService.get(id));
    }
}
