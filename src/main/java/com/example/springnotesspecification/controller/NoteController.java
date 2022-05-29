package com.example.springnotesspecification.controller;

import com.example.springnotesspecification.entity.NoteEntity;
import com.example.springnotesspecification.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.example.springnotesspecification.specifications.NoteSpecification.*;
import static org.springframework.data.jpa.domain.Specification.where;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/notes")
public class NoteController {
    private final NoteService service;

    @GetMapping
    public Page<NoteEntity> getNotes(Pageable pageable) {
        return service.findAll(pageable);
    }

    @GetMapping("search")
    public Page<NoteEntity> searchNotes(Pageable pageable, @RequestParam("query") String query) {
        var specifications = where(hasPriority(2)).and(hasTitleLike(query).or(hasContentLike(query)));
        return service.findAll(specifications, pageable);
    }
}
