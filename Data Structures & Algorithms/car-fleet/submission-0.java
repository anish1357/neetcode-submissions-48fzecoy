class Solution {

    public record Pair(Integer position, Integer speed) {}

    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair> list = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            list.add(new Pair(position[i], speed[i]));
        }

        // Sort by starting position in descending order (farthest to closest to target)
        list.sort((a, b) -> Integer.compare(b.position(), a.position()));

        Stack<Double> stk = new Stack<>();
        for (Pair p : list) {
            double time = (target - p.position()) / (double) p.speed();
            if (stk.isEmpty() || time > stk.peek()) {
                stk.push(time);
            }
            // else, this car catches up to the fleet ahead; do nothing
        }
        return stk.size();
    }

}
