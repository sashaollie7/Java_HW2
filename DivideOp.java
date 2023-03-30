public class DivideOp extends BinaryOp {
    private char divOp;

    public DivideOp(){
        super();
        this.divOp='/';
    }
    public double operate(double left, double right){
        return left/right;
    }

    public double getPrecedence(){
        return 2;
    }

    public boolean isequal(DivideOp other){
        return other.toString() == "/";
    }

    public String toString(){
        return "/";
    }

}
