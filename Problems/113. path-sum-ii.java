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
        List<List<Integer>> res = new ArrayList<>();

        if(root==null)
            return res;

        helper(res, new ArrayList<>(), root, targetSum);

        return res;
    }

    private void helper(List<List<Integer>> res, List<Integer> cur, TreeNode node, int target){

        if(node==null)
            return;


        
        cur.add(node.val);

        if(node.left==null && node.right==null && target-node.val==0){
            res.add(new ArrayList<>(cur));
        }

        if(node.left!=null){
            helper(res, cur, node.left, target-node.val);
        }

        if(node.right!=null){
            helper(res, cur, node.right, target-node.val);
        }

        cur.remove(cur.size()-1);


    }
}