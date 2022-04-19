import java.util.ArrayList;
import java.util.List;
import java.util.Map;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * A class of Val
 * The class implements Expression and is the 'Val' logical expressin.
 * The values will be boolean.
 */
public class Val implements Expression {
    private Boolean aBoolean;

    /**
     * .
     * Val - constructor.
     *
     * @param aBoolean - the Boolean value.
     */
    public Val(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.aBoolean;
    }

    @Override
    public Boolean evaluate() throws Exception {
        return this.aBoolean;
    }

    @Override
    public String toString() {
        //checks if the val is true
        if (this.aBoolean) {
            return ("T");
        }
        return ("F");
    }

    @Override
    public List<String> getVariables() {
        //returning an Empty list
        List<String> list = new ArrayList<String>();
        return list;
    }

    @Override
    public Expression assign(String var, Expression expression) {
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
