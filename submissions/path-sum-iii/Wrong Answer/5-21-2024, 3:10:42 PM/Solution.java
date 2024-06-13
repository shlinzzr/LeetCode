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
    public int pathSum(TreeNode root, int targetSum) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        helper(root, map, 0, targetSum);
        return res;
        
    }

    private void helper(TreeNode node, Map<Integer, Integer> map, int curr, int target){

        if(node==null) return ;

        curr+=node.val;

        if(map.containsKey(curr-target)){
            res+= map.get(curr-target);
        }

        map.put(curr, map.getOrDefault(curr,0)+1);

        helper(node.left, map, curr, target);
        helper(node.right, map, curr, target);

        map.put(curr, map.getOrDefault(curr,0)-1);
    }
}