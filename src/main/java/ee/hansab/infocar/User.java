package ee.hansab.infocar;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "\"user\"")
public class User {
    @Id
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(name = "user_car", inverseJoinColumns = @JoinColumn(name = "car_id"))
    private List<Car> cars;
}