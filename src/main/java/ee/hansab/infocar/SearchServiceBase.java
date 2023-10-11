package ee.hansab.infocar;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

public abstract class SearchServiceBase {
    protected Pageable sorting(RequestBase request, String pattern) {
        Sort sorting = Sort.unsorted();
        if (request.getSort() != null && request.getSort().matches(pattern)) {
            int directionStartingIndex = request.getSort().indexOf(':');
            boolean desc = false;
            String field = request.getSort();
            if (directionStartingIndex != -1) {
                desc = request.getSort().substring(directionStartingIndex + 1).equals("desc");
                field = request.getSort().substring(0, directionStartingIndex);
            }
            sorting = desc ? Sort.by(field).descending() : Sort.by(field).ascending();
        }
        return PageRequest.of(request.getPageNumber() - 1, request.getPageSize(), sorting);
    }

    protected static <T> Specification<T> like(String requestedValue, String fieldName) {
        return requestedValue == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(fieldName), "%" + requestedValue + "%");
    }
}
