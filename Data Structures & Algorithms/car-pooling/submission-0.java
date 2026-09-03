class Solution {
    public record Entry(int time, int change){};
    public boolean carPooling(int[][] trips, int capacity) {
    Map<Integer,List<Integer>> mp = new HashMap<>();    

    for(int[] a : trips){
        mp.computeIfAbsent(a[1], k -> new ArrayList<>()).add(a[0]);
        mp.computeIfAbsent(a[2], k -> new ArrayList<>()).add(-a[0]);
    }

    PriorityQueue<Map.Entry<Integer,List<Integer>>> pq = new PriorityQueue<>(
        (a,b) -> 
         a.getKey() - b.getKey()
    );
    for(Map.Entry<Integer, List<Integer>> e : mp.entrySet()){
        pq.offer(e);
    }
    int curCapacity = 0 ;
    while(!pq.isEmpty()){
     
     curCapacity += pq.poll()          
                        .getValue()
                        .stream()
                        .mapToInt(Integer::intValue)
                        .sum();

        if(curCapacity > capacity){
            return false;
        }               
    }
    return true;
    }
}