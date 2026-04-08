class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
      HashMap<String, List<String>> mp  = new HashMap<>();
      List<List<String>> ans = new ArrayList<>();
      for( String s  : strs ){

        char[] c =  s.toCharArray();
        Arrays.sort(c);
        String sorted  = new String(c);
        List<String> existingList = mp.getOrDefault(sorted, new ArrayList<>());
        existingList.add(s);
        mp.put(sorted, existingList);
      }
      return new ArrayList<>(mp.values());
    }
}
