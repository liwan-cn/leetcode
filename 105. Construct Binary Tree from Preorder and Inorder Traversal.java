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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    private TreeNode buildTree(int[] preorder, int ps, int pe, int[] inorder, int is, int ie){
        if (ps > pe || is > ie) return null;
        int index = 0;
        while (inorder[is+index] != preorder[ps]) index++;
        TreeNode root = new TreeNode(preorder[ps]);
        root.left = buildTree(preorder, ps+1, ps+index, inorder, is, is+index-1);
        root.right = buildTree(preorder, ps+index+1, pe, inorder, is+index+1, ie);
        return root;
    }
}