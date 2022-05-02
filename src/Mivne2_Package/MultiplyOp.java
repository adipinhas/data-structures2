package Mivne2_Package;

public class MultiplyOp extends BinaryOp {

    public MultiplyOp(){
        this.op = '*';
    }

    @Override
    public double getPrecedence() {
        return 2;
    }

    @Override
    public double operate(double left, double right) {
        return right * left;
    }


    @Override
    public String toString() {
        return ""+this.op;
    }
}
