package com.beliakaliaksei.library.controller;

import com.beliakaliaksei.library.dto.AuthorDto;
import com.beliakaliaksei.library.entity.Author;
import com.beliakaliaksei.library.entity.Reader;
import com.beliakaliaksei.library.exception.AuthorNotFoundException;
import com.beliakaliaksei.library.service.IAuthorService;
import com.beliakaliaksei.library.util.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
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
    public Page<Author> getAuthors(@RequestParam (defaultValue = "0") int page) {
        return authorService.getPageAuthors(page);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewAuthor(@Valid @RequestBody AuthorDto authorDto) {
        authorService.saveNewAuthor(Mapper.map(authorDto, Author.class));
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Author getAuthorById(@PathVariable("id") Long id) throws AuthorNotFoundException {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateAuthor(@PathVariable("id") Long id, @Valid @RequestBody AuthorDto authorDto) {
        authorService.updateAuthor(Mapper.map(authorDto, Author.class), id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAuthors(@PathVariable("id") List<Long> authorIds) throws AuthorNotFoundException {
        authorService.deleteAuthors(authorIds);
    }

}
