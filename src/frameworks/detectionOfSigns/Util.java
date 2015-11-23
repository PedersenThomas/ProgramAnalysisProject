package frameworks.detectionOfSigns;

import ast.*;
import graph.Variable;
import graph.VariableType;

import java.util.*;

public class Util {

	public static final PowerSetOfSigns EMPTY_SET = new PowerSetOfSigns();
	public static final PowerSetOfSigns NEGATIVE_ONLY = new PowerSetOfSigns(Signs.negative);
	public static final PowerSetOfSigns ZERO_ONLY = new PowerSetOfSigns(Signs.zero);
	public static final PowerSetOfSigns POSITIVE_ONLY = new PowerSetOfSigns(Signs.positive);
	public static final PowerSetOfSigns ALL;
	private static final PowerSetOfSigns[][] ADDITION_TABLE;
	private static final PowerSetOfSigns[][] SUBTRACTION_TABLE;
	private static final PowerSetOfSigns[][] MULTIPLICATION_TABLE;
	private static final PowerSetOfSigns[][] DIVISION_TABLE;

    private static final PowerSetOfBooleans TRUE_ONLY;
    private static final PowerSetOfBooleans FALSE_ONLY;
    private static final PowerSetOfBooleans ALL_BOOLEAN;
    private static final PowerSetOfBooleans[][] LESS_THAN_TABLE;
    private static final PowerSetOfBooleans[][] LESS_THAN_EQUAL_TABLE;
    private static final PowerSetOfBooleans[][] EQUAL_TABLE;
    private static final PowerSetOfBooleans[][] NOT_EQUAL_TABLE;


