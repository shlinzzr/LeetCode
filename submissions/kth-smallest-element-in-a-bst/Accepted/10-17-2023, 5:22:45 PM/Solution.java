// https://leetcode.com/problems/kth-smallest-element-in-a-bst

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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = root;
        int count = 0;
        // node == null, might get to the leaf but stack is not empty
        while(node!=null || !stack.isEmpty()){
            while(node!=null){
                stack.push(node);
                node = node.left;
            } 
            node = stack.pop();
            count++;
            if(count==k) return node.val;
            node = node.right;
        }
        return -1;
    }
}