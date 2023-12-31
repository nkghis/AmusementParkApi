package ci.ics.amusementparkapi.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "categories" , //
        uniqueConstraints = { //
                @UniqueConstraint(name = "CATEGORIE_UK",columnNames = "type") })
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "type", unique = true)
    private String type;

    @Column(name = "description")
    private String description;
}
