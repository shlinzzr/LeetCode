// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree

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
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null)
            return null;
        
        ListNode fast = head;
        ListNode slow = head;
        
        ListNode prev = null;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        if(prev!=null)
            prev.next = null;
        
        ListNode leftHead = reverse(head);
        fast = leftHead;
        
        TreeNode root = new TreeNode(slow.val);
        
        TreeNode curr = root;
        while(fast!=null){
            curr.left = new TreeNode(fast.val);
            curr = curr.left;
            fast=fast.next;
        }
        
        
        
        
        
        slow=slow.next;
        curr = root;
        while(slow!=null){
            
            TreeNode next = new TreeNode(slow.val);
            slow = slow.next;
            
            curr.right = next;
            curr = curr.right;
        }
        
        return root;
        
    }
    
    private ListNode reverse(ListNode head){
        
        ListNode curr = head;
        ListNode prev = null;
        
        while(curr!=null){
            
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            
        }
        
        
        return prev;
    }
    
}