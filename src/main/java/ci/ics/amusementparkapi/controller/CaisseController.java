package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.CaisseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/caisses")
public class CaisseController {

    private CaisseService caisseService;

    @PostMapping("/")
    public ResponseEntity<CaisseResponse> createCaisse(@RequestBody @Valid CaisseRequest request) throws FieldDuplicateException {
        return new ResponseEntity<>(caisseService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CaisseResponse>> allCaisse(){
        return ResponseEntity.ok(caisseService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaisseResponse> getProduit(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(caisseService.get(id));
    }



}
