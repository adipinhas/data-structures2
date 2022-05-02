package Mivne2_Package;

public class StackCalculator extends Calculator{
    @Override
    public double evaluate(String expr) { // expr is postfix
        ExpTokenizer tokens = new ExpTokenizer(expr);
        StackAsArray myStack = new StackAsArray();
        int length = tokens.countTokens();
        for(int i = 0; i < length; i++){
            Object curr = tokens.nextElement();
            if(curr instanceof BinaryOp){
                Object right = myStack.pop();
                Object left = myStack.pop();
                myStack.push(new ValueToken(((BinaryOp) curr).operate(((ValueToken)left).getValue(),((ValueToken)right).getValue())));
            }else{
                myStack.push(curr);
            }
        }
        ValueToken popped = (ValueToken)myStack.pop() ;
        double val = popped.getValue();

        return val;
    }

    public String infixToPostfix(String expr){  //  expr is infix, we need to convert to postfix
        ExpTokenizer tokens = new ExpTokenizer(expr);
        String str = "";
        StackAsArray stack = new StackAsArray();
        int lenTokens = tokens.countTokens();
        for (int i = 0; i < lenTokens ; i++){
            Object curr = tokens.nextElement();
            if (curr instanceof OpenBracket){
                stack.push(curr);
            }
            else if(curr instanceof CloseBracket){
                    while (!stack.isEmpty()) {
                        Object popped = stack.pop();
                        if (popped instanceof OpenBracket){
                            break;
                        }
                        str +=popped.toString()+" ";
                }
            } else if(curr instanceof BinaryOp){
                double prec = ((BinaryOp) curr).getPrecedence();
                while (!stack.isEmpty()) {
                        Object popped = stack.pop();
                        if (popped instanceof OpenBracket || popped instanceof CloseBracket || prec > ((BinaryOp) popped).getPrecedence()) {
                            if(popped instanceof BinaryOp){
                                stack.push(popped);
                            }
                            break;
                        }
                        str += stack.pop().toString() + " ";
                    }
                stack.push(curr);

            } else if (curr instanceof ValueToken){
                str +=curr.toString()+" ";
            }


        }
        while (!stack.isEmpty()){
            str += stack.pop().toString() + " ";


        }
        String str_res = str.substring(0,str.length()-1);

// delete last space
    return str_res;



    }

}





























//        ExpTokenizer input = new ExpTokenizer(expr);
//        String str = "";
//        StackAsArray stack = new StackAsArray();
//        int length = input.countTokens();
//        for(int i = 0; i < length; i++){
//            System.out.println(i);
//            Object curr = input.nextElement();
//            System.out.println(curr+"curr");
//            if(curr instanceof OpenBracket){
//                stack.push(curr);
//            }else if( curr instanceof CloseBracket){
//                while (true) {
//                    if (!stack.isEmpty()) {
//                        Object popped = stack.pop();
//                        if (popped instanceof OpenBracket) {
//                            break;
//                        }
//                        if (popped != null) {
//                            str += popped.toString();
//                        }
//                    }
//                }
//            }else if(curr instanceof BinaryOp){
//                double prec = ((BinaryOp) curr).getPrecedence();
//                while (true){
////                    if() \\\  if is empty dont pop, same above
//                    if (!stack.isEmpty()) {
//                        Object popped = stack.pop();
//
//
//                        if ((popped instanceof BinaryOp && ((BinaryOp) popped).getPrecedence() < prec) || (popped instanceof OpenBracket || popped instanceof CloseBracket)) {
////                        stack.push(popped);  ///  might not be needed
//                            stack.push(curr);
//                            break;
//                        }
//                        str += popped.toString();
//                    }
//                }
//            }else if(curr instanceof ValueToken){
//                str += curr.toString();
//            }
//        }
//        while (!stack.isEmpty()){
//            str += (stack.pop()).toString();
//        }
//        return str;
//    }


