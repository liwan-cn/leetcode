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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        updateMaxValue(res, root, 0);
        return res;
    }
    private void updateMaxValue(List<Integer> res, TreeNode root, int depth){
        if (root == null) return;
        if (res.size() <= depth)
            res.add(root.val);
        res.set(depth, Math.max(res.get(depth), root.val));
        updateMaxValue(res, root.left, depth+1);
        updateMaxValue(res, root.right, depth+1);
    }
}