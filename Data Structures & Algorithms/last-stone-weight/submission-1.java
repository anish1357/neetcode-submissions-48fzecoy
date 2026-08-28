class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i : stones){
            pq.offer(i);
        }
        while(pq.size() > 1){
            Integer s1 = pq.poll();
            Integer s2 = pq.poll();

            if(!s1.equals(s2)){
                pq.offer(Math.abs(s2-s1));
            }
        }
        return pq.isEmpty() ? 0 : pq.peek();
    }
}
