package ee.hansab.infocar;


import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService extends SearchServiceBase {
    private final static String SORTING_PATTERN = "^name(:asc|:desc)?$";
    private final UserRepository repository;

    @Transactional
    public Collection<User> find(FindUsersRequest request) {
        return repository.findAll(specification(request), sorting(request, SORTING_PATTERN)).toList();
    }

    public User findById(long id) {
        return repository.findById(id).orElseThrow();
    }

    private static Specification<User> specification(FindUsersRequest request) {
        return like(request.getName(), "name");
    }
}
