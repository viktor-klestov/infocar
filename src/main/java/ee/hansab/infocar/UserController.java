package ee.hansab.infocar;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    @GetMapping
    public Collection<User> findUsers(FindUsersRequest request) {
        log.debug("ping");
        return service.find(request);
    }

    @GetMapping("{id}")
    public User findUserById(@PathVariable long id) {
        return service.findById(id);
    }
}
