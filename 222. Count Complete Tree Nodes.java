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
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left == right) res = ((1 << left) + countNodes(root.right));
        else res = ((1 << right) + countNodes(root.left));
        return res;
    }
    private int depth(TreeNode root){
        if (root == null) return 0;
        return 1 + depth(root.left);
    }
}