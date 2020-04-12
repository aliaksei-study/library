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

    @GetMapping("/all")
    public List<Author> showAuthors() {
        return authorService.getAll();
    }

    @GetMapping("/allAuthors")
    public List<Author> showAuthorsFromList() {
        return authorService.getAllFromList();
    }

    @PostMapping("/add")
    public void addAuthorToList(@Valid @RequestBody AuthorDto authorDto) {
        authorService.addNewAuthorToList(Mapper.map(authorDto, Author.class));
    }

    @PostMapping("/save")
    public void saveAuthorToDatabase(@Valid @RequestBody AuthorDto authorDto) {
        authorService.addNewAuthor(Mapper.map(authorDto, Author.class));
    }


}
