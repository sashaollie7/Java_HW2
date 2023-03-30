public class StackCalculator extends Calculator {

    public String infixToPostfix(String expr){

        String str = "";
        Stack stack = new StackAsArray();
        ExpTokenizer tokenExpr = new ExpTokenizer(expr);

        while (tokenExpr.hasMoreElements()) {
            Object token = tokenExpr.nextElement();

            if (token instanceof OpenBracket){
                stack.push(token);
                 }
            else if (token instanceof CloseBracket) {
                Object ch = stack.pop();
                while ((!(ch instanceof OpenBracket)) && (!(ch == null))) {
                    str = str + ch + " ";
                    ch = stack.pop();
                }

            }

            else if (token instanceof BinaryOp){
                Object ch = stack.pop();
                boolean check = false;

                while ((ch instanceof BinaryOp) && (((BinaryOp) ch).getPrecedence() >= ((BinaryOp) token).getPrecedence()))
                {
                    str = str + ch +" ";
                    ch = stack.pop();
                    check = true;

                    }
                if (!(ch==null) && ((check==false) || !(ch instanceof OpenBracket)))
                    stack.push(ch);


                stack.push(token);
            }
            else if (token instanceof ValueToken){
                str = str + token+ " ";

            }
        }
        while (!stack.isEmpty()){
            str = str + stack.pop() + " ";

        }

        if ( str.charAt(str.length() - 1) == ' ')
            return str.substring(0, str.length() - 1);

        else return str;
    }


    public double evaluate (String expr){

        ExpTokenizer tokenExpr = new ExpTokenizer(expr);
        Stack stack = new StackAsArray();
        double res = 0;
        while (tokenExpr.hasMoreElements()) {
            Object token = tokenExpr.nextElement();
            if (token instanceof BinaryOp){
                ValueToken x1 = (ValueToken) stack.pop();
                ValueToken x2 = (ValueToken) stack.pop();
                res = ((BinaryOp) token).operate(x2.getValue(), x1.getValue());
                ValueToken res2 = new ValueToken(res);
                stack.push(res2);
                }
            else {
                stack.push(token);
            }
              }
        ValueToken res3 = (ValueToken) stack.pop();
        return res3.getValue();
    }

}
