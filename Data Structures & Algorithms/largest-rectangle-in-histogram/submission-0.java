class Solution {
    public record StackValue(int index, int height){}
    public int largestRectangleArea(int[] heights) {
        Stack<StackValue> stk = new Stack<>();
        int maxArea = 0 ;
        for(int i = 0 ; i< heights.length ; i++){
            int startIndex = i ;
            while(!stk.isEmpty() && stk.peek().height() > heights[i]){
                StackValue sv = stk.pop();
                int area = (i - sv.index())*sv.height();
                maxArea = Math.max(maxArea, area);
                startIndex = sv.index();
            }
            stk.add(new StackValue(startIndex, heights[i]));
        }
        int n = heights.length;
        while(!stk.isEmpty()){
           StackValue sv = stk.pop();
           int area = (n - sv.index())*sv.height();
           maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
