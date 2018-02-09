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
    public void recoverTree(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode node = root;
        TreeNode pre = null, firstError =null, secondError = null;
        while (node != null || !s.isEmpty()){
            if (node != null){
                s.push(node);
                node = node.left;
            } else {
                node = s.pop();
                if(pre != null && firstError != null && node.val < pre.val){
                    secondError = node;
                } else if (pre != null && node.val < pre.val){
                    firstError = pre;
                    secondError = node;// only two node
                }
                pre = node;
                node = node.right;
            }
        }
        int tmp = firstError.val;
        firstError.val = secondError.val;
        secondError.val = tmp;
    }
}