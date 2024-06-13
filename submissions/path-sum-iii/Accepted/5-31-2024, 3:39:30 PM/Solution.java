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
    int res=0;
    Map<Long, Integer> map ;
    public int pathSum(TreeNode root, int targetSum) {

        map = new HashMap<>();
        map.put(0L, 1);

        helper(root, 0L, (long)targetSum);

        return res;

        
    }

    private void helper(TreeNode node, long cur, long target){

        if(node==null) return;

        cur += node.val;

        if(map.containsKey(cur-target)){
            res += map.get(cur-target);
        }

        map.put(cur, map.getOrDefault(cur,0)+1);
        helper(node.left, cur, target);
        helper(node.right, cur, target);
        map.put(cur, map.get(cur)-1);
        if(map.get(cur)==0) map.remove(cur);

    }
}