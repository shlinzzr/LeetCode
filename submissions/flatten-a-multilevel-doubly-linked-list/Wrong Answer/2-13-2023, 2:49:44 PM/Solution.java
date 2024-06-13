// https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list

/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        
        if(head==null)
            return head;
        
        head = helper(head, null);
        
        Node curr = head;
        while(curr!=null){
            System.out.println((curr.prev==null?"null" :curr.prev.val) + " " + curr.val + " " +(curr.next==null?"null":curr.next.val));
            curr=curr.next;
        }
        
        return head;
        
        
        
    }
    
    private Node helper(Node head, Node ongo){
        
        if(head==null)
            return head;
        
//         System.out.println(head.val + " " + head.child.val + 
// " "  + ((ongo==null)? "null" :ongo.val));
        Node curr = head;
        Node prev=null;
        while(curr!=null){
            System.out.println(curr.val);
            
            Node next= curr.next;
            
            if(curr.child!=null){
                // curr.next=curr.child;
                // curr.child.prev=curr;
                Node ch = helper(curr.child, next);
                curr.next = ch;
                curr.next.prev = curr;
                curr.child=null;
            }
           
            
            prev=curr;
            curr=next;
        }
        if(prev!=null)
            prev.next=ongo;
        
        if(ongo!=null)
            ongo.prev = prev;
        
        return head;
    }
    
}