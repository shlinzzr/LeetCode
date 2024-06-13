// https://leetcode.com/problems/path-sum-ii

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> res= new ArrayList<>();
        helper(root, targetSum, res, new ArrayList<>());
        return res;
        
    }

    private void helper(TreeNode node, int targetSum, List<List<Integer>> res, List<Integer> curr){
        if(node==null) return;

        if(node.left==null && node.right==null && targetSum == node.val){
            curr.add(node.val);
            res.add(new ArrayList<>(curr));

            curr.remove(curr.size()-1);
            return;
        }

        int val = node.val;
        curr.add(val);
        helper(node.left, targetSum-node.val, res, curr);
        helper(node.right, targetSum-node.val, res, curr);
        curr.remove(curr.size()-1);

    }     

}