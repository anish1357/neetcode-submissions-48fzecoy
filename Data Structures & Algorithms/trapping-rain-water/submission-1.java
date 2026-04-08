class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] leftSide = new int[n];
        int[] rightSide = new int[n];
        leftSide[0] = height[0];
        rightSide[n-1] = height[n-1] ;
        for(int i = 1; i < n ;i++){
            leftSide[i] = Math.max(leftSide[i-1],height[i]);
        }
        for(int i = n-2 ; i>=0;i--){
            rightSide[i] = Math.max(rightSide[i+1],height[i]);
        }
        int waterCollected = 0 ; 
        for(int i = 0 ; i < n ; i++){
            waterCollected += Math.min(leftSide[i],rightSide[i]) - height[i];
            // System.out.println(waterCollected);
        }

        return waterCollected ;
    }
}
