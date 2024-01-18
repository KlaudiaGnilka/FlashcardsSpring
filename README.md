# Flashcards Spring
## Abouut project
Flashcards Spring is an extension of [Simple Flashcards project](https://github.com/KlaudiaGnilka/SimpleFlashcards).
This project is build in microservice architecture. It uses two microservices working on docker containers and communicating via REST. 

### Postgresql DB container
This microservice provides persistance for the application by keeping flashcards in following table:
![schema](https://github.com/KlaudiaGnilka/FlashcardsSpring/assets/134264753/1c30e687-3b87-4624-9407-612072df710e)

### Spring application container
This microservice is an extension of Simple Flashcards project build using Spring framework. User can interact with this application using following REST API endpoints (eg. for localhost on port 8080):
#### Flashcard controller
- get all flashcards - GetMapping - https://localhost8080/flashcards,
- get flashcard by id - GetMapping - https://localhost8080/flashcards/{id},
- get flashcard by English word - GetMapping - https://localhost8080/flashcards/{wordEN},
- add flashcard - PostMapping - https://localhost8080/flashcards - providing JSON representation of a flashcard,
![flashcard](https://github.com/KlaudiaGnilka/FlashcardsSpring/assets/134264753/c09a3e1c-ccc9-40bd-bd70-3d15752655c1)  
- delete flashcard - DeleteMapping - https://localhost8080/flashcards/{id},
- edit flashcard - PutMapping - https://localhost8080/flashcards/{id}

#### Puzzle Cotroller
- create puzzle - GetMapping - https://localhost8080/puzzle,
- solve puzzle - PostMapping - https://localhost8080/puzzle - providing JSON representation of a list of Strings,

#### Test Cotroller
- create test - GetMapping - https://localhost8080/test,
- solve test - PostMapping - https://localhost8080/test - providing JSON representation of a list of Strings,
