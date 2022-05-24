package Mivne2_Package;

public class TreeCalculator extends Calculator {
    ExpressionTree expression;

    public TreeCalculator(String postfix){
        this.expression = new ExpressionTree(postfix);
    }

    @Override
    public double evaluate(String expr) {//expr is postfix
        ExpressionTree expression = new ExpressionTree (expr);
        return evaluateExpression(expression.getRoot());

    }
    private double evaluateExpression(TreeNode node){
        double res;
        if (node.getData() instanceof BinaryOp){
            double op1 = evaluateExpression(node.getLeft());
            double op2 = evaluateExpression(node.getRight());
            res = ((BinaryOp) node.getData()).operate(op1,op2);
        } else {
            res = ((ValueToken)node.getData()).getValue();
        }
        return res;

    }

    public String getInfix(){  // must be O(n)
        TreeNode root = this.expression.getRoot();
        return getInfixRec(root,"");
    }

    private String getInfixRec(TreeNode root,String res){
        if(root.isLeaf()){
            return " "+root.getData().toString()+" ";
        }

        res +="("+ getInfixRec(root.getLeft(),"");
        res += root.getData().toString();
        res += getInfixRec(root.getRight(),"") +")";

        return res;

    }





    ////////////////////

    public String getPostfix(){  // must be O(n)
        TreeNode root = this.expression.getRoot();
        String res = getPostfixRec(root,"");
        String str_res = res.substring(0,res.length()-1);
        return str_res ;
    }

    private String getPostfixRec(TreeNode root,String res){
        if(root.isLeaf()){
            return root.getData().toString()+" ";
        }

        res +=getPostfixRec(root.getLeft(),"");
        res += getPostfixRec(root.getRight(),"");
        res += root.getData().toString()+ " ";

        return res;


    }









    ////////////





    public String getPrefix(){  // must be O(n)
        TreeNode root = this.expression.getRoot();
        return getPrefixRec(root,"");

    }
    private String getPrefixRec(TreeNode root, String res){
        if(root.isLeaf()){
            return root.getData().toString()+" ";
        }
        res += root.getData().toString()+ " ";
        res +=getPrefixRec(root.getLeft(),"");
        res += getPrefixRec(root.getRight(),"");


        return res;
    }

}
