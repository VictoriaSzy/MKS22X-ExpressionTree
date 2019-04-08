public class ExpressionTree {

  private char op;
  private double value;
  private ExpressionTree left,right;

  public static void main(String[] args){
    //ugly main sorry!
    ExpressionTree a = new ExpressionTree(4.0);
    ExpressionTree b = new ExpressionTree(2.0);

    ExpressionTree c = new ExpressionTree('+',a,b);
    System.out.println(c);
    System.out.println(c.toStringPostfix());
    System.out.println(c.toStringPrefix());
    System.out.println(c.evaluate());//6.0

    ExpressionTree d = new ExpressionTree('*',c,new ExpressionTree(3.5));
    System.out.println(d);
    System.out.println(d.toStringPostfix());
    System.out.println(d.toStringPrefix());
    System.out.println(d.evaluate());//21

    ExpressionTree ex = new ExpressionTree('-',d,new ExpressionTree(1.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//20

    ex = new ExpressionTree('+',new ExpressionTree(1.0),ex);
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//21

    ex = new ExpressionTree('/',ex,new ExpressionTree(2.0));
    System.out.println(ex);
    System.out.println(ex.toStringPostfix());
    System.out.println(ex.toStringPrefix());
    System.out.println(ex.evaluate());//10.5
  }

  /*TreeNodes are immutable, so no issues with linking them across multiple
  *  expressions. The can be constructed with a value, or operator and 2
  * sub-ExpressionTrees*/
  public ExpressionTree(double value){
    this.value = value;
    op = '~';
  }
  public ExpressionTree(char op,ExpressionTree l, ExpressionTree r){
    this.op = op;
    left = l;
    right = r;
  }

  public char getOp(){
    return op;
  }

  /* accessor method for Value, precondition is that isValue() is true.*/
  private double getValue(){
    return value;
  }
  /* accessor method for left, precondition is that isOp() is true.*/
  private ExpressionTree getLeft(){
    return left;
  }
  /* accessor method for right, precondition is that isOp() is true.*/
  private ExpressionTree getRight(){
    return right;
  }

  private boolean isOp(){
    return hasChildren();
  }
  private boolean isValue(){
    return !hasChildren();
  }

  private boolean hasChildren(){
    return left != null && right != null;
  }

  /*return the expression as an infix notation string with parenthesis*/
  /* The sample tree would be: "(3 + (2 * 10))"     */
  public String toString() {
    /*you are to write this method*/
    return infixH(this) ;
  }
  public String infixH(ExpressionTree start) {
    String res = "(" ;
    if (start == null) return res + ")" ;
    res += infixH(start.getLeft()) + ")" ;
    res += start.getOp() + "(" ;
    res += infixH(start.getRight()) + ")" ;
    return res ;
  }

  /*return the expression as a postfix notation string without parenthesis*/
  /* The sample tree would be: "3 2 10 * +"     */
  public String toStringPostfix() {
    /*you are to write this method*/
    return sPFH(this) ;
  }
  public String sPFH(ExpressionTree start) {
    String res = "" ;
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
    return perform(getOp(), evalH(getLeft()), evalH(getRight())) ;
  }
  public double evalH(ExpressionTree start) {
    if (start.isValue()) return start.getValue() ;
    else {
      // now we have to do the operation
      double r = 0.0 ;
      r = perform(start.getOp(), evalH(start.getLeft()), evalH(start.getRight())) ;
      return r ;
    }
  }

  /*use the correct operator on both a and b, and return that value*/
  private double apply(char op, double a, double b) {
    /*you are to write this method*/

    return 0.0;
    }


}
