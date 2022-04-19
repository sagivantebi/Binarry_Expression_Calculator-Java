
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Nor
 * The class extends BinaryExpression and is the 'Nor' logical expressin
 */
public class Nor extends BinaryExpression {
    /**
     * .
     * Nor - constructor
     *
     * @param val1 - "left" Expression
     * @param val2 - "right" Expression
     */
    public Nor(Expression val1, Expression val2) {
        super(val1, val2);
    }

    @Override
    public Boolean evaluateOperation(Boolean b1, Boolean b2) {
        return !(b1 || b2);
    }

    @Override
    public String toString() {
        return "(" + super.getExp1().toString() + " V " + super.getExp2().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Nor(super.getExp1().assign(var, expression), super.getExp2().assign(var, expression));
    }

    @Override
    public Expression nandify() {
        return new Nand(new Nand(new Nand(super.getExp1().nandify(), super.getExp1().nandify()),
                new Nand(super.getExp2().nandify(), super.getExp2().nandify())),
                new Nand(new Nand(super.getExp1().nandify(), super.getExp1().nandify()),
                        new Nand(super.getExp2().nandify(), super.getExp2().nandify())));
    }

    @Override
    public Expression norify() {
        return new Nor(super.getExp1().norify(), super.getExp2().norify());
    }

    @Override
    public Expression simplify() {
        try {
            Expression exp1Simplified = super.getExp1().simplify();
            Expression exp2Simplified = super.getExp2().simplify();
            //checks if the first expressions is var and the second true
            try {
                if (exp2Simplified.evaluate()) {
                    return new Val(false);
                }
            } catch (Exception e) {
            }
            //checks if the second expressions is var and the first true
            try {
                if (exp1Simplified.evaluate()) {
                    return new Val(false);
                }
            } catch (Exception e) {
            }
            //checks if the first expressions is var and the second false
            try {
                if (!exp2Simplified.evaluate()) {
                    return new Not(exp1Simplified).simplify();
                }
            } catch (Exception e) {
            }
            //checks if the second expressions is var and the first false
            try {
                if (!exp1Simplified.evaluate()) {
                    return new Not(exp2Simplified).simplify();
                }
            } catch (Exception e) {
            }
            //checks if the both expressions are the same variables
            try {
                if (getExp1().toString().equals(getExp2().toString())) {
                    return new Not(exp1Simplified).simplify();
                } else {
                    return new Nor(exp1Simplified, exp2Simplified);
                }
            } catch (Exception e) {
            }
            //checks if both var but different vars
            try {
                //need to add check for vars
                if (!exp1Simplified.toString().equals(exp2Simplified.toString())) {
                    return new Nor(exp1Simplified, exp2Simplified);
                } else {
                    return new Not(exp1Simplified).simplify();
                }

            } catch (Exception e) {
            }
            //checks if the expressions are only values (T|F)
            try {
                Nor x = new Nor(exp1Simplified, exp2Simplified);
                return new Val(x.evaluate());
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }
        return this;
    }
}
