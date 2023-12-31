package ee.hansab.infocar;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
public class CarController {
    private final CarService service;

    @GetMapping("/cars")
    public Collection<Car> find(FindCarsRequest request) {
        return service.find(request);
    }

    @GetMapping("/cars/{id}")
    public Car findById(@PathVariable long id) {
        return service.findById(id);
    }

    @GetMapping("/users/{userId}/cars")
    public Collection<Car> findByUser(@PathVariable long userId) {
        return service.findByUser(userId);
    }
}