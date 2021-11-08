# Specification

Pokemon World is a standalone text adventure game. The player acts as a pokemon trainer who lives 
on the pokeland. The player can explore the land, seek for and capture pokemons, 
having a pokemon battle, and so on.

## Login

The program starts with the login interface. The user can sign up a new account or log in to an 
existing account. 

When signing up, the program asks the user for a username, a password, and a 
nickname. Then the program will create the account, and enter the gameplay interface 
with the initial game data. If the username is not unique, the program will ask 
for a username again.

When logging in, the program asks the user for a username and a password. If there is such 
username-password pair, then it will enter the gameplay interface with the account's 
game data. Otherwise, it will ask again.

## Gameplay

### Exploring

Exploring interface is entered after logging in. 
The player can choose among the following actions.

- Walk around: There is some possibility of bumping into some pokemon, and if that is the case, 
the player would enter the battle interface. The possibility is determined by the current place.
- Change place: The list of all places will be shown for the player to choose from.
- Browse pokemons: Show a list of all pokemons that the player has.
- Log out: Log out from the current account, and go back to the login interface.

### Battle

The battle is turn-based.  The pokemon with a higher speed starts the 
turn first. At each turn, the player can perform one of the following actions.

- Attack
- Defence
- Capture
- Change pokemon
- Escape

## Basic Classes and Attributes

### Account

- **Username**: distinct accounts must have distinct usernames
- **Password**
- **Nickname**
- **Game data**

### Trainer

- **Pokemons**: pokemons that the trainer owns
- **Backpack**: items that the trainer owns

### Pokemon

- **Level**
- **Health**: 
- **Attack**: 
- **Defence**: 
- **Speed**: 
- **Type**: grass, water, fire...

