class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>(
            (e1, e2) -> e2.getValue() - e1.getValue()
        );

        int[] res = new int[k];

        for(int n : nums) {
            Integer current = map.get(n);
            current = current == null ? 0 : current;
            map.put(n, current + 1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.add(entry);
        }

        for (int i = 0; i < k; i++) {
            res[i] = q.poll().getKey();
        }

        return res;
    }
}
