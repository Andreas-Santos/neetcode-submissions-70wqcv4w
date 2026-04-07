class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, result, subset, target);

        return result;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> result, List<Integer> subset, int target) {
        if(target == 0) {
            result.add(new ArrayList<>(subset));
            return;
        }
        
        if(target < 0 || i >= nums.length) return;

        int sub = target - nums[i];

        subset.add(nums[i]);
        dfs(nums, i, result, subset, sub);
        subset.remove(subset.size() - 1);
        dfs(nums, i + 1, result, subset, target);
    }
}
