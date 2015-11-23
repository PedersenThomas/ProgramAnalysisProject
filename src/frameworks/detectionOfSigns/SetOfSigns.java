package frameworks.detectionOfSigns;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SetOfSigns {

	private final Set<Signs> signs;

	public SetOfSigns() {
		this.signs = new HashSet<Signs>();
	}

	public SetOfSigns(Set<Signs> signs) {
		this.signs = signs;
	}

	public SetOfSigns(Signs sign) {
		Set<Signs> value = new HashSet<Signs>();
		value.add(sign);
		this.signs = value;
	}

    public Set<Signs> getSigns() {
        return Collections.unmodifiableSet(signs);
    }

	public boolean isEmpty() {
        return signs.isEmpty();
    }

    public boolean isSubset(SetOfSigns other) {
		// Checks if all elements of "this" is in others.
		for (Signs sign : this.signs) {
			if (!other.signs.contains(sign)) {
				return false;
			}
		}

		return true;
	}

	public boolean equals(Object other) {
        if (!(other instanceof SetOfSigns)) {
            return false;
        }
        SetOfSigns otherPowerSetOfSigns =
                (SetOfSigns) other;
		return this.signs.equals(otherPowerSetOfSigns.signs);
	}

	public SetOfSigns union(SetOfSigns other) {
		return new SetOfSigns(Util.Union(signs, other.signs));
	}

	public String toString() {
		return "{" + Util.join(signs, " ") + "}";
	}
}
