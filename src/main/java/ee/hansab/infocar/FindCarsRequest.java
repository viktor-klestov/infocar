package ee.hansab.infocar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindCarsRequest extends RequestBase {
    private String make;
    private String model;
    private String numberplate;
}
