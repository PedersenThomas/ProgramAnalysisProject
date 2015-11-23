package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import frameworks.detectionOfSigns.SetOfSigns;
import frameworks.detectionOfSigns.Signs;

public class SetOfSignsTests {

	@Test
	public void IsSumSet_pos_neg() {
		SetOfSigns a = new SetOfSigns(Signs.negative);
		SetOfSigns b = new SetOfSigns(Signs.positive);

		Assert.assertFalse(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_pos() {
		SetOfSigns a = new SetOfSigns(Signs.positive);
		SetOfSigns b = new SetOfSigns(Signs.positive);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_set() {
		SetOfSigns a = new SetOfSigns(Signs.positive);

		Set<Signs> values = new HashSet<Signs>();
		values.add(Signs.zero);
		values.add(Signs.positive);
		SetOfSigns b = new SetOfSigns(values);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_empty_empty() {
		Set<Signs> aValues = new HashSet<Signs>();
		SetOfSigns a = new SetOfSigns(aValues);

		Set<Signs> bValues = new HashSet<Signs>();
		SetOfSigns b = new SetOfSigns(bValues);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsEqual_bot_bot() {
		SetOfSigns a = new SetOfSigns();
		SetOfSigns b = new SetOfSigns();

		Assert.assertTrue(a.isSubset(b));
		Assert.assertTrue(a.equals(b));
	}
}
