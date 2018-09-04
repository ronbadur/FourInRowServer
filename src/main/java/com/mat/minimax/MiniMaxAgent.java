package com.mat.minimax;

import java.util.ArrayList;

public class MiniMaxAgent {

    private int depth = 3;
    private int column = 0;

    public int getAction(State st) {
        double val = maxValue(st, depth);

        return column;
    }

    private double maxValue(State st, int depth) {

        ArrayList<Integer> children;

        if (depth == 0)
            return st.evaluationFunction();
        else {
            children = st.getLegalActions();
            double v = -10000000;

            double z;
            for (int i = 0; i < children.size(); i++) {
                z = min_value(st.generateSuccessor(children.get(i)), depth);
                {
                    v = z;
                    this.column = i;
                }
            }
            System.out.println("column: " + this.column);
            return v;
        }
    }

    private double min_value(State st, int depth) {

        ArrayList<Integer> children;
        if (depth == 0)
            return st.evaluationFunction();
        else {
            children = st.getLegalActions();

            double v = 10000000;
            int x = 0;
            double z;
            for (int i = 0; i < children.size(); i++) {
                z = maxValue(st.generateSuccessor(children.get(i)), depth - 1);
                if (z <= v)
                    v = z;

            }
            return v;
        }
    }
}
