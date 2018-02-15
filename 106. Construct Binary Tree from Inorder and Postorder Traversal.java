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
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    public static TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder, int ps, int pe){
        if (ps > pe || is > ie) return null;
        int cnt = 0;
        while (inorder[is+cnt] != postorder[pe]) cnt++;
        TreeNode root = new TreeNode(postorder[pe]);
        root.left = buildTree(inorder, is, is+cnt-1, postorder, ps, ps+cnt-1);
        root.right = buildTree(inorder, is+cnt+1, ie, postorder, ps+cnt, pe-1);
        return root;
    }
}