// https://leetcode.com/problems/binary-tree-postorder-traversal

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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode curr = root;
        
        while(curr!=null || !stack.isEmpty()){
            
            while(curr!=null){
                list.add(0, curr.val); 
                stack.push(curr);
                curr = curr.right;
            }
            
            curr = stack.pop();
            
            curr = curr.left;        
        }
        
        return list;
    }
}