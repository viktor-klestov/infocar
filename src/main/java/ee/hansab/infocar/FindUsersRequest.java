package ee.hansab.infocar;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class FindUsersRequest extends RequestBase {
    private String name;
}
