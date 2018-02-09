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
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        if (root == null) return true;
        TreeNode node = root;
        TreeNode pre = null;
        while (node != null || !s.isEmpty()){
            if (node != null){
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if(pre != null && node.val <= pre.val) return false;
                pre = node;
                node = node.right;
            }
        }
        return true;
    }
}