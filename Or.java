
// ID: 318159282
/**
 * @author SAGIV ANTEBI
 * A class of Or
 * The class extends BinaryExpression and is the 'Or' logical expressin
 */
public class Or extends BinaryExpression {
    /**
     * .
     * Or - constructor
     *
     * @param val1 - "left" Expression
     * @param val2 - "right" Expression
     */
    public Or(Expression val1, Expression val2) {
        super(val1, val2);
    }

    @Override
    public Boolean evaluateOperation(Boolean b1, Boolean b2) {
        return b1 || b2;
    }


    @Override
    public String toString() {
        return "(" + super.getExp1().toString() + " | " + super.getExp2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Or(super.getExp1().assign(var, expression), super.getExp2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(super.getExp1().nandify(), super.getExp1().nandify()),
                new Nand(super.getExp2().nandify(), super.getExp2().nandify()));
    }

    @Override
    public Expression norify() {
        return new Nor(new Nor(super.getExp1().norify(), super.getExp2().norify()), new Nor(super.getExp1().norify(),
                super.getExp2().norify()));
    }

    @Override
    public Expression simplify() {
        Expression exp1Simplified = super.getExp1().simplify();
        Expression exp2Simplified = super.getExp2().simplify();
        //checks if one of the expressions is true
        try {
            if (exp1Simplified.evaluate() || exp2Simplified.evaluate()) {
                return new Val(true);
            }
        } catch (Exception e) {
        }
        //checks if the first expressions is false
        try {
            if (!exp1Simplified.evaluate()) {
                return getExp2();
            } else {
                return new Val(true);
            }
        } catch (Exception e) {
        }
        //checks if the second expressions is false
        try {
            if (!exp2Simplified.evaluate()) {
                return getExp1();
            } else {
                return new Val(true);
            }
        } catch (Exception e) {
        }
        //checks if the both expressions are the same variables
        try {
                if (exp1Simplified.toString().equals(exp2Simplified.toString())) {
                    return getExp1().simplify();
                } else {
                    return new Or(getExp1().simplify(), getExp2().simplify());
                }
        } catch (Exception e) {
        }
        //checks if the expressions are only values (T|F)
        try {
            if (exp1Simplified.evaluate() || exp2Simplified.evaluate()) {
                Or x = new Or(exp1Simplified, exp2Simplified);
                return new Val(x.evaluate());
            }
        } catch (Exception e) {
        }

        return this;
    }
}
