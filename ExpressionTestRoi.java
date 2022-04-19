/**
 * @author Roi Avraham id: 318778081.
 * Check the correctness and the possibilities of the project.
 */
public class ExpressionTestRoi {

    /**
     * Main method to show the possibilities of the project.
     * @param args from command line.
     */
    public static void main(String[] args) {
        Var x = new Var("x");
        Var y = new Var("y");
        Var z = new Var("z");
        Expression e = new And(new And(x, y), new Or(y, z));
        System.out.println(e.toString());
        Expression e1 = e.assign(x.toString(), new Val(true));
        Expression e2 = e1.assign(y.toString(), new Val(true));
        Expression e3 = e2.assign(z.toString(), new Val(false));
        System.out.println(e3.toString());
        System.out.println(e3.nandify().toString());
        System.out.println(e3.norify().toString());
        System.out.println(e3.simplify().toString());
    }
}
