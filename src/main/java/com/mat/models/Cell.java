package com.mat.models;

import com.mat.enums.Color;

import java.io.Serializable;

public class Cell implements Serializable {

    private Integer row;
    private Integer column;
    private Color color;

    public Cell() {
    }

    public Cell(Integer row, Integer column, Color color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }

    public Integer getRow() {
        return row;
    }

    public void setRow(Integer row) {
        this.row = row;
    }

    public Integer getColumn() {
        return column;
    }

    public void setColumn(Integer column) {
        this.column = column;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
