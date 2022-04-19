import java.util.List;
import java.util.Map;
// ID: 318159282

/**
 * @author SAGIV ANTEBI
 * An interface of Expression
 * The interface represent methods of Expression
 */
public interface Expression {
    /**
     * evaluate - Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @param assignment - the all logical equation (the map of Expression)
     * @return true - if the logical equation is equal to true | else otherwise.
     * @throws Exception - if the logical expression is not in the map
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * evaluate - Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     *
     * @return true - if the logical equation is equal to true | else otherwise.
     * @throws Exception - if the logical expression is not in the map
     */
    Boolean evaluate() throws Exception;

    /**
     * getVariables - Returns a list of the variables in the expression.
     *
     * @return - a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * toString - Returns a nice string representation of the expression.
     *
     * @return - a nice string representation of the expression.
     */
    String toString();

    /**
     * assign - a new expression in which all occurrences of the variable
     * var are replaced with the provided expression (Does not modify the current expression).
     *
     * @param var        - the var to replace the val in.
     * @param expression - our original expression.
     * @return the new expression
     */
    Expression assign(String var, Expression expression);


    /**
     * .
     * nandify - Returns the expression tree resulting from converting all the operations to the logical Nand operation.
     *
     * @return - expression
     */
    Expression nandify();

    /**
     * norify - Returns the expression tree resulting from converting all the operations to the logical Nor operation.
     *
     * @return - expression
     */
    Expression norify();

    /**
     * simplify - Returned a simplified version of the current expression.
     *
     * @return - a simplified version of the current expression.
     */
    Expression simplify();
}