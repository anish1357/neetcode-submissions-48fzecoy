class Solution {
    public boolean isPalindrome(String s) {
     String result = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
     System.out.println(result);
     int len = result.length();
     for(int i = 0 ; i< len/2 ;i++){
        if(result.charAt(i) != result.charAt(len-i-1)){
            System.out.println(i);
            return false;
        }
     }
     return true;
    }
}
