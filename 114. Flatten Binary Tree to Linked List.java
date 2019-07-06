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
    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null) return;
        //System.out.println(root.val);
        TreeNode left = root.left, right = root.right;
        if (pre != null) pre.right = root;
        root.left = null;
        //root.right = null;
        pre = root;
        flatten(left);
        flatten(right);
    }
}