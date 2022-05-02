package Mivne2_Package;

public class SubtractOp extends BinaryOp{

    public SubtractOp(){
        this.op = '-';
    }

    @Override
    public double getPrecedence() {
        return 1;
    }

    @Override
    public double operate(double left, double right) {
        return left - right;
    }


    @Override
    public String toString() {
        return ""+this.op;
    }


}
