package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import frameworks.detectionOfSigns.PowerSetOfSigns;
import frameworks.detectionOfSigns.Signs;

public class PowerSetOfSignsTests {

	@Test
	public void IsSumSet_pos_neg() {
		PowerSetOfSigns a = new PowerSetOfSigns(Signs.negative);
		PowerSetOfSigns b = new PowerSetOfSigns(Signs.positive);

		Assert.assertFalse(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_pos() {
		PowerSetOfSigns a = new PowerSetOfSigns(Signs.positive);
		PowerSetOfSigns b = new PowerSetOfSigns(Signs.positive);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_set() {
		PowerSetOfSigns a = new PowerSetOfSigns(Signs.positive);

		Set<Signs> values = new HashSet<Signs>();
		values.add(Signs.zero);
		values.add(Signs.positive);
		PowerSetOfSigns b = new PowerSetOfSigns(values);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_empty_empty() {
		Set<Signs> aValues = new HashSet<Signs>();
		PowerSetOfSigns a = new PowerSetOfSigns(aValues);

		Set<Signs> bValues = new HashSet<Signs>();
		PowerSetOfSigns b = new PowerSetOfSigns(bValues);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsEqual_bot_bot() {
		PowerSetOfSigns a = new PowerSetOfSigns();
		PowerSetOfSigns b = new PowerSetOfSigns();

		Assert.assertTrue(a.isSubset(b));
		Assert.assertTrue(a.equals(b));
	}
}
