class Solution {
    public record Point(int[] point, int distance){};
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>((x,y)-> y.distance - x.distance);
        for(int[] i :  points){
            int distance = i[0]*i[0] + i[1]*i[1];
           if(pq.size() < k) {
           pq.offer(new Point(i, distance));
           }else {
            if(distance < pq.peek().distance){
                pq.poll();
                pq.offer(new Point(i, distance));
            }
           }
        }
        int[][] ans = new int[k][2];
        for(int i = 0 ; i < k ; i++){
        ans[i] = pq.poll().point;
        }

        return ans;

    }
}
