# Design Document

## Design Decisions

- We decided to use json to store Pokemon data
    - If we create all pokemon on the program, will waste lots of time

## SOLID

### SRP (Single Responsibility Principle)

- We make lots of classes only deal with one job
    - separate attack, defend, capture, heal, escape

### OCP (Open Closed Principle)

- e.g. all entity
-

### LSP (Liskov Substitution Principle)

- e.g. BasePokemon and Pokemon

### ISP (Interface Segregation Principle)

- we do write necessary interface and only implement interface when the class exactly need.

### DIP (Dependency Inversion Principle)

- Shell UI as controller and presenters depend on use case, and use cases depend on entities.

## Clean Architecture

- Inner layers do not depend on outer layers
- Controller/Presenter/Gateway does not depends on Entity

## Design Pattern

- Iterator
    - Pokemon in pocket can iterate
    - ![Preview](https://github.com/CSC207-UofT/course-project-jerry-text-adventure/blob/main/phase2/img/Iterator%20Design%20UML.png?raw=true)
- State
    - Different Panel connect
- Simple factory
    - produce new pokemon
    - ![Preview](https://github.com/CSC207-UofT/course-project-jerry-text-adventure/blob/main/phase2/img/Simple%20Factory%20Design%20UML.png?raw=true)
- Strategy
- Memento
    - Save and Load
    - ![Preview](https://github.com/CSC207-UofT/course-project-jerry-text-adventure/blob/main/phase2/img/Memento%20Design%20UML.png?raw=true)

## Use of GitHub Features

- assign work and create branch onto group member name path
- Pull Request Peer Review

## Code Style and Documentation

- Enough javadoc explains most of the classes

## Testing

- Testing for Entity and some use cases
    - The core part of program

## Refactoring

- rename some class
- change location of some path

## Code Organization

- we classify and package our class by architecture
    - Easy to organize and have a clean structure to go on

## Functionality