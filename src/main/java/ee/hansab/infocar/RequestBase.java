package ee.hansab.infocar;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestBase {
    private String sort;
    private int pageNumber = 1;
    private int pageSize = 10;
}
