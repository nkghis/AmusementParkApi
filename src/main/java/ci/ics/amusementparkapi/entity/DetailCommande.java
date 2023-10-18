package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "details_commandes")
public class DetailCommande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passId", nullable = false)
    private Pass pass;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "commandeId", nullable = false)
    private Commande commande;

    @Column(name = "quantite")
    private Integer quantite;



}
