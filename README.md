# Minesweeper
 A minesweeper lookalike game in Java (console app).

 ## Description

 Minesweeper is a single-player puzzle video game. The objective of the game is to clear a rectangular board containing hidden "mines" or bombs without detonating any of them, with help from clues about the number of neighboring mines in each field. The game originates from the 1960s, and it has been written for many computing platforms in use today. It has many variations and offshoots.

Some versions of Minesweeper will set up the board by never placing a mine on the first square revealed. Minesweeper for versions of Windows protects the first square revealed; from Windows Vista onward, players may elect to replay a board, in which the game is played by revealing squares of the grid by clicking or otherwise indicating each square. If a square containing a mine is revealed, the player loses the game. If no mine is revealed, a digit is instead displayed in the square, indicating how many adjacent squares contain mines; if no mines are adjacent, the square becomes blank, and all adjacent squares will be recursively revealed. The player uses this information to deduce the contents of other squares and may either safely reveal each square or mark the square as containing a mine.

## What's different in this Minesweeper implementation

1) Mine positioning: mines can be placed in such a way that an empty block can have more than 4 mines in the neighbour spots (in the original game the maximum number is 4).
2) Hitting a spot with zero neighbouring mines won't reveal other spots, like it happens in the original game.
3) The player finishes the game when he has revealed every spot that doesn't have a mine, without hitting a mine in the process. The points are originally set to the number of mines there are on the minefield and the player gets +1 point each time he marks a mine successfully and -1 point when he marks a spot where there is no mine.

## Instructions

1) Download the file in the repository.
2) Compile using the command "javac Minesweeper.java".
3) Run the game using the command "java Minesweeper".
4) Instructions will ensue in the terminal. In general:
   i) You type "R" seperated by a space from a number which represents the row and another space-seperated number which represents the column in order to hit a space (R is for risky), or "F" followed by the numbers, to flag a spot.
   ii) The result will ensue in the command line, which prints your player board after every move.