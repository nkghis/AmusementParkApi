package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "coupons", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "COUPON_UK",columnNames = "code") })
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "pourcentage")
    private Integer pourcentage;

    @Column(name = "statut")
    private boolean statut;

    @Override
    public String toString() {
        if (statut){
            return "UTILISE";
        }else {
            return "INUTILISE";
        }

    }
}
