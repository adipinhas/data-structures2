package Mivne2_Package;

public class PowOp extends BinaryOp {
    public PowOp(){
        this.op = '^';
    }

    @Override
    public double getPrecedence() {
        return 3;
    }

    @Override
    public double operate(double left, double right) { return Math.pow(left, right); }


    @Override
    public String toString() {
        return ""+this.op;
    }
}
