// https://leetcode.com/problems/increasing-order-search-tree

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
    public TreeNode increasingBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        helper(list, root);
        // list.sort((o1, o2) -> (o1.val-o2.val));
        
        TreeNode head = null;
        TreeNode curr = head;
        
        for(TreeNode n : list){
            
            if(head==null){
                head = n;
                curr = n;
                
            }else{
                curr.right = n;
                curr = curr.right;
                
                
            }
            
            curr.left=null;
            curr.right=null;
            
            
        }
        
        return head;
        
        
        
    }
    
    private void helper(List<TreeNode> list, TreeNode root){
        
        if(root==null)
            return;
        
      
        
        helper(list, root.left);
          list.add(root);
        helper(list, root.right);
    }
}