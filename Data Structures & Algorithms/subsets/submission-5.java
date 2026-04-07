class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        dfs(nums, 0, result, subset);

        return result;
    }

    public void dfs(int[] nums, int i, List<List<Integer>> res, List<Integer> sub) {
        if(i >= nums.length) {
            res.add(new ArrayList<>(sub));
            return;
        }

        sub.add(nums[i]);
        dfs(nums, i + 1, res, sub);
        sub.remove(sub.size() - 1);
        dfs(nums, i + 1, res, sub);
    }
}
