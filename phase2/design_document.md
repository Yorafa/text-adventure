# Design Document

## Design Decisions

- We decided to use json to store Pokemon data
    - If we create all pokemon on the program, will waste lots of time

## SOLID

### SRP (Single Responsibility Principle)

- We make lots of classes only deal with one job
  - separate attack, defend, capture, heal, escape

### OCP (Open Closed Principle)

- e.g. all private attribute
- 
### LSP (Liskov Substitution Principle)

- e.g. BasePokemon and Pokemon
- 
### ISP (Interface Segregation Principle)

- we do not write lots of interface and also do not force class to implement those interface
- 
### DIP (Dependency Inversion Principle)

- UI depend on DAO, DAO depend on base


## Clean Architecture

- Inner layers do not depend on outer layers
- Controller/Presenter/Gateway does not depends on Entity

## Design Pattern

- State
  - Different Panel connect
- Simple factory
  - produce new pokemon
- Strategy
- Memento
  - Save and Load

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