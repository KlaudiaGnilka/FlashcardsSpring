package com.flashcardsprogram.flashcards.domain;


import org.springframework.stereotype.Service;

@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public Iterable<Flashcard> viewBookList() {
        return flashcardRepository.findAll();
    }

    public Flashcard viewFlashcardDetails(long id) {
        return flashcardRepository.findById(id).orElseThrow(() -> new FlashcardNotFoundException(id));
    }

    public Flashcard addFlashcardToRepository(Flashcard flashcard) {
        if (flashcardRepository.existsById(flashcard.getId())) {
            throw new FlashcardAlreadyExistsException(flashcard.getId());
        }
        return flashcardRepository.save(flashcard);
    }

    public void removeFlashcardFromRepository(long id) {
        flashcardRepository.deleteById(id);
    }

    public Flashcard editFlashcardDetails(long id, Flashcard flashcard) {
        return flashcardRepository.findById(id)
                .map(existingFlashcard -> {
                    var flashcardToUpdate = new Flashcard(
                            flashcard.getWordEN(),
                            flashcard.getWordIT(),
                            existingFlashcard.getId());
                    return flashcardRepository.save(flashcardToUpdate);
                })
                .orElseGet(() -> addFlashcardToRepository(flashcard));
    }

}
