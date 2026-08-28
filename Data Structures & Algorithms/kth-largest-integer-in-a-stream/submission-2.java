class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int k ;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i : nums ){
           if(minHeap.size() < k){
            minHeap.offer(i);
           }
           else {
              if( i > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(i);
              }

           }
           
        }
    }
    
    public int add(int val) {
        if(minHeap.size() < k){
            minHeap.offer(val);
           }
        else if(val > minHeap.peek()){
            minHeap.poll();
            minHeap.offer(val);
        }
        
        return minHeap.peek();
    }
}
