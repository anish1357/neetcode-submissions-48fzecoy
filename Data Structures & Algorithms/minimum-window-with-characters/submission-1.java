class Solution {
    public boolean isValid(HashMap<Character, Integer> freq1, HashMap<Character, Integer> freq2,Integer l ,Integer r){
        if(freq1.size() > freq2.size()){
            return false;
        }
        // System.out.println("right: " + r + " , left :" + l);
        for(Map.Entry<Character, Integer> entry : freq1.entrySet()){
            Character key = entry.getKey();
            Integer value = entry.getValue();

            if(!freq2.containsKey(key)){
                return false;
            }
            
            Integer value2 = freq2.get(key);
            // System.out.println("key: " + key + " v1 : " + value + " v2 : " + value2);
            if(value > value2)
            return false;
        }
        System.out.println("true");
        return true ;
    }
    public String minWindow(String s, String t) {
        int n = t.length() , m = s.length();
        if(n > m){
            return new String("");
        }
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for(Character c  : t.toCharArray()){
            freq1.merge(c, 1, Integer::sum);
        }
        int l = 0 , st = 0 ,e = m; 
        boolean flag = false;
        for(int r = 0 ; r < m ;r++){

            freq2.merge(s.charAt(r), 1, Integer::sum);
            if(isValid(freq1,freq2,l,r)){
                flag = true;

                while(isValid(freq1,freq2,l,r)  ){
                    // System.out.println("right: " + r + " , left :" + l);
                    freq2.merge(s.charAt(l), -1, Integer::sum);
                    if(freq2.get(s.charAt(l)) == 0){
                        freq2.remove(s.charAt(l));
                    }
                    l++;
                }
                int x = l-1;
               if(e - st >= r - x + 1){
                   e = r;
                   st = x;
               }
            }
        }
      return flag == true ?  s.substring(st,e+1) : new String("");

    }
}
