class MedianFinder {
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if(maxHeap.size() < minHeap.size()){
            maxHeap.offer(minHeap.poll());

        }
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size())
        return (maxHeap.peek() + minHeap.peek())/2.0;
        return maxHeap.peek();
    }
}
