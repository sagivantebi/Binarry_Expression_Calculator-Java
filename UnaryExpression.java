import java.util.List;
import java.util.Map;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of UnaryExpression
 * The abstract class UnaryExpression extends BaseExpression
 */
public abstract class UnaryExpression extends BaseExpression {
    //our expression
    private Expression exp1;

    /**
     * .
     * UnaryExpression - constructor
     *
     * @param exp1 - the Expression
     */
    public UnaryExpression(Expression exp1) {
        this.exp1 = exp1;
    }

    /**
     * .
     * getVal1 - get the expression
     *
     * @return - the expression
     */
    public Expression getExp1() {
        return this.exp1;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            //checks if the assignment has the var
            if (assignment.containsKey(this.exp1.toString())) {
                //if the not of the expression
                    return evaluateOperation(assignment.get(this.exp1));
            }
        } catch (Exception e) {
        }
        return evaluateOperation(this.exp1.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return evaluateOperation(this.exp1.evaluate());
    }

    /**
     * .
     * evaluateOperation - gets the logical operation
     *
     * @param b1 - the equation (bool)
     * @return - return the answer of the expression | default - false.
     */
    public Boolean evaluateOperation(Boolean b1) {
        return false;
    }

    @Override
    public List<String> getVariables() {
        //the list that contains the vars of the first expression
        List<String> list1 = this.exp1.getVariables();
        return list1;
    }

    @Override
    public Expression simplify() {
        return exp1.simplify();
    }

}
