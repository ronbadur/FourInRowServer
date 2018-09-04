package com.mat.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RoundResult {

    private GameBoard gameBoard = new GameBoard();
    @JsonProperty("isCellGotColored")
    private boolean isCellGotColored = false;

    public RoundResult() {
    }

    public RoundResult(GameBoard gameBoard, boolean isCellGotColored) {
        this.gameBoard = gameBoard;
        this.isCellGotColored = isCellGotColored;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean geIsCellGotColored() {
        return isCellGotColored;
    }

    public void setIsCellGotColored(boolean isCellGotColored) {
        this.isCellGotColored = isCellGotColored;
    }
}
