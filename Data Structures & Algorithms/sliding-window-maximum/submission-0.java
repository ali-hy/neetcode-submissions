class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        TreeMap<Integer, Integer> count = new TreeMap<>();
        int maxOffset = nums.length - k;
        int res[] = new int[maxOffset + 1];

        for (int i = 0; i < k; i++) {
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
        }

        for (int i = 0; i < maxOffset + 1; i++) {
            if (i > 0) {
                int n = count.put(nums[i-1], count.get(nums[i-1]) - 1);
                if (n == 1) {
                    count.remove(nums[i-1]);
                }
            }

            res[i] = count.lastEntry().getKey();

            if (i < maxOffset)
                count.put(nums[i+k], count.getOrDefault(nums[i+k], 0) + 1);
        }

        return res;
    }
}
