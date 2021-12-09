# Design Document

## Design Decisions

- We decided to use json to store Pokemon data
    - If we create all pokemon on the program, will waste lots of time

## SOLID

### SRP (Single Responsibility Principle)

- The User class is only responsible for storing a user's login information. It is separated from any gaming information. So, the User class is only changed if the login system logic is changed. Any changes in the gameplay will not affect User.
- The UserManager is only responsible for handling User objects. So, the only source of change is a change in login system logic.
- The presenter classes are only responsible for displaying messages. They contain no business logic. So, they are only changed if we want to change the displayed message. Any change to business logic will not affect the presenter classes.
- The BattleManager and BattleAction implementing classes are only responsible for executing actions in a battle. They are changed only if the major rules for a battle are changed. A change in value-related rules will not affect them since value calculations are separated into calculator classes. However, the random algorithm for opponent's action is put inside the BattleManager, craeting an extra source of change. This can be improved by extracting such algorithm into a separated class.
- The gateway classes are only responsible for reading and writing files. They contain no business logic. A specific gateway class is only responsible for one kind of data. 

### OCP (Open Closed Principle)

- e.g. all entity

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