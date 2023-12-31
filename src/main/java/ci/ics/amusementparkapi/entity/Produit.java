package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "produits", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "PRODUIT_UK",columnNames = "nom") })
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", unique = true)
    private String nom;

    @Column(name = "prix")
    private Integer prix;

    @Column(name = "image")
    private String image;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "categorieId")
    private Categorie categorie;

}
