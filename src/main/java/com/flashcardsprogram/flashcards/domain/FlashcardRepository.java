package com.flashcardsprogram.flashcards.domain;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlashcardRepository extends CrudRepository<Flashcard, Long> {
    Optional<Flashcard> findById(long id);

    boolean existById(long id);
    void deleteById(long id);

}
