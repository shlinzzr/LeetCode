// https://leetcode.com/problems/find-largest-value-in-each-tree-row

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
    public List<Integer> largestValues(TreeNode root) {
        
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;

    }

    private void helper(TreeNode root, List<Integer> list, int lv){
        if(root==null)
            return;

        if(list.size()<lv+1){
            list.add(root.val);
        }else{
            list.set(lv, Math.max(list.get(lv), root.val));
        }

        helper(root.left, list, lv+1);
        helper(root.right, list, lv+1);
    }
}