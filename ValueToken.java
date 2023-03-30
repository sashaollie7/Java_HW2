public class ValueToken extends CalcToken{
    private double val;

    public ValueToken(double val){
        this.val = val;
    }

    public double getValue(){
        return this.val;
    }

    public boolean is_equal(ValueToken other){
        return this.val == other.getValue();
    }

    public String toString(){
        return String.valueOf(this.val);
    }
}
