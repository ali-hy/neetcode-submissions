class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> count = new HashMap<>();
        int l = 0, intersect_len = 0;
        int[] res_lr = new int[] {-1, -1};
        
        // populate count
        for (int i = 0; i < t.length(); i++) {
            count.put(t.charAt(i), count.getOrDefault(t.charAt(i), 0) + 1);
        }

        // sliding window
        for (int r = 0; r < s.length(); r++) {
            int char_count = count.getOrDefault(s.charAt(r), 0) - 1;            

            if (char_count < 0) {
                if (l == r) { // Skip this and don't update count
                    l++;
                    continue;
                }

                count.put(s.charAt(r), char_count);
                continue;
            } 

            count.put(s.charAt(r), char_count);
            intersect_len++;

            System.out.println("before loop\nintersect_len: " + intersect_len + "\nr: " + r);
            while (intersect_len >= t.length()) {
                if (res_lr[0] == -1 || r - l + 1 < res_lr[1] - res_lr[0]) {
                    res_lr[0] = l;
                    res_lr[1] = r + 1;
                }

                System.out.println(l);

                char_count = count.get(s.charAt(l)) + 1; 
                count.put(s.charAt(l), char_count);
                System.out.println(s.charAt(l) + ": " + char_count);
                if (char_count > 0) {
                    intersect_len--;
                }
                l++;
            }
        }

        if (res_lr[0] == -1)
            return "";

        return s.substring(res_lr[0], res_lr[1]);
    }
}
