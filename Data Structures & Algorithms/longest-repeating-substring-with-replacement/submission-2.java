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
        int i = 0 , j = 0 ,ans = 0 ;
        HashMap<Character,Integer> freq = new HashMap<>();
        while(j < n ){
             System.out.println(j);
             freq.merge(s.charAt(j) , 1, Integer::sum);

             if(replacements(freq) <=k){
                ans = Math.max(j- i +1 , ans);
                j++;
             }
             else {
                
                while(replacements(freq) > k) {
                 freq.merge(s.charAt(i) , -1, Integer::sum);
                 i++;
                }

                ans = Math.max(j- i +1 , ans);
                j++;

             }
        } 
        return ans;
    }
}
