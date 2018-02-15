/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private int maxValue;
    public int maxPathSum(TreeNode root) {
        maxValue = Integer.MIN_VALUE;
        maxPathDown(root);
        return maxValue;
    }
    public int maxPathDown(TreeNode root){
        if (root == null) return 0;
        int l = Math.max(0, maxPathDown(root.left));
        int r = Math.max(0, maxPathDown(root.right));
        maxValue = Math.max(maxValue, l + r + root.val);
        return (Math.max(l, r) + root.val);
    }
}