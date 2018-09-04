package com.mat.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Color {
    @JsonProperty("red")
    RED,
    @JsonProperty("black")
    BLACK,
    @JsonProperty("white")
    WHITE
}
