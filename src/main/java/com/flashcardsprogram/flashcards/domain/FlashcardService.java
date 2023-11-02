package com.flashcardsprogram.flashcards.domain;


import org.springframework.stereotype.Service;

@Service
public class FlashcardService {

    private final FlashcardRepository flashcardRepository;

    public FlashcardService(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    public Iterable<Flashcard> viewFlashcardList() {
        return flashcardRepository.findAll();
    }

    public Flashcard viewFlashcardDetailsById(long id) {
        return flashcardRepository.findById(id).orElseThrow(() -> new FlashcardNotFoundException(id));
    }

    public Flashcard viewFlashcardDetailsByWordEn(String wordEN){
        return flashcardRepository.findByWordEN(wordEN).orElseThrow(() -> new FlashcardNotFoundException(wordEN));
    }

    public Flashcard addFlashcardToRepository(Flashcard flashcard) {
        if(flashcardRepository.existsByWordEN(flashcard.getWordEN())
                && flashcardRepository.existsByWordIT(flashcard.getWordIT())){
            throw new FlashcardAlreadyExistsException(flashcard);
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
                            existingFlashcard.getId(),
                            flashcard.getWordEN(),
                            flashcard.getWordIT());
                    return flashcardRepository.save(flashcardToUpdate);
                })
                .orElseGet(() -> addFlashcardToRepository(flashcard));
    }

}
