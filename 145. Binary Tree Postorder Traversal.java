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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode node = root, pre = null;
        while (node != null || !s.isEmpty()){
            if (node != null){
                s.push(node);
                node = node.left;
            } else {
                node = s.peek();
                if (node.right == null || node.right == pre){
                    list.add(node.val);
                    s.pop();
                    pre = node;
                    node = null; // important
                } else {
                    node = node.right;
                }
                    
            }
        }
        return list;
    }
}