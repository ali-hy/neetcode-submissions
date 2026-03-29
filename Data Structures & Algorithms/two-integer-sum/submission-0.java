class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            Integer diffPos = map.get(nums[i]);
            if (diffPos != null)
                return new int[] {diffPos, i};
            map.put(target - nums[i], i);
        }

        return new int[0];
    }
}
