package com.mat.minimax;

import com.mat.enums.Color;
import com.mat.models.GameBoard;

import java.util.ArrayList;

public class State implements Cloneable
{
    private GameBoard gameBoard;

    public State(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    /* returns a list of actions that can be taken from the current state
        actions are integers representing the column where a coin can be dropped */
    public ArrayList<Integer> getLegalActions(){
        ArrayList<Integer> actions= new ArrayList<>();
        for(int j=0; j<this.gameBoard.getGrid().length; j++)
            if(this.gameBoard.getGrid()[0][j].getColor().toString().toLowerCase().equals("white")){
                actions.add(j);
            }
        return actions;
    }

    /* returns a State object that is obtained by the agent (parameter)
    performing an action (parameter) on the current state */
    public State generateSuccessor(int action) {

        int row;
        for(row = 0; row < 4 && !this.gameBoard.getGrid()[row][action].getColor().toString().equalsIgnoreCase("red") &&
                              !this.gameBoard.getGrid()[row][action].getColor().toString().equalsIgnoreCase("black"); row++);

        if (row == 0) {
            this.gameBoard.getGrid()[row][action].setColor(Color.BLACK);
        } else {
            this.gameBoard.getGrid()[row-1][action].setColor(Color.BLACK);
        }

        return this;
    }

    /* returns True/False if the agent(parameter) has won the game
    by checking all rows/columns/diagonals for a sequence of >=4 */
    public boolean isGoal(Color color){

        // horizontal check
        for (int i = 0; i < gameBoard.getGrid().length; i++ ) {
            for (int j = 0; j < gameBoard.getGrid()[0].length - 3; j++) {
                if (gameBoard.getGrid()[i][j].getColor().equals(color) && gameBoard.getGrid()[i][j + 1].getColor().equals(color) &&
                        gameBoard.getGrid()[i][j + 2].getColor().equals(color) && gameBoard.getGrid()[i][j + 3].getColor().equals(color)) {
                    return true;
                }
            }
        }

        // vertical check
        for (int j = 0; j < gameBoard.getGrid()[0].length; j++ ) {
            for (int i = 0; i < gameBoard.getGrid().length - 3; i++) {
                if (gameBoard.getGrid()[i][j].getColor().equals(color) && gameBoard.getGrid()[i + 1][j].getColor().equals(color) &&
                        gameBoard.getGrid()[i + 2][j].getColor().equals(color) && gameBoard.getGrid()[i + 3][j].getColor().equals(color)) {
                    return true;
                }
            }
        }

        // ascending diagonal check
        for (int i = 3; i < gameBoard.getGrid().length; i++) {
            for (int j = 0; j < gameBoard.getGrid()[0].length - 3; j++) {
                if (gameBoard.getGrid()[i][j].getColor().equals(color) && gameBoard.getGrid()[i - 1][j + 1].getColor().equals(color) &&
                        gameBoard.getGrid()[i - 2][j + 2].getColor().equals(color) && gameBoard.getGrid()[i - 3][j + 3].getColor().equals(color)) {
                    return true;
                }
            }
        }

        // descending diagonal check
        for (int i = 3; i < gameBoard.getGrid().length; i++) {
            for (int  j = 3; j < gameBoard.getGrid()[0].length; j++) {
                if (gameBoard.getGrid()[i][j].getColor().equals(color) && gameBoard.getGrid()[i - 1][j - 1].getColor().equals(color) &&
                        gameBoard.getGrid()[i - 2][j - 2].getColor().equals(color) && gameBoard.getGrid()[i - 3][j - 3].getColor().equals(color)) {
                    return true;
                }
            }
        }

        return false;
    }


    /* returns the value of each state for minimax to min/max over at
    zero depth. Right now it's pretty trivial, looking for only goal states.
    (This would be perfect for infinite depth minimax. Not so great for d=2) */
    public double evaluationFunction(){

        if (this.isGoal(Color.BLACK))
            return 1000.0;
        if (this.isGoal(Color.RED))
            return -1000.0;

        return 0.0;
    }
}