public class TreeCalculator extends Calculator{
    private TreeNode root;

    public double evaluate (String expr){

        ExpressionTree expTree = new ExpressionTree();
        expTree.BuildExpressionTree(expr);
        this.root = expTree.root;
        return evaluateExpression(expTree.root);
    }
    private double evaluateExpression(TreeNode node){
        if (node.data instanceof BinaryOp){
            double operand1 = evaluateExpression(node.left);
            double operand2 = evaluateExpression(node.right);
            return ((BinaryOp) node.data).operate(operand1,operand2);
        }
        else {
            ValueToken token = (ValueToken) node.data;
            return token.getValue();
        }
    }

    public String getInfix(){return rec_getInfix(this.root);}

    private String rec_getInfix(TreeNode node){
        if (node.isLeaf()){
            return node.data.toString();
        }
        String left, right, mid = "";
        left = rec_getInfix(node.left);
        mid = node.data.toString();
        right = rec_getInfix(node.right);
        return "(" + " " + left + " " + mid + " " + right + " " + ")";

    }
    public String getPostfix(){
        String str = this.getInfix();
        StackCalculator st = new StackCalculator();
        return st.infixToPostfix(str);
    }

    public String getPrefix(){return rec_getPrefix(this.root);}

    private String rec_getPrefix(TreeNode node){
        if (node.isLeaf()){
            return node.data.toString();
        }
        String left, right, mid = "";
        mid = node.data.toString();
        left = rec_getPrefix(node.left);
        right = rec_getPrefix(node.right);
        return mid + " " + left + " " + right;

    }


    }
