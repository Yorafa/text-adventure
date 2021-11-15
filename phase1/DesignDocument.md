# Design Document

- see [specification](https://github.com/CSC207-UofT/course-project-jerry-text-adventure/blob/main/phase1/specification.md)
- So far, we have implemented registration and login, as well as logout in the game
- At the same time, you can now fight in the game

In the future,

- We will design an opening to let players better understand how to play this game
- We will provide a few initial Pokemon for players to choose
- The game will no longer be so monotonous, there will be more random events, Pokemon and maps

## Design Decisions

- We decided to use json to store Pokemon data
  - If we create all pokemon on the program, will waste lots of time

## SOLID
- SRP (Single Responsibility Principle)
  - e.g.
- OCP (Open Closed Principle)
  - e.g. all private attribute
- LSP (Liskov Substitution Principle)
  - e.g. BasePokemon and Pokemon
- ISP (Interface Segregation Principle)
  - we do not write lots of interface and also do not force class to implement those interface
- DIP (Dependency Inversion Principle)
  - UI depend on DAO, DAO depend on base

## Clean Architecture

- Inner layers do not depend on outer layers
- Controller/Presenter/Gateway does not depends on Entity

## Packaging Strategies

- depend on architecture
  - Clearer and more intuitive

## Design Pattern

- Factory pattern
- Memento pattern
