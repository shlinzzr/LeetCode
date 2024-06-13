// https://leetcode.com/problems/linked-list-in-binary-tree

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    public boolean isSubPath(ListNode head, TreeNode root) {
        
        if(root==null)
            return false;
        
        if(head.val==root.val){
            boolean bool = dfs(head, root);
            if(bool) 
                return true;
        }
        
        
        boolean res=false;
        
        if(head.val!=root.val){
            boolean left= isSubPath(head, root.left);
            boolean right = isSubPath(head, root.right);
            res= left||right;
        }
        
        return res;
        
        
    }
    
    
    private boolean dfs(ListNode head, TreeNode root){
        
        ListNode node = head;
        TreeNode curr = root;
        while(node!=null){
            
            node= node.next;
            if(node==null)
                return true;
            
            if(curr.left!=null && node.val==curr.left.val)
                curr = curr.left;
            else if(curr.right!=null && node.val==curr.right.val)
                curr = curr.right;
            else 
                return false;
            
        }
        
        return false;
        
    }
}
