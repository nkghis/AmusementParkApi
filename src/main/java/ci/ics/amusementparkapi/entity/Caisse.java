package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "caisses", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "CAISSE_UK",columnNames = "matricule") })
public class Caisse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "matricule", unique = true)
    private String matricule;

    @Column(name = "nom")
    private String nom;
}
