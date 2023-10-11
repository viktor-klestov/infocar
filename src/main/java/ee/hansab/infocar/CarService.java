package ee.hansab.infocar;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class CarService extends SearchServiceBase {
    private final static String SORTING_PATTERN = "^(make|model|numberplate)(:asc|:desc)?$";
    private final CarRepository repository;

    public Collection<Car> find(FindCarsRequest request) {
        return repository.findAll(specification(request), sorting(request, SORTING_PATTERN)).toList();
    }

    public Car findById(long id) {
        return repository.findById(id).orElseThrow();
    }

    public Collection<Car> findByUser(long userId) {
        return repository.findByUserId(userId);
    }

    private static Specification<Car> specification(FindCarsRequest request) {
        return Specification.allOf(
                like(request.getMake(), "make"),
                like(request.getModel(), "model"),
                like(request.getNumberplate(), "numberplate"));
    }

}
