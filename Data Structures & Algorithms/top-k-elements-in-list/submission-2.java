class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();

        for( int  i : nums){
            mp.merge(i,1,Integer::sum);
        }

       return  mp.entrySet()
                            .stream()
                            .sorted((a,b) -> b.getValue() - a.getValue())
                            .limit(k)
                            .map(Map.Entry::getKey)
                            .mapToInt(Integer::intValue)
                            .toArray();

    }
}
