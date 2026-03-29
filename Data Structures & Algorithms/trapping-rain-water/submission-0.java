class Solution {
    public int trap(int[] height) {
        int[] l = new int[height.length],
            r = new int[height.length];
        int res = 0;

        for (int i = 1; i < height.length; i++){
            l[i] = Math.max(height[i - 1], l[i - 1] + height[i - 1]) - height[i];
            l[i] = Math.max(l[i], 0);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            r[i] = Math.max(height[i + 1], r[i + 1] + height[i + 1]) - height[i];
            r[i] = Math.max(r[i], 0);
        }

        for (int i = 0; i < height.length; i++) {
            res += Math.min(l[i], r[i]);
        }

        System.out.println("l: " + Arrays.toString(l));
        System.out.println("r: " + Arrays.toString(r));

        return res;
    }
}
