class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int res = 0;

        for(int n : nums) {
            if (map.containsKey(n)) {
                continue;
            }

            int[] prev = map.get(n - 1),
                next = map.get(n + 1),
                curr = new int[] { n, n + 1 };

            if (prev != null) {
                curr[0] = prev[0];
            }
            if (next != null) {
                curr[1] = next[1];
            }

            if (prev != null) {
                int[] start = map.get(prev[0]);
                start[1] = curr[1];
            }
            if (next != null) {
                int[] end = map.get(next[1] - 1);
                end[0] = curr[0];
            }
            
            map.put(n, curr);

            res = Math.max(curr[1] - curr[0], res);
        }

        return res;
    }
}
