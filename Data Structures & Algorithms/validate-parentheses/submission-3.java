class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<>();
        for(Character c : s.toCharArray()){
            if(c.equals('(') || c.equals('{') || c.equals('['))
            stk.push(c);
            else if(c.equals(')') && !stk.empty() && stk.peek() == '('){
                stk.pop();
            }else if(c.equals('}') && !stk.empty() && stk.peek() == '{'){
                stk.pop();
            }else if(c.equals(']') && !stk.empty() && stk.peek() == '['){
                stk.pop();
            }else {
                return false;
            }
      

        }
           return stk.empty() ;  
    }
}
