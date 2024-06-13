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
            
            if(has(root, mid)){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        return st;
        
    }
    
    private boolean has(TreeNode root, int mid){
    
        List<Integer> list = new ArrayList<>();
        while(mid>0){
            list.add(0, mid);  // 1, 3, 6
            // list.add(mid);  // 6, 3, 1
            mid/=2;
        }
        
        
//         TreeNode node = root; 
//         for(int i=list.size()-1; i>=0; i--){
            
//             if(node==null) return false;
//             if(i==0) return true;
                
            
//             if(list.get(i-1)==2*list.get(i)){
//                 node = node.left;
//             }else{
//                 node = node.right;
//             }
//         }
        
          TreeNode node = root; 
        for(int i=0; i<list.size(); i++){
            
            if(node==null) return false;
            if(i==list.size()-1) return true;
                
            
            if(list.get(i+1)==2*list.get(i)){
                node = node.left;
            }else{
                node = node.right;
            }
        }
        
        
        return false;
        
        
        
        
        
        
//         TreeNode node = root;
//         for(int i=0; i<list.size()-1; i++){

//             int curr = list.get(i);
            
//             if(node==null)   return false;
            
//             if(node.val!=curr)
//                 return false;
            
//             int next = list.get(i+1);
            
//             if(next == 2*curr){
//                 node = node.left;
//             }else if(next == 2*curr+1){
//                 node= node.right;
//             }else{
//                 return false;
//             }
//         }
        // return node==null ? false :  node.val==list.get(list.size()-1);
    }
    
    
    
    
    
}
