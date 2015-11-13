package frameworks.detectionOfSigns;

import java.util.HashSet;
import java.util.Set;

import frameworks.ILatticeValue;

public class PowerSetOfSigns {
	private Set<Signs> signs;

	public PowerSetOfSigns() {
		this.signs = new HashSet<Signs>();
	}

	public PowerSetOfSigns(Set<Signs> signs) {
		this.signs = signs;
	}

	public PowerSetOfSigns(Signs sign) {
		Set<Signs> value = new HashSet<Signs>();
		value.add(sign);
		this.signs = value;
	}

	public boolean isSubset(PowerSetOfSigns other) {
		// Checks if all elements of "this" is in others.
		for (Signs sign : this.signs) {
			if (!other.signs.contains(sign)) {
				return false;
			}
		}

		return true;
	}

	public boolean equals(Object other) {
        if (!(other instanceof PowerSetOfSigns)) {
            return false;
        }
        PowerSetOfSigns otherPowerSetOfSigns =
                (PowerSetOfSigns) other;
		return this.signs.equals(otherPowerSetOfSigns.signs);
	}

	public PowerSetOfSigns union(PowerSetOfSigns other) {
		return new PowerSetOfSigns(Util.Union(signs, other.signs));
	}

	public String toString() {
		return "{" + Util.join(signs, " ") + "}";
	}
}
