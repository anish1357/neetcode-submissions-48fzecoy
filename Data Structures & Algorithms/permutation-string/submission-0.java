class Solution {
    public static boolean isValid(Map<Character, Integer> map1, Map<Character, Integer> map2) {
      if(map1.size() > map2.size()){
        return false;
      }

    for (Map.Entry<Character, Integer> entry : map1.entrySet()) {
        Character key = entry.getKey();
        Integer val1 = entry.getValue();

        if (!map2.containsKey(key)) {
            return false;
        }

        Integer val2 = map2.get(key);
        if (val1 > val2) {
            return false;
        }
    }
    return true;
}
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length() , m = s2.length();
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for(char c : s1.toCharArray()){
            freq1.merge(c, 1, Integer::sum);
        }
        int l = 0;
        for(int r = 0 ; r < m; r++){
            freq2.merge(s2.charAt(r), 1 , Integer::sum);
            while(r-l+1 > n){
                freq2.merge(s2.charAt(l), -1, Integer::sum);
                if(freq2.get(s2.charAt(l)) == 0){
                    freq2.remove(s2.charAt(l));
                }
                l++;
            }
            if(isValid(freq1, freq2)){
                return true;
            }
        }
        return false;

    }
}
