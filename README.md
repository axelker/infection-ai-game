# Infection Game
The Infection Game is a strategic two-player game played on a 49-square grid. Each player controls pieces of a different color: blue or red. On their turn, players can either jump or clone their pieces. Any adjacent opponent pieces are "infected" and converted to the player's color. The objective is to dominate the board with the most pieces of your color.

## Features
- Game Board: 49 squares with initial pieces placed in the corners.
- AI Options: Choose between Minimax or AlphaBeta algorithms with configurable search depths.
- Dynamic Gameplay: Real-time updates of the board, displaying current and updated states.
- Endgame Display: Shows the final score, winner, nodes traversed by each player, and the AI used.

## Installation and Execution
- Environment: Developed in Java on Linux. Requires a terminal for execution.
- Compilation: Use the provided compilation.sh bash script to compile and run the game.

## How to Play
1. Run the program and choose the AI type (AlphaBeta or Minimax) and search depth.
2. The game initializes with four pieces placed in the corners.
3. Players take turns making valid moves (jump or clone), with the board updating in real time.
4. The goal is to end the game with the most pieces of your color on the board.


## Game Grid Representation
B = Blue pieces
R = Red pieces
. = Empty squares