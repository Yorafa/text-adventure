# Design Document

## Design Decisions

- We decided to use json to store Pokemon data
    - If we create all pokemon on the program, will waste lots of time

## SOLID

### SRP (Single Responsibility Principle)

We first identify some sources of change. The login system may be changed,

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
  - s
- Simple factory
- Strategy

## Use of GitHub Features

## Code Style and Documentation

## Testing

## Refactoring

## Code Organization

## Functionality