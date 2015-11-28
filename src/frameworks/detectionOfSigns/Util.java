package frameworks.detectionOfSigns;

import ast.*;
import graph.Variable;
import graph.VariableType;

import java.util.*;

public class Util {

	public static final SetOfSigns EMPTY_SET = new SetOfSigns();
	public static final SetOfSigns NEGATIVE_ONLY = new SetOfSigns(Sign.negative);
	public static final SetOfSigns ZERO_ONLY = new SetOfSigns(Sign.zero);
	public static final SetOfSigns POSITIVE_ONLY = new SetOfSigns(Sign.positive);
	public static final SetOfSigns ALL;
	private static final SetOfSigns[][] ADDITION_TABLE;
	private static final SetOfSigns[][] SUBTRACTION_TABLE;
	private static final SetOfSigns[][] MULTIPLICATION_TABLE;
	private static final SetOfSigns[][] DIVISION_TABLE;

    private static final SetOfBooleans TRUE_ONLY;
    private static final SetOfBooleans FALSE_ONLY;
    private static final SetOfBooleans ALL_BOOLEAN;
    private static final SetOfBooleans[][] LESS_THAN_TABLE;
    private static final SetOfBooleans[][] LESS_THAN_EQUAL_TABLE;
    private static final SetOfBooleans[][] EQUAL_TABLE;
    private static final SetOfBooleans[][] NOT_EQUAL_TABLE;


