public class AddOp extends BinaryOp {
    private char addOp;

    public AddOp(){
        super();
        this.addOp='+';
    }

    public double operate(double left, double right){
        return left+right;
    }

    public double getPrecedence(){
        return 1;
    }

    public boolean isequal(AddOp other){
        return other.toString() == "+";
    }

    public String toString(){
        return "+";
    }
}
