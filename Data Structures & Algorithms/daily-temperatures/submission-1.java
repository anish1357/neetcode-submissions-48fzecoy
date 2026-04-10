class Solution {

    public record Temp(Integer temperature, Integer index) {}

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Temp> stk  = new Stack<>();
         for(int i = n-1 ; i >=0 ; i--){
            while( !stk.isEmpty() && temperatures[i] >= stk.peek().temperature()){
                stk.pop();
            }
            ans[i] = stk.empty() ? 0 : stk.peek().index() - i;
            stk.push(new Temp(temperatures[i],i));
         }
         return ans ;
    }
}
