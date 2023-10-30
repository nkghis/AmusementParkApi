package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "commandes")
public class Commande {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;


    @Column(name = "montant")
    private Integer montant;

    @Column(name = "montant_remise")
    private Integer montantRemise;

    @Column(name = "montant_total")
    private Integer montantTotal;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "est_reduit")
    private boolean estReduit;

 /*   @Column(name = "code_coupon")
    private String codeCoupon;*/

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caisseId", nullable = false)
    private Caisse caisse;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "caissierId", nullable = false)
    private Caissier caissier;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "typePaiementId", nullable = false)
    private TypePaiement typePaiement;

}
