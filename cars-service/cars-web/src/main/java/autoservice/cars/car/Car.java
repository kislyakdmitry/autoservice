package autoservice.cars.car;

import autoservice.cars.common.GenericEntity;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@Table(name = "cars")
@Data
@EqualsAndHashCode(callSuper = true)
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Car extends GenericEntity<Long> {
    @Id
    @SequenceGenerator(name = "cars_id_seq", sequenceName = "cars_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cars_id_seq")
    private Long id;

    private String name;
    private BigDecimal price;
    private Boolean available;

    private String vin;
}
