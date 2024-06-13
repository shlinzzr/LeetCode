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
        int h = 0;
        TreeNode node = root;
        while(node!=null){
            node=node.left;
            h++;
        }
        int lo = (int)Math.pow(Double.valueOf(2), Double.valueOf(h-1));
        int hi = (int)Math.pow(Double.valueOf(2), Double.valueOf(h))-1;
        
        
        while(lo<hi){
            
            int mid = lo + (hi-lo+1)/2;
            if(hasK(root, mid)){
                
                lo = mid;
            }else{
                
                hi = mid-1;
            }
        }
        
        return lo;
    }
    
    
    private boolean hasK(TreeNode root, int k){
        
        List<Integer> list = new ArrayList<>();
        while(k>0){
            list.add(k);
            k/=2;
        }
        
        for(int i=list.size()-1; i>=0; i--){
            
            if(root==null)
                return false;
            if(i==0)
                return true;
            
            if(list.get(i)*2==list.get(i-1)){
                root=root.left;
            }else{
                root=root.right;
            }
        }
          return false;
    }
}