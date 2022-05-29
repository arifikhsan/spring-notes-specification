package com.example.springnotesspecification.database;

import com.example.springnotesspecification.entity.NoteEntity;
import com.example.springnotesspecification.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class NoteSeeder {
    private final NoteRepository repository;

    public void seed() {
        repository.save(new NoteEntity("Note 1", "arif", 1));
        repository.save(new NoteEntity("Note 2", "ikhsan", 2));
        repository.save(new NoteEntity("Note 3", "udin", 2));
    }
}
