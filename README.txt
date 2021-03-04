
I have made four classes :
1)TicTacToe: This class contain main function.

2)Player : To instantiate object players for game.

3)HumanVsHuman : This class is instantiated when game is played between two human players.This class includes all the variables and methods required when game is played between two players.

4)HumanVsComputer: This class is instantiated when game is played between human and computer.This class include all the variables and methods required when player plays with computer.I used MINIMAX 					ALG0RITHM for the optimal move of computer.


HumanVsHuman class contain following methods:
a)printBoard
b)checkWinner

HumanVsComputer class contain some extra methods.It inherits methods and variables from class HumanVsHuman to avoid repeation of code(printBoard and checkWinner method is common in both class ).
a)computerTurn: Responsible for the move computer.
b)maxmini: This method contains whole algorithm for the optimal move of computer.
c)movesLeft: decides if there are positions left for computer's turn.

In main method , I asked the user to choose to another player, either it will be computer or another person. Depending on the  selection of second player we have different classes. It takes input from user to place crosses and noughts. It will continue to take input till one player is not winner or each position is not filled.



