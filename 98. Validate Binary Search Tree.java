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
    private Integer pre;
    public boolean isValidBST(TreeNode root) {
        pre = null;
        return inOrder(root);
    }
    private boolean inOrder(TreeNode root){
        if (root == null) return true;
        if (!inOrder(root.left)) return false;
        //System.out.println(root.val + ";" + pre);
        if (pre != null && pre >= root.val) return false;
        pre = root.val;
        if (!inOrder(root.right)) return false;
        return true;
    }
}