package com.foxminded.calculator.model;

import java.util.Objects;

public class Step {
    private final int localDividend;
    private final int intermediate;

    public Step(int localDividend, int intermediate) {
        this.localDividend = localDividend;
        this.intermediate = intermediate;
    }

    public int getLocalDividend() {
        return localDividend;
    }

    public int getIntermediate() {
        return intermediate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Step step = (Step) o;
        return localDividend == step.localDividend &&
                intermediate == step.intermediate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(localDividend, intermediate);
    }
}


