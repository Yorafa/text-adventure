# Specification

Pokemon World is a standalone text adventure game. The player acts as a pokemon trainer who lives on the pokeland. The
player can explore the land, seek for and capture pokemons, having a pokemon battle, and so on.

## Login

The program starts with the login interface. The user can sign up a new account or log in to an existing account.

When signing up, the program asks the user for a username, a password, and a nickname. Then the program will create the
account, and enter the gameplay interface with the initial game data. If the username is not unique, the program will
ask for a username again.

When logging in, the program asks the user for a username and a password. If there is such username-password pair, then
it will enter the gameplay interface with the account's game data. Otherwise, it will ask again.

## Gameplay

### Exploring

Exploring interface is entered after logging in. The player can choose among the following actions.

- Walk around: There is some possibility of bumping into some pokemon, and if that is the case, the player would enter
  the battle interface. The possibility is determined by the current place.
- Heal pokemons: All pokemons will be healed.
- Change place: The list of all places will be shown for the player to choose from.
- View pocket: Show a list of all pokemons that the player has.
- Log out: Log out from the current account, and go back to the login interface.

### View pocket

A list of player's pokemons and their information will be shown. The player can choose the following.

- Show details: Pokemons' detailed information, including name, level, attack point, defense point, etc.
- Hide details: Only pokemons' name and level will be shown.
- Sort by name: The list will be sorted in alphabetical order of pokemons' names.
- Sort by level: The list will be sorted according to pokemons' levels.
- Change battle pokemon: The player can choose which pokemon to be set for battle.
- Back: Back to exploring.

### Battle

The battle is turn-based. At each turn, the player can perform one and only one of the following actions. Opponent's
action is randomly determined.

- Attack: Cause damage to the opponent.
- Defense: If the opponent attacks, the damage will be reduced, and the next attack by the player will do more damage.
- Heal: Player's battle pokemon will gain some hit point.
- Capture: There is a chance to capture the opponent. If successfully captured, the battle ends and the opponent will be
  added to the player's pocket.
- Escape: End the battle and return to exploring.

When the player's or the opponent's hit point is down to 0, the battle ends. If the player does not escape, then the
battle pokemon will gain some experience point.

## Game Data

All user info and their games will be saved to file. The game database (what maps there are, what pokemons there are,
etc) are written in json files. The program will read them to load the game.