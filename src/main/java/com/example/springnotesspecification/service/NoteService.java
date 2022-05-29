package com.example.springnotesspecification.service;

import com.example.springnotesspecification.entity.NoteEntity;
import com.example.springnotesspecification.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository repository;

    public Page<NoteEntity> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<NoteEntity> findAll(Specification<NoteEntity> specification, Pageable pageable) {
        return repository.findAll(specification, pageable);
    }
}