	static {

		Set<Sign> all = new HashSet<Sign>();
		all.add(Sign.negative);
		all.add(Sign.zero);
		all.add(Sign.positive);
		ALL = new SetOfSigns(all);

		SetOfSigns[][] additionTable = { { NEGATIVE_ONLY, NEGATIVE_ONLY, ALL },
				{ NEGATIVE_ONLY, ZERO_ONLY, POSITIVE_ONLY }, { ALL, POSITIVE_ONLY, POSITIVE_ONLY } };
		ADDITION_TABLE = additionTable;

		SetOfSigns[][] subtractionTable = { { ALL, NEGATIVE_ONLY, NEGATIVE_ONLY },
				{ POSITIVE_ONLY, ZERO_ONLY, NEGATIVE_ONLY }, { POSITIVE_ONLY, POSITIVE_ONLY, ALL } };
		SUBTRACTION_TABLE = subtractionTable;

		SetOfSigns[][] multiplicationTable = { { POSITIVE_ONLY, ZERO_ONLY, NEGATIVE_ONLY },
				{ ZERO_ONLY, ZERO_ONLY, ZERO_ONLY }, { NEGATIVE_ONLY, ZERO_ONLY, POSITIVE_ONLY } };
		MULTIPLICATION_TABLE = multiplicationTable;

		SetOfSigns[][] divisionTable = { { POSITIVE_ONLY, EMPTY_SET, NEGATIVE_ONLY },
				{ ZERO_ONLY, EMPTY_SET, ZERO_ONLY }, { NEGATIVE_ONLY, EMPTY_SET, POSITIVE_ONLY } };
		DIVISION_TABLE = divisionTable;


        Set<Boolean> trueOnly = new HashSet<Boolean>();
        trueOnly.add(true);
        TRUE_ONLY = new SetOfBooleans(trueOnly);

        Set<Boolean> falseOnly = new HashSet<Boolean>();
        falseOnly.add(false);
        FALSE_ONLY = new SetOfBooleans(falseOnly);

        Set<Boolean> allBoolean = new HashSet<Boolean>();
        allBoolean.add(false);
        allBoolean.add(true);
        ALL_BOOLEAN = new SetOfBooleans(allBoolean);

        SetOfBooleans[][] lessThanTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN}
        };
        LESS_THAN_TABLE = lessThanTable;

        SetOfBooleans[][] lessThanEqualTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, TRUE_ONLY, TRUE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN}
        };
        LESS_THAN_EQUAL_TABLE = lessThanEqualTable;

        SetOfBooleans[][] equalTable = {
                {ALL_BOOLEAN, FALSE_ONLY, FALSE_ONLY},
                {FALSE_ONLY, TRUE_ONLY, FALSE_ONLY},
                {FALSE_ONLY, FALSE_ONLY, ALL_BOOLEAN},
        };
        EQUAL_TABLE = equalTable;

        SetOfBooleans[][] notEqualTable = {
                {ALL_BOOLEAN, TRUE_ONLY, TRUE_ONLY},
                {TRUE_ONLY, FALSE_ONLY, TRUE_ONLY},
                {TRUE_ONLY, TRUE_ONLY, ALL_BOOLEAN},
        };
        NOT_EQUAL_TABLE = notEqualTable;

	}

	public static SetOfSigns evalDSArithmeticExpression(ArithmeticExpression expression,
			Map<Variable, SetOfSigns> signState) {

		if (expression instanceof Identifier) {
			Identifier id = (Identifier) expression;
            return signState.get(new Variable(id.getName(), VariableType.Variable));
		} else if (expression instanceof Constant) {
			Constant con = (Constant) expression;
			int value = con.getNumber();
			if (value < 0) {
				return new SetOfSigns(Sign.negative);
			} else if (value == 0) {
				return new SetOfSigns(Sign.zero);
			} else { // Positive
				return new SetOfSigns(Sign.positive);
			}
		} else if (expression instanceof ArithmeticArray) {
			ArithmeticArray aArray = (ArithmeticArray) expression;
			String id = aArray.getArray();
			ArithmeticExpression index = aArray.getIndex();
			SetOfSigns signsOfIndex = evalDSArithmeticExpression(index, signState);
			if (signsOfIndex.equals(EMPTY_SET) || signsOfIndex.equals(NEGATIVE_ONLY)) {
				return new SetOfSigns(); // Empty set
			} else { // Legal index
				return signState.get(new Variable(id, VariableType.Array));
			}
		} else if (expression instanceof ArithmeticOperation) {
			ArithmeticOperation arithOp = (ArithmeticOperation) expression;
            SetOfSigns leftResult = evalDSArithmeticExpression(arithOp.getLeft(), signState);
			SetOfSigns rightResult = evalDSArithmeticExpression(arithOp.getRight(), signState);
            return combine(arithOp.getOperator(), leftResult, rightResult);
		} else if (expression instanceof UnaryMinus) {
			UnaryMinus unary = (UnaryMinus) expression;
			ArithmeticExpression right = unary.getExpression();
			SetOfSigns rightResult = evalDSArithmeticExpression(right, signState);
			return combine(ArithmeticOperator.Minus, ZERO_ONLY, rightResult);
		} else {
			throw new IllegalArgumentException("Unknown type of arithmetic expression.");
		}

	}

	private static SetOfSigns combine(ArithmeticOperator operator, SetOfSigns left, SetOfSigns right) {

		Set<Sign> result = new HashSet<Sign>();

		for (Sign leftSign : left.getSigns()) {
			for (Sign rightSign : right.getSigns()) {
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

		return new SetOfSigns(result);

	}

	private static int toIndex(Sign sign) {
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

    public static Set<Map<Variable, SetOfSigns>>
            atom(Map<Variable, SetOfSigns> signState) {
        HashMap<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(signState);
        return atomRecursive(clone);
    }

    private static Set<Map<Variable, SetOfSigns>>
            atomRecursive(Map<Variable, SetOfSigns> signState) {
        if (signState.isEmpty()) {
            Map<Variable, SetOfSigns> empty = new HashMap<Variable, SetOfSigns>();
            Set<Map<Variable, SetOfSigns>> singleton = new HashSet<Map<Variable, SetOfSigns>>();
            singleton.add(empty);
            return singleton;
        }

        Set<Map<Variable, SetOfSigns>> result = new HashSet<Map<Variable, SetOfSigns>>();

        Map.Entry<Variable, SetOfSigns> firstEntry = null;
        for (Map.Entry<Variable, SetOfSigns> entry : signState.entrySet()) {
            firstEntry = entry;
            break;
        }

        SetOfSigns firstSetOfSigns = signState.remove(firstEntry.getKey());
        Set<Map<Variable, SetOfSigns>> atomsOfTail =
                atomRecursive(signState);

        for (Map<Variable, SetOfSigns> atom : atomsOfTail) {
            if (firstEntry.getKey().getType().equals(VariableType.Array)) {
                Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(atom);
                clone.put(firstEntry.getKey(), firstEntry.getValue());
                result.add(clone);
            } else {
                for (Sign sign : firstSetOfSigns.getSigns()) {
                    Map<Variable, SetOfSigns> clone = new HashMap<Variable, SetOfSigns>(atom);
                    clone.put(firstEntry.getKey(), new SetOfSigns(sign));
                    result.add(clone);
                }
            }
        }

        return result;
    }

	public static SetOfBooleans evalDSBooleanExpression(
            BooleanExpression expression, Map<Variable, SetOfSigns> signState) {

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
            SetOfSigns signsOfLeft = evalDSArithmeticExpression(left, signState);
            SetOfSigns signsOfRight = evalDSArithmeticExpression(right, signState);
            return combineRelational(relationalOperation.getOperator(), signsOfLeft, signsOfRight);
        } else if (expression instanceof BooleanOperation) {
            BooleanOperation booleanOperation = (BooleanOperation) expression;
            BooleanExpression left = booleanOperation.getLeft();
            BooleanExpression right = booleanOperation.getRight();
            SetOfBooleans boolsOfLeft = evalDSBooleanExpression(left, signState);
            SetOfBooleans boolsOfRight = evalDSBooleanExpression(right, signState);
            return combineBoolean(booleanOperation.getOperator(), boolsOfLeft, boolsOfRight);
        } else if (expression instanceof BooleanNotExpression) {
            BooleanNotExpression notExpression = (BooleanNotExpression) expression;
            BooleanExpression innerExpression = notExpression.getExpression();
            SetOfBooleans boolsOfInner = evalDSBooleanExpression(innerExpression, signState);
            return negate(boolsOfInner);
        }

        return null;
    }

    private static SetOfBooleans negate(SetOfBooleans bools) {
        Set<Boolean> result = new HashSet<Boolean>();

        for (Boolean bool : bools.getBooleans()) {
            result.add(!bool);
        }

        return new SetOfBooleans(result);
    }

    private static SetOfBooleans combineBoolean(
            BooleanOperator operator, SetOfBooleans boolsOfLeft, SetOfBooleans boolsOfRight) {

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

        return new SetOfBooleans(result);
    }

    private static SetOfBooleans combineRelational(
            RelationalOperator operator, SetOfSigns signsOfLeft, SetOfSigns signsOfRight) {

        Set<Boolean> result = new HashSet<Boolean>();

        for (Sign leftSign : signsOfLeft.getSigns()) {
            for (Sign rightSign : signsOfRight.getSigns()) {
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

        return new SetOfBooleans(result);

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
