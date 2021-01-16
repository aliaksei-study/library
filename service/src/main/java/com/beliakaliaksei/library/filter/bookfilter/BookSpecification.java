package com.beliakaliaksei.library.filter.bookfilter;

import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Book;
import com.beliakaliaksei.library.entity.enumeration.Genre;
import com.beliakaliaksei.library.filter.SearchCriteria;
import com.beliakaliaksei.library.entity.Author_;
import com.beliakaliaksei.library.entity.Book_;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.sql.Date;

@Data
public class BookSpecification implements Specification<Book> {
    private SearchCriteria criteria;

    public BookSpecification(SearchCriteria criteria) {
        this.criteria = criteria;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
        if (criteria.getOperation().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                    root.get(criteria.getKey()), criteria.getValue().toString());
        }
        else if (criteria.getOperation().equalsIgnoreCase(":")) {
            if(criteria.getKey().equals("name")) {
                Join<Book, Author> bookAuthors = root.join(Book_.authors);
                return criteriaBuilder.like(bookAuthors.get(Author_.name), "%" + criteria.getValue() + "%");
            } else if(criteria.getKey().equals("genre")) {
                return criteriaBuilder.equal(root.get(criteria.getKey()), Genre.valueOf((String) criteria.getValue()));
            } else if(criteria.getKey().equals("publicationDate")) {
                return criteriaBuilder.equal(root.get(criteria.getKey()), Date.valueOf((String) criteria.getValue()));
            } else {
                if (root.get(criteria.getKey()).getJavaType() == String.class) {
                    return criteriaBuilder.like(
                            root.get(criteria.getKey()), "%" + criteria.getValue() + "%");
                } else {
                    return criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue());
                }
            }
        }
        return null;
    }
}
