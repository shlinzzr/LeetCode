// https://leetcode.com/problems/spiral-matrix-iv

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
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] res = new int[m][n];
        for(int r[] : res) 
            Arrays.fill(r,-1);
        
        ListNode node = head;
        
        
//         int startrow=0;
//         int startcol=0;
//         int endrow=m-1;
//         int endcol=n-1;
//         while(temp!=null){
            
//             for(int i=startcol;i<=endcol;i++){
//                 if(temp==null) break;
//                 res[startrow][i]=temp.val;
//                 temp=temp.next;
//             }
            
//              for(int i=startrow+1;i<=endrow;i++){
//                  if(temp==null) break;
//                 res[i][endcol]=temp.val;
//                 temp=temp.next;
//             }
            
//              for(int i=endcol-1;i>=startcol;i--){
//                  if(temp==null) break;
//                 res[endrow][i]=temp.val;
//                 temp=temp.next;
//             }
            
//              for(int i=endrow-1;i>startrow;i--){
//                  if(temp==null) break;
//                 res[i][startcol]=temp.val;
//                 temp=temp.next;
//             }
//             startrow++;
//             startcol++;
//             endrow--;
//             endcol--;
//         }
        
        
        int stCol=0, edCol=n-1, stRow=0, edRow=m-1;
        while(node!=null){
            
            for(int j=stCol; j<=edCol; j++){
                if(node==null) break;
                res[stRow][j] = node.val;
                node = node.next;
            }
            
            
            for(int i=stRow+1; i<=edRow; i++){
                 if(node==null) break;
                res[i][edCol] = node.val;
                node = node.next;
                
            }
            
            for(int j=edCol-1; j>=stCol; j--){
                 if(node==null) break;
                res[edRow][j] = node.val;
                node = node.next;
            }
                
            for(int i=edRow-1; i>stRow; i--){
                 if(node==null) break;
                res[i][stCol] = node.val;
                node = node.next;
            }
            
            stCol++;
            edCol--;
            stRow++;
            edRow--;
            
            
        }
        return res;
    }
    
}