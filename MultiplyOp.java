public class MultiplyOp extends BinaryOp {
    private char mulOp;

    public MultiplyOp(){
        super();
        this.mulOp='*';
    }
    public double operate(double left, double right){
        return left*right;
    }

    public double getPrecedence(){
        return 2;
    }

    public boolean isequal(MultiplyOp other){
        return other.toString() == "*";
    }

    public String toString(){
        return "*";
    }
}
