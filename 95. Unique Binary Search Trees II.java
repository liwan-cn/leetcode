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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>(); // n = 0
        return generateTrees(1, n);
    }
    public List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new ArrayList<>();
        if (start > end) {
            list.add(null); //left or right = null;
            return list;
        }
        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }
        List<TreeNode> left, right;
        for(int i = start; i <= end; i++){
            left = generateTrees(start, i-1);
            right = generateTrees(i+1,end);
            
            for(TreeNode lnode: left){
                for(TreeNode rnode: right){
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }
}