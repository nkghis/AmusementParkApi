package ci.ics.amusementparkapi.controller;

import ci.ics.amusementparkapi.dto.request.CaisseRequest;
import ci.ics.amusementparkapi.dto.request.CommandeRequest;
import ci.ics.amusementparkapi.dto.response.CaisseResponse;
import ci.ics.amusementparkapi.dto.response.CommandeResponse;
import ci.ics.amusementparkapi.exception.EntityNotFoundException;
import ci.ics.amusementparkapi.exception.FieldDuplicateException;
import ci.ics.amusementparkapi.service.CommandeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/commandes")
public class CommandeController {

    private CommandeService commandeService;

    @PostMapping("/")
    public ResponseEntity<CommandeResponse> createCommande(@RequestBody @Valid CommandeRequest request) throws EntityNotFoundException /*throws FieldDuplicateException*/ {
        return new ResponseEntity<>(commandeService.createCommande(request), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<CommandeResponse>> allCaisse(){
        return ResponseEntity.ok(commandeService.allCommandes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CommandeResponse> getProduit(@PathVariable Long id) throws EntityNotFoundException {

        return ResponseEntity.ok(commandeService.getCommande(id));
    }

}
