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

    
    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);

        return helper(root, 0, targetSum);
        
        
    }


    private int helper(TreeNode node, int cur, int target){
        
        if(node==null) return 0;



        int res = helper(node.left, cur+node.val, target);
        res += helper(node.right, cur+node.val, target);

        if(map.containsKey(cur-target)){
            res += map.put(cur-target);
        }

        map.put(cur+node.val, map.getOrDefault(cur+node.val)+1);

        return res;

    }
}