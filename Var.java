import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Var
 * The class implements Expression and is the variable in the expression
 */
public class Var implements Expression {
    private String str;

    /**
     * .
     * Var - constructor.
     *
     * @param str - the char of the variable.
     */
    public Var(String str) {
        this.str = str;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        try {
            return assignment.get(this.str);
        } catch (Exception e) {
            throw new Exception();
        }

    }

    @Override
    public Boolean evaluate() throws Exception {
        throw new Exception();
    }

    @Override
    public String toString() {
        return this.str;
    }

    @Override
    public List<String> getVariables() {
        List<String> list = new ArrayList<String>();
        //adding the var to the list.
        list.add(this.str);
        return list;
    }

    @Override
    public Expression assign(String var, Expression expression) {
        if (var.equals(this.str)) {
            return expression;
        }
        return this;
    }

    @Override
    public Expression nandify() {
        return this;
    }

    @Override
    public Expression norify() {
        return this;
    }
    @Override
    public Expression simplify() {
        return this;
    }
}
