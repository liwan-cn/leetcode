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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        TreeNode node = root;
        while (node != null || !s.isEmpty()){
            if (node != null){
                s.push(node);
                list.add(node.val); //pre order
                node = node.left;
            } else {
                node = s.pop();
                //list.add(node.val); //in order
                node = node.right;
            }
        }
        return list;
    }
}