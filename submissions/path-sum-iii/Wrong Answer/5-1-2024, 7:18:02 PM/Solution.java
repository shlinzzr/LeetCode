// https://leetcode.com/problems/path-sum-iii

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

      Map<Long,Integer> map ;

      int res=0;
    public int pathSum(TreeNode root, int targetSum) {
        map = new HashMap<>();
        map.put(0L, 1);
        helper(root, 0, targetSum);
        return res;
    }


    private int helper(TreeNode node, int targetSum, long curr){
        
        if(node==null) return 0;

        curr += node.val;
        if(map.containsKey(curr-targetSum)){
            res += map.get(curr-targetSum);
        }

        map.put(curr, map.getOrDefault(curr,0)+1);
        helper(node.left, targetSum, curr );
        helper(node.right, targetSum, curr );
        map.put(curr, map.getOrDefault(curr,0)-1);
        return res;

    }
}