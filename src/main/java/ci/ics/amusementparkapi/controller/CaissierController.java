package ci.ics.amusementparkapi.controller;


import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.CaissierRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CaissierResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.CaissierService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/caissiers")
public class CaissierController {

    private CaissierService caissierService;

    @PostMapping("/")
    public ResponseEntity<CaissierResponse> createCaisse(@RequestBody @Valid CaissierRequest request) throws FieldDuplicateException {
        return new ResponseEntity<>(caissierService.create(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CaissierResponse>> allCaisse(){
        return ResponseEntity.ok(caissierService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaissierResponse> getProduit(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(caissierService.get(id));
    }


}
