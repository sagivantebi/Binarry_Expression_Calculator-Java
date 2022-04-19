
// ID: 318159282
/**
 * @author SAGIV ANTEBI
 * A class of And
 * The class extends BinaryExpression and is the 'And' logical expressin
 */
public class And extends BinaryExpression {

    /**
     * .
     * And - constructor
     *
     * @param val1 - "left" Expression
     * @param val2 - "right" Expression
     */
    public And(Expression val1, Expression val2) {
        super(val1, val2);
    }

    @Override
    public Boolean evaluateOperation(Boolean b1, Boolean b2) {
        return b1 && b2;
    }

    @Override
    public String toString() {
        return "(" + super.getExp1().toString() + " & " + super.getExp2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new And(super.getExp1().assign(var, expression), super.getExp2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(super.getExp1().nandify(), super.getExp2().nandify()),
                new Nand(super.getExp1().nandify(), super.getExp2().nandify()));
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(super.getExp1().norify(), super.getExp1().norify()),
                new Nor(super.getExp2().norify(), super.getExp2().norify()));
    }

    @Override
    public Expression simplify() {
        Expression exp1Simplified = super.getExp1().simplify();
        Expression exp2Simplified = super.getExp2().simplify();
        //checks if both of the expressions are true
        try {
            if (exp1Simplified.evaluate() && exp2Simplified.evaluate()) {
                return new Val(true);
            }
        } catch (Exception e) {
        }
        //checks if the first expressions is false
        try {
            if (!exp1Simplified.evaluate()) {
                return new Val(false);
            }
        } catch (Exception e) {
        }
        //checks if the second expressions is false
        try {
            if (!exp2Simplified.evaluate()) {
                return new Val(false);
            }
        } catch (Exception e) {
        }
        //checks if the first expressions is true
        try {
            if (exp1Simplified.evaluate()) {
                return exp2Simplified;
            }
        } catch (Exception e) {
        }
        //checks if the second expressions is true
        try {
            if (exp2Simplified.evaluate()) {
                return exp1Simplified;
            }
        } catch (Exception e) {
        }
//        checks if the both expressions are the same variables
        try {
                if (exp1Simplified.toString().equals(exp2Simplified.toString())) {
                    return exp1Simplified;
                } else {
                    return new And(exp1Simplified, exp2Simplified);
                }
        } catch (Exception e) {
        }
        //checks if the expressions are only values (T|F)
        try {
            And x = new And(exp1Simplified, exp2Simplified);
            return new Val(x.evaluate());
        } catch (Exception e) {
        }

        return this;
    }
}
