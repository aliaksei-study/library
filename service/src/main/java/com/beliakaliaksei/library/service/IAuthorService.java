package com.beliakaliaksei.library.service;

import com.beliakaliaksei.library.entity.Author;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Set;

public interface IAuthorService {
    Page<Author> getPageAuthors(int page);
}
