class Solution {
    public String toKey(int[] freq) {
        StringBuilder sb = new StringBuilder();
        for (char i = 0; i < freq.length; i++) {
            int f = freq[i];
            char c = (char)(i + 'a');
            if (f <= 0)
                continue;
            
            sb.append(String.format("%c%d", c, f));
        }

        return sb.toString();
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int[] freq = new int[26];
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            str.chars().forEach(c -> freq[c - 'a']++ );

            String key = toKey(freq);
            List<String> curr = map.get(key);
            if (curr == null) {
                curr = new ArrayList<>();
                map.put(key, curr);
            }

            curr.add(str);

            for (int i = 0; i < freq.length; i++) {
                freq[i] = 0;
            }
        }

        return new ArrayList<>(map.values());
    }
}
