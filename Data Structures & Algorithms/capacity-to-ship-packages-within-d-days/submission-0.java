class Solution {

        public boolean isValid(int[] weights, int days, int m) {
        int t = m, count = 1, sum = 0;
        for (int weight : weights) {
            // System.out.println(sum + weight);
            if (sum + weight <= t) {
                sum += weight;
            } else {
                if (weight > t)
                    return false;
                sum = weight;
                count++;
                if (count > days)
                    return false;
            }
        }
        // System.out.println("m : "+ m + "count : " + count);
        return count <= days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int l = Arrays.stream(weights).max().getAsInt();
        ;
        int h = Arrays.stream(weights).sum();
        // System.out.println(h);
        int ans = h;
        while (l < h) {
            int m = l + (h - l) / 2;
            // System.out.println(m);
            if (isValid(weights, days, m)) {
                ans = m;
                h = m;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

}