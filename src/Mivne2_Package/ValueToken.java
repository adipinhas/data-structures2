package Mivne2_Package;

public class ValueToken extends CalcToken {
    private double val;
    
    
    public ValueToken(double val){
        this.val = val;

    }
    public double getValue(){
        return this.val;
    }
    public String toString(){

        return ""+(int)this.val;
    }
    
}
