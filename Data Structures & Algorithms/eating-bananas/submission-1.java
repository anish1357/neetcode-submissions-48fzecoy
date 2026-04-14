class Solution {
    boolean isValid(int[] piles, int h, int m){
        int ans = 0 ; 
        for(int pile : piles ){
            ans += pile % m == 0  ? pile/m : pile/m + 1;  
        }
        return ans <= h ;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int high = Arrays.stream(piles).max().getAsInt(); 
        int low = 1; 
        int ans = 0 ;
        while(low <= high ){
            int mid = low + (high-low)/2;
            if(isValid(piles,h,mid)){
              ans = mid;
              high = mid -1;
            }else {
                low = mid +1 ; 
            }
        }
      return ans ;
    }
}
