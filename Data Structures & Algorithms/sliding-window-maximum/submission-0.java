

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        
        Deque<Integer> dq = new LinkedList<>(); 
        int idx = 0;

        for (int r = 0; r < n; r++) {
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[r]) {
                dq.pollLast();
            }

            dq.addLast(r);

            if (dq.peekFirst() < r - k + 1) {
                dq.pollFirst();
            }

            if (r >= k - 1) {
                res[idx++] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
}