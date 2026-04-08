class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int i  = 0 , j = 0 ; 
        int ans = 0 ;
        HashSet<Character> occ = new HashSet<>();
        while(j < n ){
            if(!occ.contains(s.charAt(j))){
              occ.add(s.charAt(j));
              ans = Math.max(ans, j - i + 1 );
              j++;
            }else {
                
                while(occ.contains(s.charAt(j))){
                    occ.remove(s.charAt(i));
                    i++;
                }

            }
        }

        return ans ; 
    }
}
