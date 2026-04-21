class Solution {
    public int rob(int[] nums) {
        int[] memo = new int[nums.length];

        return dfs(nums, 0, memo);
    }

        public static int dfs(int[] nums, int i, int[] memo) {

        if(i >= nums.length) return 0;

        if(memo[i] == 0) {
            memo[i] = Math.max(dfs(nums, i + 1, memo), nums[i] + dfs(nums, i + 2, memo));
        }

        return memo[i];
    }
}
