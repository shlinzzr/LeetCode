// https://leetcode.com/problems/find-leaves-of-binary-tree

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
    
    HashMap<TreeNode ,TreeNode > map;
    Queue<TreeNode> q ;
    
    List<List<Integer>> res;
    
    public List<List<Integer>> findLeaves(TreeNode root) {
        map = new HashMap<>();
        q = new LinkedList<>();
        res = new ArrayList<>();
        
        if(root==null)
            return res;
            
        while(root.left!=null || root.right!=null){
            List<Integer> list = new ArrayList<>();
            helper(null, root, list);
            res.add(list);
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(root.val);
        res.add(list);
        return res;
        
        
        
//         helper(null, root);
        
//         while(!q.isEmpty()){
            
//             int size = q.size();
            
            
            
           
            
            
            
//             while(size-->0){
                
//                 TreeNode p = q.poll();
                
//                 if(map.get(p)!=null)
//                     q.offer(map.get(p));
                
//                 list.add(p.val);
                
//             }
            
//             res.add(list);
//         }
        
//         return res;
        
    }
    
    private void helper(TreeNode parent, TreeNode curr, List<Integer> list ){
        
        if(curr.left==null && curr.right==null){
            
            list.add(curr.val);
            
            if(parent==null){
                return;
            }else if(parent.left==curr)
                parent.left=null;
            else
                parent.right=null;
            
            // q.offer(curr);
            // map.put(curr, parent);
            // return;
        }
        
        if(curr.left!=null)
            helper(curr, curr.left, list);
        
        if(curr.right!=null)
            helper(curr, curr.right, list);
        
    }
    
}