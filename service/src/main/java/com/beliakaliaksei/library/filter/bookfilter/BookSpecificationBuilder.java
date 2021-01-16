package com.beliakaliaksei.library.filter.bookfilter;

import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.filter.SearchCriteria;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookSpecificationBuilder {
    private final List<SearchCriteria> params;

    public BookSpecificationBuilder() {
        params = new ArrayList<>();
    }

    public BookSpecificationBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }

    public Specification<Book> build() {
        if (params.size() == 0) {
            return null;
        }

        List<Specification<Book>> specs = params.stream()
                .map(BookSpecification::new)
                .collect(Collectors.toList());

        Specification<Book> result = specs.get(0);

        for (int i = 1; i < params.size(); i++) {
            result = Specification.where(result)
                    .and(specs.get(i));
        }
        return result;
    }
}
