package Mivne2_Package;

public class ExpressionTree {
    TreeNode root ;

    public ExpressionTree(String postFix){
        this.BuildExpressionTree(postFix);
    }
    public TreeNode getRoot(){
        return this.root;
    }
    public void BuildExpressionTree(String postfixExp){
        ExpTokenizer tokens = new ExpTokenizer(postfixExp);
        StackAsArray myStack = new StackAsArray();
        int length = tokens.countTokens();
        for(int i = 0; i < length; i++){
            Object curr = tokens.nextElement();
            if (curr instanceof ValueToken){
                TreeNode node = new TreeNode(curr);
                myStack.push(node);

            }else if (curr instanceof BinaryOp){
                TreeNode right = (TreeNode) myStack.pop();
                TreeNode left = (TreeNode) myStack.pop();
                TreeNode newRoot = new TreeNode(curr,left,right);
                myStack.push(newRoot);

            }
        }
        this.root = (TreeNode)myStack.pop();

        
    }
}
