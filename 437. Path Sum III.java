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
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1);
        return helper(root, 0, sum, preSumCnt);
    }
    private int helper(TreeNode root, int nowSum, int target, Map<Integer, Integer> preSumCnt){
        if (root == null) return 0;
        
        nowSum += root.val;
        int res = preSumCnt.getOrDefault(nowSum - target, 0);
        preSumCnt.put(nowSum, preSumCnt.getOrDefault(nowSum, 0) + 1);
        
        res += helper(root.left, nowSum, target, preSumCnt) + helper(root.right, nowSum, target, preSumCnt);
        preSumCnt.put(nowSum, preSumCnt.get(nowSum) - 1);
        return res;
    }
}