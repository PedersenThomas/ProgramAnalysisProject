package frameworks.detectionOfSigns;

public enum Signs {
    negative,
	zero,
	positive;

	public String toString() {
        switch (this.name()) {
            case "negative":
                return "-";
            case "zero":
                return "0";
            case "positive":
                return "+";
            default:
                throw new IllegalArgumentException("Unknown sign.");
        }
    }
}
