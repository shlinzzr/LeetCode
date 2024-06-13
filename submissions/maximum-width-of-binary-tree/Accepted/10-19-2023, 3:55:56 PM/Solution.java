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
    public int widthOfBinaryTree(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        int max= 0;

        helper(list, 0, root, 0);

        for(List<Integer> sub : list){
            max =Math.max(max, sub.get(sub.size()-1) - sub.get(0)+1);
        }

        return max;
    }

    private void helper( List<List<Integer>> list, int idx, TreeNode node, int lv){

        if(node==null)
            return ;

        if(list.size()<lv+1)
            list.add(new ArrayList<>());

        list.get(lv).add(idx);

        helper(list, 2*idx+1, node.left, lv+1);
        helper(list, 2*idx+2, node.right, lv+1);
        


    }
}