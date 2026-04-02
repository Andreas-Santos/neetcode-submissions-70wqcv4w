/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        int[] result = dfs(root);

        return result[0] == 1;
    }

    public int[] dfs(TreeNode root) {
        // int[] will return [balanced, height] balanced (1 for true, 0 to false)

        if(root == null) return new int[]{1, 1};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int balanced = (left[0] == 1) && (right[0] == 1) && (Math.abs(left[1] - right[1]) < 2) ? 1 : 0;
        int height = 1 + Math.max(left[1], right[1]);
        
        return new int[]{balanced, height};
    }
}
