class Solution {
    public int lengthOfLongestSubstring(String s) {
        int map[] = new int[256], res = 0, l = 0, r = 0;
        
        while (r < s.length()) {
            char c = s.charAt(r);
            map[c]++;

            r++;

            if (map[c] < 2) {
                continue;
            }

            if (r - l - 1 > res) {
                res = r - l - 1;
            }

            while (map[c] > 1) {
                map[s.charAt(l)]--;
                l++;
            }
        }

        return res > r - l ? res : r - l;
    }
}
