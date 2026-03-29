class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        int sum = numbers[l] + numbers[r];

        while (sum != target) {
            if (sum > target)
                r--;
            else if (sum < target)
                l++;
            sum = numbers[l] + numbers[r];
        }

        return new int[] { l + 1, r + 1 };
    }
}
