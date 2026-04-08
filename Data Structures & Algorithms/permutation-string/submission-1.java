class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length(), m = s2.length();
        if (n > m) return false;

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (char c : s1.toCharArray()) {
            freq1.merge(c, 1, Integer::sum);
        }

        int have = 0;
        int need = freq1.size();

        int l = 0;

        for (int r = 0; r < m; r++) {
            char c = s2.charAt(r);
            freq2.merge(c, 1, Integer::sum);

            // update have
            if (freq1.containsKey(c) && freq2.get(c).equals(freq1.get(c))) {
                have++;
            }

            // maintain window size = n
            if (r - l + 1 > n) {
                char leftChar = s2.charAt(l);

                if (freq1.containsKey(leftChar) && 
                    freq2.get(leftChar).equals(freq1.get(leftChar))) {
                    have--; // losing a valid char
                }

                freq2.put(leftChar, freq2.get(leftChar) - 1);

                if (freq2.get(leftChar) == 0) {
                    freq2.remove(leftChar);
                }

                l++;
            }

            // check match
            if (have == need) {
                return true;
            }
        }

        return false;
    }
}