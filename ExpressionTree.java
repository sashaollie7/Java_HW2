public class ExpressionTree {
    TreeNode root;
    public ExpressionTree(){
        root = null;
    }
    public void BuildExpressionTree(String postfixExp){
        ExpTokenizer tokenExpr = new ExpTokenizer(postfixExp);
        Stack stack = new StackAsArray();
        while (tokenExpr.hasMoreElements()) {
            Object token = tokenExpr.nextElement();
            if (token instanceof ValueToken){
                TreeNode nd = new TreeNode(token);
                stack.push(nd);
            }
            if (token instanceof BinaryOp){
                TreeNode right = (TreeNode) stack.pop();
                TreeNode left = (TreeNode) stack.pop();

                TreeNode nd = new TreeNode(token,left, right);
                stack.push(nd);
            }
        }
        this.root = (TreeNode) stack.pop();

    }


}
