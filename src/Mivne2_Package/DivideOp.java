package Mivne2_Package;

public class DivideOp extends BinaryOp{
    public DivideOp(){
        this.op = '/';
    }

    @Override
    public double getPrecedence() {
        return 2;
    }

    @Override
    public double operate(double left, double right) {
        return left / right;
    }


    @Override
    public String toString() {
        return ""+this.op;
    }
}
