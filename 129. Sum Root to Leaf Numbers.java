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
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }
    public int sumNumbers(TreeNode root, int pre){
        if (root == null) return 0;
        if (root.right == null && root.left == null) return pre*10 + root.val;
        return sumNumbers(root.left, pre*10 + root.val) + sumNumbers(root.right, pre*10 + root.val);
    }
}