	static {

		Set<Signs> all = new HashSet<Signs>();
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


        Set<Boolean> trueOnly = new HashSet<Boolean>();
        trueOnly.add(true);
        TRUE_ONLY = new PowerSetOfBooleans(trueOnly);

        Set<Boolean> falseOnly = new HashSet<Boolean>();
        falseOnly.add(false);
        FALSE_ONLY = new PowerSetOfBooleans(falseOnly);

        Set<Boolean> allBoolean = new HashSet<Boolean>();
        allBoolean.add(false);
        allBoolean.add(true);
        ALL_BOOLEAN = new PowerSetOfBooleans(allBoolean);

        PowerSetOfBooleans[][] lessThanTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN}
        };
        LESS_THAN_TABLE = lessThanTable;

        PowerSetOfBooleans[][] lessThanEqualTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN}
        };
        LESS_THAN_EQUAL_TABLE = lessThanEqualTable;

        PowerSetOfBooleans[][] equalTable = {
                {ALL_BOOLEAN, FALSE_ONLY, FALSE_ONLY},
                {FALSE_ONLY, TRUE_ONLY, FALSE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN},
        };
        EQUAL_TABLE = equalTable;

        PowerSetOfBooleans[][] notEqualTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {TRUE_ONLY, FALSE_ONLY, TRUE_ONLY},
                {TRUE_ONLY, TRUE_ONLY, ALL_BOOLEAN},
        };
        NOT_EQUAL_TABLE = notEqualTable;

	}

	public static PowerSetOfSigns evalDSArithmeticExpression(ArithmeticExpression expression,
			Map<Variable, PowerSetOfSigns> signState) {

		if (expression instanceof Identifier) {
			Identifier id = (Identifier) expression;
            return signState.get(new Variable(id.getName(), VariableType.Variable));
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
				return signState.get(new Variable(id, VariableType.Array));
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

		Set<Signs> result = new HashSet<Signs>();

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

    public static Set<Map<Variable, PowerSetOfSigns>>
            atom(Map<Variable, PowerSetOfSigns> signState) {
        HashMap<Variable, PowerSetOfSigns> clone = new HashMap<Variable, PowerSetOfSigns>(signState);
        return atomRecursive(clone);
    }

    private static Set<Map<Variable, PowerSetOfSigns>>
            atomRecursive(Map<Variable, PowerSetOfSigns> signState) {
        if (signState.isEmpty()) {
            Map<Variable, PowerSetOfSigns> empty = new HashMap<Variable, PowerSetOfSigns>();
            Set<Map<Variable, PowerSetOfSigns>> singleton = new HashSet<Map<Variable, PowerSetOfSigns>>();
            singleton.add(empty);
            return singleton;
        }

        Set<Map<Variable, PowerSetOfSigns>> result = new HashSet<Map<Variable, PowerSetOfSigns>>();

        Map.Entry<Variable, PowerSetOfSigns> firstEntry = null;
        for (Map.Entry<Variable, PowerSetOfSigns> entry : signState.entrySet()) {
            firstEntry = entry;
            break;
        }

        PowerSetOfSigns firstSetOfSigns = signState.remove(firstEntry.getKey());
        Set<Map<Variable, PowerSetOfSigns>> atomsOfTail =
                atomRecursive(signState);

        for (Map<Variable, PowerSetOfSigns> atom : atomsOfTail) {
            if (firstEntry.getKey().getType().equals(VariableType.Array)) {
                Map<Variable, PowerSetOfSigns> clone = new HashMap<Variable, PowerSetOfSigns>(atom);
                clone.put(firstEntry.getKey(), firstEntry.getValue());
                result.add(clone);
            } else {
                for (Signs sign : firstSetOfSigns.getSigns()) {
                    Map<Variable, PowerSetOfSigns> clone = new HashMap<Variable, PowerSetOfSigns>(atom);
                    clone.put(firstEntry.getKey(), new PowerSetOfSigns(sign));
                    result.add(clone);
                }
            }
        }

        return result;
    }

	public static PowerSetOfBooleans evalDSBooleanExpression(
            BooleanExpression expression, Map<Variable, PowerSetOfSigns> signState) {

        if (expression instanceof BooleanConstant) {
            BooleanConstant constant = (BooleanConstant) expression;
            if (constant.getValue()) {
                return TRUE_ONLY;
            } else {
                return FALSE_ONLY;
            }
        } else if (expression instanceof RelationalOperation) {
            RelationalOperation relationalOperation = (RelationalOperation) expression;
            ArithmeticExpression left = relationalOperation.getLeft();
            ArithmeticExpression right = relationalOperation.getRight();
            PowerSetOfSigns signsOfLeft = evalDSArithmeticExpression(left, signState);
            PowerSetOfSigns signsOfRight = evalDSArithmeticExpression(right, signState);
            return combineRelational(relationalOperation.getOperator(), signsOfLeft, signsOfRight);
        } else if (expression instanceof BooleanOperation) {
            BooleanOperation booleanOperation = (BooleanOperation) expression;
            BooleanExpression left = booleanOperation.getLeft();
            BooleanExpression right = booleanOperation.getRight();
            PowerSetOfBooleans boolsOfLeft = evalDSBooleanExpression(left, signState);
            PowerSetOfBooleans boolsOfRight = evalDSBooleanExpression(right, signState);
            return combineBoolean(booleanOperation.getOperator(), boolsOfLeft, boolsOfRight);
        } else if (expression instanceof BooleanNotExpression) {
            BooleanNotExpression notExpression = (BooleanNotExpression) expression;
            BooleanExpression innerExpression = notExpression.getExpression();
            PowerSetOfBooleans boolsOfInner = evalDSBooleanExpression(innerExpression, signState);
            return negate(boolsOfInner);
        }

        return null;
    }

    private static PowerSetOfBooleans negate(PowerSetOfBooleans bools) {
        Set<Boolean> result = new HashSet<Boolean>();

        for (Boolean bool : bools.getBooleans()) {
            result.add(!bool);
        }

        return new PowerSetOfBooleans(result);
    }

    private static PowerSetOfBooleans combineBoolean(
            BooleanOperator operator, PowerSetOfBooleans boolsOfLeft, PowerSetOfBooleans boolsOfRight) {

        Set<Boolean> result = new HashSet<Boolean>();

        for (Boolean leftBool : boolsOfLeft.getBooleans()) {
            for (Boolean rightBool : boolsOfRight.getBooleans()) {
                switch (operator) {
                    case And:
                        result.add(leftBool && rightBool);
                        break;
                    case Or:
                        result.add(leftBool || rightBool);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator.");
                }
            }
        }

        return new PowerSetOfBooleans(result);
    }

    private static PowerSetOfBooleans combineRelational(
            RelationalOperator operator, PowerSetOfSigns signsOfLeft, PowerSetOfSigns signsOfRight) {

        Set<Boolean> result = new HashSet<Boolean>();

        for (Signs leftSign : signsOfLeft.getSigns()) {
            for (Signs rightSign : signsOfRight.getSigns()) {
                switch (operator) {
                    case LessThan:
                        result.addAll(LESS_THAN_TABLE[toIndex(leftSign)][toIndex(rightSign)].getBooleans());
                        break;
                    case GreaterThan:
                        result.addAll(LESS_THAN_TABLE[toIndex(rightSign)][toIndex(leftSign)].getBooleans());
                        break;
                    case LessThanOrEqual:
                        result.addAll(LESS_THAN_EQUAL_TABLE[toIndex(leftSign)][toIndex(rightSign)].getBooleans());
                        break;
                    case GreaterThanOrEqual:
                        result.addAll(LESS_THAN_EQUAL_TABLE[toIndex(rightSign)][toIndex(leftSign)].getBooleans());
                        break;
                    case Equal:
                        result.addAll(EQUAL_TABLE[toIndex(leftSign)][toIndex(rightSign)].getBooleans());
                        break;
                    case NotEqual:
                        result.addAll(NOT_EQUAL_TABLE[toIndex(leftSign)][toIndex(rightSign)].getBooleans());
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown operator.");
                }
            }
        }

        return new PowerSetOfBooleans(result);

    }

	public static <T> HashSet<T> Union(Set<T> a, Set<T> b) {
		HashSet<T> result = new HashSet<T>();
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
