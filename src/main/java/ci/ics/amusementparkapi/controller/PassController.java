package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.request.PassRequest;
import ci.ics.amusementparkapi.dto.request.ProduitRequest;
import ci.ics.amusementparkapi.dto.response.PassResponse;
import ci.ics.amusementparkapi.dto.response.ProduitResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.PassService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/pass")
public class PassController {

    private PassService passService;


    @PostMapping("/")
    public ResponseEntity<PassResponse> createPass(@RequestBody @Valid PassRequest passRequest) throws FieldDuplicateException {
        return new ResponseEntity<>(passService.createPass(passRequest), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<PassResponse>> allPass(){
        return ResponseEntity.ok(passService.all());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PassResponse> getPass(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(passService.get(id));
    }


}
