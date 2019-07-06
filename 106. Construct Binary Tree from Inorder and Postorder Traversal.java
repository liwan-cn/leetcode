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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(postorder, 0, postorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] postorder, int ps, int pe, int[] inorder, int is, int ie){
        if (ps > pe || is > ie) return null;
        int index = 0;
        while (inorder[is+index] != postorder[pe]) index++;
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = buildTree(postorder, ps, ps+index-1, inorder, is, is+index-1);
        root.right = buildTree(postorder, ps+index, pe-1, inorder, is+index+1, ie);
        return root;
    }
}