package frameworks.detection_of_signs;

import java.util.HashSet;
import java.util.Set;

import frameworks.ILatticeValue;
import frameworks.Util;

public class DSLatticeValue implements ILatticeValue {
	private Set<Signs> signs;

	public DSLatticeValue() {
		this.signs = new HashSet<Signs>();
	}

	public DSLatticeValue(Set<Signs> signs) {
		this.signs = signs;
	}

	public DSLatticeValue(Signs sign) {
		Set<Signs> value = new HashSet<Signs>();
		value.add(sign);
		this.signs = value;
	}

	/**
	 * Is this a subset of PARAM
	 */
	@Override
	public boolean isSubset(ILatticeValue obj) {
		DSLatticeValue other = (DSLatticeValue) obj;
		// The signs is stored as sets, so if "this" has more elements
		// than other then it is not a subset for sure.
		if (this.signs.size() > other.signs.size()) {
			return false;
		}

		// Checks if all elements of "this" is in others.
		for (Signs sign : signs) {
			if (!other.signs.contains(sign)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean isEqual(ILatticeValue obj) {
		if (!(obj instanceof DSLatticeValue)) {
			return false;
		}

		DSLatticeValue other = (DSLatticeValue) obj;
		return this.signs.equals(other.signs);
	}

	@Override
	public ILatticeValue join(ILatticeValue obj) {
		DSLatticeValue other = (DSLatticeValue) obj;
		return new DSLatticeValue(Util.Union(signs, other.signs));
	}
	
	@Override
	public String toString() {
		return Util.join(signs, " ");
	}
}
