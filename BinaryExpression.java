
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of BinaryExpression
 * The abstract class BinaryExpression extends BaseExpression
 */
public abstract class BinaryExpression extends BaseExpression {
    //the "left" expression
    private Expression exp1;
    //the "right" expression
    private Expression exp2;

    /**
     * .
     * BinaryExpression - constructor
     *
     * @param exp1 - the "left" expression
     * @param exp2 - the "right" expression
     */
    public BinaryExpression(Expression exp1, Expression exp2) {
        super();
        this.exp1 = exp1;
        this.exp2 = exp2;
    }

    /**
     * .
     * getVal1 - get the expression
     *
     * @return - return the expression from val1
     */
    public Expression getExp1() {
        return this.exp1;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            if (assignment.containsKey(this.exp1.toString())
                    && assignment.containsKey(this.exp2.toString())) {
                return evaluateOperation(assignment.get(this.exp1), assignment.get(this.exp2));
            }
            return evaluateOperation(this.exp1.evaluate(), this.exp2.evaluate());
        } catch (Exception e) {
        }
        return evaluateOperation(this.exp1.evaluate(assignment), this.exp2.evaluate(assignment));
    }

    @Override
    public Boolean evaluate() throws Exception {
        return evaluateOperation(this.exp1.evaluate(), this.exp2.evaluate());
    }

    /**
     * .
     * evaluateOperation - gets the logical operation
     *
     * @param b1 - the first equation (bool)
     * @param b2 - the second equation (bool)
     * @return - return the answer of the expression | default - false.
     */
    public Boolean evaluateOperation(Boolean b1, Boolean b2) {
        return false;
    }

    /**
     * .
     * getVal2 - get the expression
     *
     * @return - return the expression from val2
     */
    public Expression getExp2() {
        return this.exp2;
    }

    @Override
    public List<String> getVariables() {
        //the list that contains the vars of the first expression
        List<String> list1 = this.exp1.getVariables();
        //the list that contains the vars of the second expression
        List<String> list2 = this.exp2.getVariables();
        list1.addAll(list2);
        //erase the duplicates
        //new set string list
        Set<String> noDuplicatesList = new HashSet<String>();
        //adding the list of the variables to the new list
        noDuplicatesList.addAll(list1);
        //return the new list (set) without duplicates
        return new ArrayList<>(noDuplicatesList);
    }

    @Override
    public Expression simplify() {
        return this;
    }
}
