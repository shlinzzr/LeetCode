// https://leetcode.com/problems/add-two-polynomials-represented-as-linked-lists

/**
 * Definition for polynomial singly-linked list.
 * class PolyNode {
 *     int coefficient, power;
 *     PolyNode next = null;
 
 *     PolyNode() {}
 *     PolyNode(int x, int y) { this.coefficient = x; this.power = y; }
 *     PolyNode(int x, int y, PolyNode next) { this.coefficient = x; this.power = y; this.next = next; }
 * }
 */

class Solution {
    public PolyNode addPoly(PolyNode poly1, PolyNode poly2) {
        
        
        PolyNode head = new PolyNode(); //poly1.power>poly2.power?poly1:poly2;
        PolyNode curr = head;
        
        while(poly1!=null && poly2!=null){
            
            if(poly1.power==poly2.power){
                curr.next = poly1;
                poly1.coefficient+=poly2.coefficient;
                if(poly1.coefficient==0){
                    poly1=poly1.next;
                    poly2=poly2.next;
                    continue;
                }
                
                poly1=poly1.next;
                poly2=poly2.next;
                
            }else if(poly1.power>poly2.power){
                curr.next =poly1;
                poly1=poly1.next;
                
            }else{
                curr.next = poly2;
                poly2=poly2.next;
            }
            curr=curr.next;
        }
        
        
        while(poly1!=null){
            curr.next =poly1;
            poly1=poly1.next;
            curr=curr.next;
        }
        
        while(poly2!=null){
            curr.next = poly2;
            poly2=poly2.next;
            curr=curr.next;
        }
        
        return head.next;
        
    }
}