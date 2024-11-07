# Tic Tac Toe Game

A simple console-based Tic Tac Toe game implemented in Java. The game includes functionality for a player to compete against the computer. The board size is customizable, allowing for various configurations beyond the classic 3x3 grid.

## Features

- **Player vs. Computer Mode**: Option to play against an AI that can block player wins and attempt to win.
- **Player Choice Prompt**:
   - At the start of the game, the player is prompted to enter whether they want to go first or second.
   - If the player chooses to go first, they play as `X`, and the computer plays as `O`.
   - If the player chooses to go second, the computer plays as `X`, and the player plays as `O`.
- **Variable-Sized Grid**: Ability to set custom board sizes (e.g., 3x3, 4x4, etc.) for a new game experience.
- **Win Checking Logic**: Dynamic checking for win conditions based on the board size, supporting rows, columns, and both diagonals.
- **Draw Detection**: Detects when the game ends in a draw if all cells are filled without any winner.


## Game Rules

1. Player and computer alternate turns, placing their symbol in an empty cell.
2. A player wins by getting their symbols in a continuous line across a row, column, or diagonal.
3. If the grid is filled and no player has met the win condition, the game ends in a draw.
