package frameworks.detection_of_signs;

import java.util.HashSet;
import java.util.Set;

import frameworks.ILaticeValue;
import frameworks.Util;

public class DSLaticeValue implements ILaticeValue {
	// TODO(TP): Change to BitVector
	private Set<Signs> signs;

	public DSLaticeValue() {
		this.signs = new HashSet<Signs>();
	}

	public DSLaticeValue(Set<Signs> signs) {
		this.signs = signs;
	}

	public DSLaticeValue(Signs sign) {
		Set<Signs> value = new HashSet<Signs>();
		value.add(sign);
		this.signs = value;
	}

	/**
	 * Is this a subset of PARAM
	 */
	@Override
	public boolean isSubset(ILaticeValue obj) {
		DSLaticeValue other = (DSLaticeValue) obj;
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
	public boolean isEqual(ILaticeValue obj) {
		if (!(obj instanceof DSLaticeValue)) {
			return false;
		}

		DSLaticeValue other = (DSLaticeValue) obj;
		return this.signs.equals(other.signs);
	}

	@Override
	public ILaticeValue join(ILaticeValue obj) {
		DSLaticeValue other = (DSLaticeValue) obj;
		return new DSLaticeValue(Util.Union(signs, other.signs));
	}
}
