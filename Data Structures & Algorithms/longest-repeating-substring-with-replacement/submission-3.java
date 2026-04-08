class Solution {

    public int replacements (HashMap<Character,Integer> freq){
            int mx = 0 ;
             int total = 0;
             for(Integer i : freq.values()){
                 mx = Math.max(mx,i);
                 total += i;
             }
             return total - mx ;
    }
    public int characterReplacement(String s, int k) {
        int replacementsLeft = k ;
        int n = s.length();
        int l = 0, ans =0  ;
        HashMap<Character,Integer> freq = new HashMap<>();
        for(int r = 0 ; r < n ; r++){
            freq.merge(s.charAt(r) , 1, Integer::sum);
          while(replacements(freq) > k){
            freq.merge(s.charAt(l), -1, Integer::sum);
            l++;
          }
          ans = Math.max(r - l +1 , ans);
        }
       
        return ans;
    }

    


    
}
