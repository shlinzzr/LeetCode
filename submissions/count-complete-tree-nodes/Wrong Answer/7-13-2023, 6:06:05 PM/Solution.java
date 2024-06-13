// https://leetcode.com/problems/count-complete-tree-nodes

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
    public int countNodes(TreeNode root) {
       
        if(root==null)
            return 0;
        
        int st=0;
        int ed=50000;
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            if(hasK(root, mid)){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
    }
    
    private boolean hasK(TreeNode root, int mid){
    
        List<Integer> list = new ArrayList<>();
        while(mid>0){
            list.add(0, mid);  // 1, 3, 6
            // list.add(mid);  // 6, 3, 1
            mid/=2;
        }
        
//         TreeNode node = root; 
//         for(int i=0; i<list.size(); i++){
            
//             if(node==null) return false;
//             if(i==list.size()-1) return true;
                
            
//             if(2*list.get(i)==list.get(i+1)){
//                 node = node.left;
//             }else{
//                 node = node.right;   // 2*list.get(i)==list.get(i+1)+1
//             }
//         }
        // return false;
        
        
        
        TreeNode node = root;
        for(int i=0; i<list.size(); i++){

            int curr = list.get(i);
            
            
            
            if(node==null)   return false;
            if(i==list.size()-1) return true;
            
            if(node.val!=curr)
                return false;
            
            int next = list.get(i+1);
            
            if(next == 2*curr){
                node = node.left;
            }else if(next == 2*curr+1){
                node= node.right;
            }else{
                return false;
            }
        }
        
        return false;
    }
    
    
    
    
    
}

