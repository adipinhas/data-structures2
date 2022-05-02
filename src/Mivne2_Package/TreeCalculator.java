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
        return "";
    }

    public String getPostfix(){  // must be O(n)
        return "";
    }

    public String getPrefix(){  // must be O(n)
        return "";
    }

}
