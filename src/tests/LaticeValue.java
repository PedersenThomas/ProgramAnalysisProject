package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import frameworks.detectionOfSigns.DSLatticeValue;
import frameworks.detectionOfSigns.Signs;

public class LaticeValue {

	@Test
	public void IsSumSet_pos_neg() {
		DSLatticeValue a = new DSLatticeValue(Signs.negative);
		DSLatticeValue b = new DSLatticeValue(Signs.positive);

		Assert.assertFalse(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_pos() {
		DSLatticeValue a = new DSLatticeValue(Signs.positive);
		DSLatticeValue b = new DSLatticeValue(Signs.positive);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_set() {
		DSLatticeValue a = new DSLatticeValue(Signs.positive);

		Set<Signs> values = new HashSet<Signs>();
		values.add(Signs.zero);
		values.add(Signs.positive);
		DSLatticeValue b = new DSLatticeValue(values);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_empty_empty() {
		Set<Signs> aValues = new HashSet<Signs>();
		DSLatticeValue a = new DSLatticeValue(aValues);

		Set<Signs> bValues = new HashSet<Signs>();
		DSLatticeValue b = new DSLatticeValue(bValues);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsEqual_bot_bot() {
		DSLatticeValue a = new DSLatticeValue();
		DSLatticeValue b = new DSLatticeValue();

		Assert.assertTrue(a.isSubset(b));
		Assert.assertTrue(a.isEqual(b));
	}
}
