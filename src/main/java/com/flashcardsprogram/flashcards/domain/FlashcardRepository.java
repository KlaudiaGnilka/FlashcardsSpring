package com.flashcardsprogram.flashcards.domain;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {
    Optional<Flashcard> findByWordEN(String wordEN);

    boolean existsByWordEN(String wordEN);

    boolean existsByWordIT(String wordIT);

}
