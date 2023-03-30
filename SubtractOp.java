public class SubtractOp extends BinaryOp {
    private char subOp;

    public SubtractOp(){
        super();
        this.subOp='-';
    }
    public double operate(double left, double right){
        return left-right;
    }

    public double getPrecedence(){
        return 1;
    }

    public boolean isequal(SubtractOp other){
        return other.toString() == "-";
    }

    public String toString(){
        return "-";
    }
}
