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
    private int sumNumbers(TreeNode node, int pre){
        if (node == null) return 0;
        if (node.right == null && node.left == null) return pre*10 + node.val;
        return sumNumbers(node.left, pre*10 + node.val) + sumNumbers(node.right, pre*10 + node.val);
    }
}