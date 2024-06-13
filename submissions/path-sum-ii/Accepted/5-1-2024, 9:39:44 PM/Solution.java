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
   List<List<Integer>> res =new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        helper(root, new ArrayList<>(), targetSum);

        return res;

    }

    private int helper(TreeNode node, List<Integer>list, int targetSum){

        if(node==null) return 0;

      
         if(node.left==null && node.right==null && targetSum == node.val){
            list.add(node.val);
            res.add(new ArrayList<>(list));
            list.remove(list.size()-1);
            return node.val;
        }


        list.add(node.val);
        int left = helper(node.left, list, targetSum-node.val);
        int right = helper(node.right,  list, targetSum-node.val);
        list.remove(list.size()-1);

        return node.val+Math.max(left, right);

    }
}