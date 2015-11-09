package tests;

import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

import frameworks.detection_of_signs.DSLaticeValue;
import frameworks.detection_of_signs.Signs;

public class LaticeValue {

	@Test
	public void IsSumSet_pos_neg() {
		DSLaticeValue a = new DSLaticeValue(Signs.negative);
		DSLaticeValue b = new DSLaticeValue(Signs.positive);

		Assert.assertFalse(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_pos() {
		DSLaticeValue a = new DSLaticeValue(Signs.positive);
		DSLaticeValue b = new DSLaticeValue(Signs.positive);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_pos_set() {
		DSLaticeValue a = new DSLaticeValue(Signs.positive);

		Set<Signs> values = new HashSet<Signs>();
		values.add(Signs.zero);
		values.add(Signs.positive);
		DSLaticeValue b = new DSLaticeValue(values);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsSumSet_empty_empty() {
		Set<Signs> aValues = new HashSet<Signs>();
		DSLaticeValue a = new DSLaticeValue(aValues);

		Set<Signs> bValues = new HashSet<Signs>();
		DSLaticeValue b = new DSLaticeValue(bValues);

		Assert.assertTrue(a.isSubset(b));
	}

	@Test
	public void IsEqual_bot_bot() {
		DSLaticeValue a = new DSLaticeValue();
		DSLaticeValue b = new DSLaticeValue();

		Assert.assertTrue(a.isSubset(b));
		Assert.assertTrue(a.isEqual(b));
	}
}
