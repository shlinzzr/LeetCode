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
    int res = 0;
    int target = 0;
    
    HashMap<Long, Integer> map = new HashMap<>();
    public int pathSum(TreeNode root, int targetSum) {
        this.target = targetSum;

      
        map.put(0L, 1);
        helper(root, 0L);
        return res;
    }

    private void helper(TreeNode root, long curr){

        if(root==null) return;

        curr+=root.val;
        if(map.containsKey(curr-target)){
            res+= map.get(curr-target);
        }
        map.put(curr, map.getOrDefault(curr, 0)+1);
        helper(root.left, curr);
        helper(root.right, curr);
        map.put(curr, map.get(curr)-1);
    }
}
