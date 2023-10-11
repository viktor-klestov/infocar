package ee.hansab.infocar;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Car {
    @Id
    private Long id;
    private String make;
    private String model;
    private String numberplate;
}
