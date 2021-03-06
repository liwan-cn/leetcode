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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelOrder(res, root, 0);
        for (int i = 1, size = res.size(); i < size; i += 2){
            Collections.reverse(res.get(i));
        }
        return res;
    }
    private void levelOrder(List<List<Integer>> res, TreeNode root, int height){
        if (root == null) return;
        if (res.size() <= height){
            res.add(new ArrayList<>());
        }
        res.get(height).add(root.val);
        levelOrder(res, root.left, height+1);
        levelOrder(res, root.right, height+1);
    }
}