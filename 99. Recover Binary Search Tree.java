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
    private TreeNode pre, first, second;
    public void recoverTree(TreeNode root) {
        pre = null; first = null; second = null;
        findWrong(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }
    private void findWrong(TreeNode root){
        if (root == null) return;
        findWrong(root.left);
        if(pre != null && first != null && root.val < pre.val){
            second = root;
        } else if (pre != null && root.val < pre.val){
            first = pre;
            second = root;// only two node
        }
        pre = root;
        findWrong(root.right);
    }
}