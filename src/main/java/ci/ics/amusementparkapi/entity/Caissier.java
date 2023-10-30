package ci.ics.amusementparkapi.entity;

import ci.ics.amusementparkapi.enums.Sexe;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "caissiers", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "CAISSIER_UK",columnNames = "matricule") })
public class Caissier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricule", unique = true)
    private String matricule;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "sexe")
    private Sexe sexe;

    public String toNomComplet(){
        return this.prenom + " " + this.nom;
    }


}
