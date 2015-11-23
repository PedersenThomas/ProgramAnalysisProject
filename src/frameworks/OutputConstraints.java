package frameworks;

public class OutputConstraints {

    private int outputConstraintIndex;
    private int trueConstraintIndex;
    private int falseConstraintIndex;

    public OutputConstraints() {
        this.outputConstraintIndex = -1;
        this.trueConstraintIndex = -1;
        this.falseConstraintIndex = -1;
    }

    public int getOutputConstraintIndex() {
        return outputConstraintIndex;
    }

    public void setOutputConstraintIndex(int outputConstraintIndex) {
        this.outputConstraintIndex = outputConstraintIndex;
        this.trueConstraintIndex = -1;
        this.falseConstraintIndex = -1;
    }

    public int getTrueConstraintIndex() {
        return trueConstraintIndex;
    }

    public void setTrueConstraintIndex(int trueConstraintIndex) {
        this.outputConstraintIndex = -1;
        this.trueConstraintIndex = trueConstraintIndex;
    }

    public int getFalseConstraintIndex() {
        return falseConstraintIndex;
    }

    public void setFalseConstraintIndex(int falseConstraintIndex) {
        this.outputConstraintIndex = -1;
        this.falseConstraintIndex = falseConstraintIndex;
    }

    @Override
    public String toString() {
        return "[outputIndex=" + outputConstraintIndex +
                ", trueIndex=" + trueConstraintIndex +
                ", falseIndex=" + falseConstraintIndex + "]";
    }
}
