class Solution {
    public boolean isValid(int[] nums, int k , int m){
        int count = 1 ,  sum = 0;
        for(int num : nums){
            if(sum + num <= m){
                sum += num;
            }else {
                sum = num;
                count++;
                if(count > k) return false;
            }
        }
        return count <= k ;
    }
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int h = Arrays.stream(nums).sum();
        int ans = h ;
        while(l < h){
            int m = l + (h-l)/2;
            if(isValid(nums, k, m)){
                ans = m ;
                h = m ;
            }else {
                l = m +1 ;
            }
        }
        return ans ; 
    }
}