package com.mat.models;

public class Round {

    private GameBoard gameBoard;
    private Integer column;
    private String color;

    public Round() {
    }

    public Round(GameBoard gameBoard, Integer column, String color) {
        this.gameBoard = gameBoard;
        this.column = column;
        this.color = color;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
