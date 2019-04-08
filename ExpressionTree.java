public class ExpressionTree {
  /*return the expression as an infix notation string with parenthesis*/
  /* The sample tree would be: "(3 + (2 * 10))"     */
  public String toString() {
    /*you are to write this method*/
    return infixH(this) ;
  }
  public String infix(ExpressionTree start) {
    String res = "(" ;
    if (start == null) return res + ")" ;
    res += infixH(start.getLeft()) + ")" ;
    res += start.getOp() + "(" ;
    res += infixH(start.getRight()) + ")"
    return res ;
  }

  /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  public String toStringPostfix() {
    /*you are to write this method*/
    return sPFH(this) ;
  }
  public String sPFH(ExpressionTree start) {
    res = "" ;
    if (start == null) return res ;
    res += sPFH(start.getLeft()) ;
    res += sPFH(start.getRight()) ;
    return res ;
  }

  /*return the expression as a prefix notation string without parenthesis*/
  /* The sample tree would be: "+ 3 * 2 10"     */

  public String toStringPrefix() {
    /*you are to write this method*/
    return prefixH(this) ;
  }
  public String prefixH(ExpressionTree start) {
    String res = "" ;
    if (start.isValue()) res += start.getValue() ;
    if (start.isOp()) res += start.getOp() ;
    res += prefixH(start.getLeft()) ;
    res += prefixH(start.getRight()) ;
    return res ;
  }

  /*return the value of the specified expression tree*/
  public double evaluate() {
    /*you are to write this method*/
    return 0.0;
    }

  /*use the correct operator on both a and b, and return that value*/
  private double apply(char op, double a, double b) {
    /*you are to write this method*/

    return 0.0;
    }


}
