package frameworks.detectionOfSigns;

public enum Signs {
    negative,
	zero,
	positive;

	public String toString() {
        if (name().equals("negative")) {
            return "-";
        } else if (name().equals("zero")) {
            return "0";
        } else {
            return "+";
        }
    }
}
