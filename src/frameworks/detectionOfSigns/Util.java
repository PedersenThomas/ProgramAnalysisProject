package frameworks.detectionOfSigns;

import ast.*;

import java.util.*;

public class Util {

	public static final PowerSetOfSigns EMPTY_SET = new PowerSetOfSigns();
	public static final PowerSetOfSigns NEGATIVE_ONLY = new PowerSetOfSigns(Signs.negative);
	public static final PowerSetOfSigns ZERO_ONLY = new PowerSetOfSigns(Signs.zero);
	public static final PowerSetOfSigns POSITIVE_ONLY = new PowerSetOfSigns(Signs.positive);
	private static final PowerSetOfSigns ALL;
	private static final PowerSetOfSigns[][] ADDITION_TABLE;
	private static final PowerSetOfSigns[][] SUBTRACTION_TABLE;
	private static final PowerSetOfSigns[][] MULTIPLICATION_TABLE;
	private static final PowerSetOfSigns[][] DIVISION_TABLE;

	static {

		Set<Signs> all = new HashSet<>();
		all.add(Signs.negative);
		all.add(Signs.zero);
		all.add(Signs.positive);
		ALL = new PowerSetOfSigns(all);

		PowerSetOfSigns[][] additionTable = { { NEGATIVE_ONLY, NEGATIVE_ONLY, ALL },
				{ NEGATIVE_ONLY, ZERO_ONLY, POSITIVE_ONLY }, { ALL, POSITIVE_ONLY, POSITIVE_ONLY } };
		ADDITION_TABLE = additionTable;

		PowerSetOfSigns[][] subtractionTable = { { ALL, NEGATIVE_ONLY, NEGATIVE_ONLY },
				{ POSITIVE_ONLY, ZERO_ONLY, NEGATIVE_ONLY }, { POSITIVE_ONLY, POSITIVE_ONLY, ALL } };
		SUBTRACTION_TABLE = subtractionTable;

		PowerSetOfSigns[][] multiplicationTable = { { POSITIVE_ONLY, ZERO_ONLY, NEGATIVE_ONLY },
				{ ZERO_ONLY, ZERO_ONLY, ZERO_ONLY }, { NEGATIVE_ONLY, ZERO_ONLY, POSITIVE_ONLY } };
		MULTIPLICATION_TABLE = multiplicationTable;

		PowerSetOfSigns[][] divisionTable = { { POSITIVE_ONLY, EMPTY_SET, NEGATIVE_ONLY },
				{ ZERO_ONLY, EMPTY_SET, ZERO_ONLY }, { NEGATIVE_ONLY, EMPTY_SET, POSITIVE_ONLY } };
		DIVISION_TABLE = divisionTable;

	}

	public static PowerSetOfSigns evalDSArithmeticExpression(ArithmeticExpression expression,
			Map<String, PowerSetOfSigns> signState) {

		if (expression instanceof Identifier) {
			Identifier id = (Identifier) expression;
			return signState.get(id.getName());
		} else if (expression instanceof Constant) {
			Constant con = (Constant) expression;
			int value = con.getNumber();
			if (value < 0) {
				return new PowerSetOfSigns(Signs.negative);
			} else if (value == 0) {
				return new PowerSetOfSigns(Signs.zero);
			} else { // Positive
				return new PowerSetOfSigns(Signs.positive);
			}
		} else if (expression instanceof ArithmeticArray) {
			ArithmeticArray aArray = (ArithmeticArray) expression;
			String id = aArray.getArray();
			ArithmeticExpression index = aArray.getIndex();
			PowerSetOfSigns signsOfIndex = evalDSArithmeticExpression(index, signState);
			if (signsOfIndex.equals(EMPTY_SET) || signsOfIndex.equals(NEGATIVE_ONLY)) {
				return new PowerSetOfSigns(); // Empty set
			} else { // Legal index
				return signState.get(id);
			}
		} else if (expression instanceof ArithmeticOperation) {
			ArithmeticOperation arithOp = (ArithmeticOperation) expression;
			PowerSetOfSigns leftResult = evalDSArithmeticExpression(arithOp.getLeft(), signState);
			PowerSetOfSigns rightResult = evalDSArithmeticExpression(arithOp.getRight(), signState);
			return combine(arithOp.getOperator(), leftResult, rightResult);
		} else if (expression instanceof UnaryMinus) {
			UnaryMinus unary = (UnaryMinus) expression;
			ArithmeticExpression right = unary.getExpression();
			PowerSetOfSigns rightResult = evalDSArithmeticExpression(right, signState);
			return combine(ArithmeticOperator.Minus, ZERO_ONLY, rightResult);
		} else {
			throw new IllegalArgumentException("Unknown type of arithmetic expression.");
		}

	}

