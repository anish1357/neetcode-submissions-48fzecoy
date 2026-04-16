class Solution {
    public boolean search(int[] nums, int target) {
        int l = 0, h = nums.length - 1;

        while (l <= h) {
            int m = l + (h - l) / 2;

            if (nums[m] == target) return true;

            // Left half is sorted
            if (nums[m] < nums[h]) {
                if (target <= nums[h] && target > nums[m]) {
                    l = m + 1;
                } else {
                    h = m - 1;
                }
            } 
            // Right half is sorted
            else if (nums[h] < nums[m]) {
                if (target < nums[m] && target >= nums[l]) {
                    h = m - 1;
                } else {
                    l = m + 1;
                }
            }else {
                h--;
            }
        }
        return false;
    }
}