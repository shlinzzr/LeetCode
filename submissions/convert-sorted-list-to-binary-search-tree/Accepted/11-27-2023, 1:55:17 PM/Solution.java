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

        if(head.next==null){
            return new TreeNode(head.val);
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while(slow!=null && fast!=null && fast.next!=null){
            prev=slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(prev!=null)
            prev.next = null;
        
        TreeNode root = slow==null ? null : new TreeNode(slow.val);
       
        if(root!=null){
            TreeNode left = head==null? null : sortedListToBST(head);
            TreeNode right = (slow==null || slow.next==null) ? null : sortedListToBST(slow.next);
            root.left= left;
            root.right=right;
        }

        return root;

    }
}