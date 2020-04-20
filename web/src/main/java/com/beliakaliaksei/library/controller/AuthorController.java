package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.AuthorDto;
import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.service.IAuthorService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final IAuthorService authorService;

    @Autowired
    public AuthorController(IAuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping
    public List<Author> showAuthors() {
        return authorService.getAll();
    }

    @PostMapping
    public void saveNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        authorService.addNewAuthor(Mapper.map(authorDto, Author.class));
    }


}
