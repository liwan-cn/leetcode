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
        findPath(lists, new ArrayList<>(), root, sum);
        return lists;
    }
    private void findPath(List<List<Integer>> lists, List<Integer> list, TreeNode node, int sum){
        if (node == null) return;
        list.add(node.val);
        if (node.left == null && node.right == null && node.val == sum)
            lists.add(new ArrayList<>(list));
        findPath(lists, list, node.left, sum - node.val);
        findPath(lists, list, node.right, sum - node.val);
        list.remove(list.size()-1);
    }
}