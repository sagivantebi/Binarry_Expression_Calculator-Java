// ID: 318159282

import java.util.Map;
import java.util.TreeMap;

/**
 * @author SAGIV ANTEBI
 * A class of ExpressionsTest
 * The class tets the code
 */
public class ExpressionsTest {
    /**
     * .
     * main - will test the code
     *
     * @param args - the arguments
     */
    public static void main(String[] args) {
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        //Create an expression with at least three variables
        Expression exp = new And(new And(x, x), new Or(y, z));
        //print the expression
        System.out.println(exp);
        Map<String, Boolean> ass = new TreeMap<>();
        ass.put("x", true);
        ass.put("y", false);
        ass.put("z", true);
        //Print the value of the expression with an assignment to every variable.
        try {

            System.out.println(exp.evaluate(ass));
        } catch (Exception e) {
        }
        System.out.println(exp.nandify());
        System.out.println(exp.norify());
        System.out.println(exp.simplify());
    }
}
