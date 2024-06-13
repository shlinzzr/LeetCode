// https://leetcode.com/problems/reverse-odd-levels-of-binary-tree

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
    public TreeNode reverseOddLevels(TreeNode root) {
        
        // We call the function from lvl 0, and everything starts from lvl 1
        helper(root.left, root.right, 1);
        return root;
    }

    public void helper(TreeNode node1, TreeNode node2, int lvl) {
        if (node1 == null || node2 == null) {
            return;
        }
        if (lvl % 2 == 1){
            int temp = node1.val;
            node1.val = node2.val;
            node2.val = temp;
        }

        helper(node1.left, node2.right, lvl + 1);
        helper(node1.right, node2.left, lvl + 1);
    }
        
        //ans = 
        //[2,5,3,8,13,21,34]
        //[7,11,13]
        //[0,2,1,0,0,0,0,2,2,2,2,1,1,1,1]
}