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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> lists = new ArrayList<>();
        pathSum(lists, new ArrayList<Integer>(), root, sum);
        return lists;
    }
    public void pathSum(List<List<Integer>> lists, List<Integer> list, TreeNode root, int sum){
        if (root == null) return;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val) {
            lists.add(new ArrayList<Integer>(list));
        }
        pathSum(lists, list, root.left, sum-root.val);
        pathSum(lists, list, root.right, sum-root.val);
        list.remove(list.size() - 1);
    }
}