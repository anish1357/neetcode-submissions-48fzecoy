class Solution {
    public String minWindow(String s, String t) {
        int n = t.length(), m = s.length();
        if (n > m) return "";

        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for (char c : t.toCharArray()) {
            freq1.merge(c, 1, Integer::sum);
        }

        int have = 0;
        int need = freq1.size();

        int l = 0, st = 0, e = m;
        boolean flag = false;

        for (int r = 0; r < m; r++) {
            char c = s.charAt(r);
            freq2.merge(c, 1, Integer::sum);

            if (freq1.containsKey(c) && freq2.get(c).equals(freq1.get(c))) {
                have++;
            }

            while (have == need) {
                flag = true;

                if (e - st >= r - l + 1) {
                    e = r;
                    st = l;
                }

                char leftChar = s.charAt(l);
                freq2.put(leftChar, freq2.get(leftChar) - 1);

                if (freq1.containsKey(leftChar) && freq2.get(leftChar) < freq1.get(leftChar)) {
                    have--;
                }

                if (freq2.get(leftChar) == 0) {
                    freq2.remove(leftChar);
                }

                l++;
            }
        }

        return flag ? s.substring(st, e + 1) : "";
    }
}