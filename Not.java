
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Not
 * The class extends UnaryExpression and is the 'Not' logical expressin
 */
public class Not extends UnaryExpression {
    /**
     * .
     * Not - constructor
     *
     * @param epx1 - the expression.
     */
    public Not(Expression epx1) {
        super(epx1);
    }

    @Override
    public Boolean evaluateOperation(Boolean b1) {
        return !b1;
    }

    @Override
    public String toString() {
        return "~" + "(" + super.getExp1().toString() + ")";
    }

    @Override
    public Expression assign(String var, Expression expression) {
        return new Not(super.getExp1().assign(var, expression));

    }

    @Override
    public Expression nandify() {
        return new Nand(super.getExp1().nandify(), super.getExp1().nandify());
    }

    @Override
    public Expression norify() {
        return new Nor(super.getExp1().norify(), super.getExp1().norify());
    }

    @Override
    public Expression simplify() {
        Expression exp1Simplified = super.getExp1().simplify();
        //First checks if the expression are only Values.
        //checks if the value of the expression is false - then return true
        if (exp1Simplified.equals(false)) {
            return new Val(true);
        }
        //checks if the value of the expression is true - then return false
        if (exp1Simplified.equals(true)) {
            return new Val(false);
        }
//        //checks if the expression is Not expression
//        if (super.getExp1() instanceof Not) {
//            //the original not expression
//            Not notExpression = this;
//            //counts the number of Not's
//            int countNegatives = 0;
//            //while loop to go in the Not's expressions
//            while (notExpression.getExp1() instanceof Not) {
//                countNegatives++;
//                //go to the next expression
//                notExpression = (Not) notExpression.getExp1();
//            }
//            //checks if the number of Not's is negative - then return the inside expression
//            if (countNegatives % 2 == 1) {
//                return notExpression.getExp1();
//            }
//            return notExpression;
//        }
        return this;
    }
}
