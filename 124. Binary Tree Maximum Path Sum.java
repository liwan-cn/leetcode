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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathDown(root);
        return max;
    }
    private int maxPathDown(TreeNode node){
        if (node == null) return 0;
        int l = Math.max(0, maxPathDown(node.left));
        int r = Math.max(0, maxPathDown(node.right));
        max = Math.max(max, l + r + node.val);
        return Math.max(l, r) + node.val;
    }
}