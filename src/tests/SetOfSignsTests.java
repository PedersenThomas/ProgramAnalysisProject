package tests;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import frameworks.detectionOfSigns.SetOfSigns;
import frameworks.detectionOfSigns.Sign;

public class SetOfSignsTests {

	@Test
	public void IsSumSet_pos_neg() {
		SetOfSigns a = new SetOfSigns(Sign.negative);
		SetOfSigns b = new SetOfSigns(Sign.positive);

		Assert.assertFalse(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_pos() {
		SetOfSigns a = new SetOfSigns(Sign.positive);
		SetOfSigns b = new SetOfSigns(Sign.positive);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_set() {
		SetOfSigns a = new SetOfSigns(Sign.positive);

		Set<Sign> values = new HashSet<Sign>();
		values.add(Sign.zero);
		values.add(Sign.positive);
		SetOfSigns b = new SetOfSigns(values);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_empty_empty() {
		Set<Sign> aValues = new HashSet<Sign>();
		SetOfSigns a = new SetOfSigns(aValues);

		Set<Sign> bValues = new HashSet<Sign>();
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
