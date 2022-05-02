package Mivne2_Package;

public class AddOp extends BinaryOp {

    public AddOp(){
        this.op = '+';
    }

    @Override
    public double getPrecedence() {
        return 1;
    }

    @Override
    public double operate(double left, double right) {
        return right + left;
    }


    @Override
    public String toString() {
        return ""+this.op;
    }


}
