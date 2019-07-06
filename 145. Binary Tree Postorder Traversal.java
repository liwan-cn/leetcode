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
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        TreeNode node = root, pre = null;
        while (node != null || !s.isEmpty()) {
            if (node != null) {
                s.push(node);
                node = node.left;
            } else {
                node = s.peek();
                if (node.right == null || node.right == pre) {
                    s.pop();
                    res.add(node.val);
                    pre = node;
                    node = null;
                } else {
                    node = node.right;
                }
            }
        }
        return res;
    }
}