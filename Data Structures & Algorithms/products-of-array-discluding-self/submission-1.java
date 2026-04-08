class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] lSum = new int[nums.length];
        int[] rSum = new int[nums.length];
        int[] ans = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            lSum[i] = i ==  0 ? 1 : nums[i-1]*lSum[i-1]; 
        }
        for(int i = nums.length -1  ; i >= 0  ; i--){
            rSum[i] = i ==  nums.length-1 ? 1: nums[i+1]*rSum[i+1]; 
        }

        for(int i = 0 ; i <  nums.length ; i++){
                ans[i] = lSum[i]*rSum[i];
        }
        return ans;
    }
}  
