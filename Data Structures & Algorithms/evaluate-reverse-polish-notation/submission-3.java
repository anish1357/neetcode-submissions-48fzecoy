class Solution {
    public Integer evaluate(Integer first, Integer second, String operation){
        return switch(operation){
            case "+" ->  first + second;
            case "-" ->  second - first;
            case "*" ->  first*second;
            case "/" ->  second/first;
            default -> throw new IllegalArgumentException("Invalid operation");
        };
    }
    public int evalRPN(String[] tokens) {
        Stack<Integer> stk = new Stack<>();
        for(String token : tokens){
            if(token.equals("+") || token.equals("-") || token.equals("*") ||token.equals("/")){
              Integer first = stk.pop();
              Integer second = stk.pop();
              
               stk.push(evaluate(first,second,token));
            }else {
            stk.push(Integer.valueOf(token));
            }

        }
        return stk.peek();
    }
}