	private static PowerSetOfSigns combine(ArithmeticOperator operator, PowerSetOfSigns left, PowerSetOfSigns right) {

		Set<Signs> result = new HashSet<>();

		for (Signs leftSign : left.getSigns()) {
			for (Signs rightSign : right.getSigns()) {
				switch (operator) {
				case Plus:
					result.addAll(ADDITION_TABLE[toIndex(leftSign)][toIndex(rightSign)].getSigns());
					break;
				case Minus:
					result.addAll(SUBTRACTION_TABLE[toIndex(leftSign)][toIndex(rightSign)].getSigns());
					break;
				case Multiply:
					result.addAll(MULTIPLICATION_TABLE[toIndex(leftSign)][toIndex(rightSign)].getSigns());
					break;
				case Divide:
					result.addAll(DIVISION_TABLE[toIndex(leftSign)][toIndex(rightSign)].getSigns());
					break;
				default:
					throw new IllegalArgumentException("Unknown operator.");
				}
			}
		}

		return new PowerSetOfSigns(result);

	}

	private static int toIndex(Signs sign) {
		switch (sign) {
		case zero:
			return 1;
		case negative:
			return 0;
		case positive:
			return 2;
		default:
			throw new IllegalArgumentException("Unknown sign.");
		}
	}

    public static Set<Map<String, PowerSetOfSigns>>
            atom(Map<String, PowerSetOfSigns> signState) {
        HashMap<String, PowerSetOfSigns> clone = new HashMap<>(signState);
        return atomRecursive(clone);
    }

    private static Set<Map<String, PowerSetOfSigns>>
            atomRecursive(Map<String, PowerSetOfSigns> signState) {
        if (signState.isEmpty()) {
            Map<String, PowerSetOfSigns> empty = new HashMap<>();
            Set<Map<String, PowerSetOfSigns>> singleton = new HashSet<>();
            singleton.add(empty);
            return singleton;
        }

        Set<Map<String, PowerSetOfSigns>> result = new HashSet<>();

        Map.Entry<String, PowerSetOfSigns> firstEntry = null;
        for (Map.Entry<String, PowerSetOfSigns> entry : signState.entrySet()) {
            firstEntry = entry;
            break;
        }

        PowerSetOfSigns firstSetOfSigns = signState.remove(firstEntry.getKey());
        Set<Map<String, PowerSetOfSigns>> atomsOfTail =
                atomRecursive(signState);

        for (Map<String, PowerSetOfSigns> atom : atomsOfTail) {
            for (Signs sign : firstSetOfSigns.getSigns()) {
                Map<String, PowerSetOfSigns> clone = new HashMap<>(atom);
                clone.put(firstEntry.getKey(), new PowerSetOfSigns(sign));
                result.add(clone);
            }
        }

        return result;
    }

	public static <T> HashSet<T> Union(Set<T> a, Set<T> b) {
		HashSet<T> result = new HashSet<>();
		result.addAll(a);
		result.addAll(b);
		return result;
	}

	public static String join(Collection<?> col, String delim) {
		StringBuilder sb = new StringBuilder();
		Iterator<?> iter = col.iterator();
		if (iter.hasNext())
			sb.append(iter.next().toString());
		while (iter.hasNext()) {
			sb.append(delim);
			sb.append(iter.next().toString());
		}
		return sb.toString();
	}
}
