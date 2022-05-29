package com.example.springnotesspecification.specifications;

import com.example.springnotesspecification.entity.NoteEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import static com.example.springnotesspecification.entity.BaseEntity_.ID;
import static com.example.springnotesspecification.entity.NoteEntity_.*;

@Component
public class NoteSpecification {
    public static Specification<NoteEntity> hasTitleLike(String title) {
        return (root, query, builder) -> builder.like(builder.lower(root.get(TITLE)), "%" + title.toLowerCase() + "%");
    }

    public static Specification<NoteEntity> hasContentLike(String content) {
        return (root, query, builder) -> builder.like(builder.lower(root.get(CONTENT)), "%" + content.toLowerCase() + "%");
    }

    public static Specification<NoteEntity> hasId(Long id) {
        return (root, query, builder) -> builder.equal(root.get(ID), id);
    }

    public static Specification<NoteEntity> hasPriority(Integer priority) {
        return (root, query, builder) -> builder.equal(root.get(PRIORITY), priority);
    }
}
