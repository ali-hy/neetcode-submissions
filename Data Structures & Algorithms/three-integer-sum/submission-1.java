class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue; 
            int l = i + 1, r = nums.length - 1, target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];
                if (sum > target) {
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l++;
                    while(l < r && nums[l] == nums[l - 1])
                        l++;
                }
            }
        }

        return res;
    }
}
