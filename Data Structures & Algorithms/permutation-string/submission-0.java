class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l = 0;
        Map<Character, Integer> count = new HashMap<>(); 

        // populate count
        for (int i = 0; i < s1.length(); i++) {
            count.put(s1.charAt(i), count.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // sliding window
        for (int r = 0; r <s2.length(); r++) {
            count.put(s2.charAt(r), count.getOrDefault(s2.charAt(r), 0) - 1);

            while(count.get(s2.charAt(r)) < 0) {
                count.put(s2.charAt(l), count.get(s2.charAt(l)) + 1);
                l++;
            }

            if (r - l + 1 == s1.length()) {
                return true;
            }
        }

        return false;
    }
}
