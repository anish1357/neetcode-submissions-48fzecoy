

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> dq = new LinkedList<>(); 
        int idx = 0;

        for (int r = 0; r < n; r++) {


            //maintain a monotonic stack in decreasing order 
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }

            dq.addLast(r);


            // remove element which becomes out of the window 
            if (dq.peekFirst() < r - k + 1) {
                dq.pollFirst();
            }
            

            //If the current Window size becomes at least k , we get the first window and we need to 
            //start storing answer  
            if (r >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}