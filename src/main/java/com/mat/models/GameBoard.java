package com.mat.models;

import java.io.Serializable;

public class GameBoard implements Serializable{

    private Cell[][] grid = new Cell[5][7];

    public GameBoard() {
    }

    public GameBoard(Cell[][] grid) {
        this.grid = grid;
    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }
}
