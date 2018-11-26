package com.company.exo2;

import java.io.Serializable;

public class Signal implements Serializable {
    private int n;
    public Signal(int i) {
        n = i;
    }
    public int getN() {
        return n;
    }
}
