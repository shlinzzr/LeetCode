// https://leetcode.com/problems/maximum-width-of-binary-tree

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

    List<List<Integer>> list = new ArrayList<>();

    public int widthOfBinaryTree(TreeNode root) {
        helper(root, 0, 0);

        int max = 0;
        for(int i=0; i<list.size(); i++){

            List<Integer> sub = list.get(i);

            max = Math.max( sub.get(sub.size()-1) - sub.get(0)+1, max);
        }

        return max;
    }

    private void helper(TreeNode node, int lv, int idx){
        if(node==null) return;

        if(list.size()<lv+1){
            list.add(new ArrayList<>());
        }

        list.get(lv).add(idx);
        helper(node.left, lv+1, 2*idx);
        helper(node.right, lv+1, 2*idx+1);
    }
}