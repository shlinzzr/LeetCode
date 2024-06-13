// https://leetcode.com/problems/binary-tree-cameras

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
    
    HashSet<TreeNode> cams = new HashSet<>();
    HashSet<TreeNode> seen = new HashSet<>();
    Queue<TreeNode> q = new LinkedList<>();
    HashMap<TreeNode, Set<TreeNode>> map = new HashMap<>();
    
    
    public int minCameraCover(TreeNode root) {
        
        if(root==null)
            return 0;
        
        if(root.left==null && root.right==null)
            return 1;
        
        buildMap(null, root);
        
        if((root.left!=null && root.right==null) || (root.left==null && root.right!=null)){
            q.offer(root);
            seen.add(root);
        }
        
        
        
        // if(root.left!=null&&(root.left.left!=null || root.left.right!=null)
        //  || root.right!=null&&(root.right.left!=null || root.right.right!=null)  ){
        //     q.offer(root);
        //     seen.add(root);
        // }
        
        
        
        dfs();
        
        return cams.size();
        
        
    }
    
    private void dfs(){
        
        int step =0;
        
        while(!q.isEmpty()){
            
            int size=q.size();
            for(int i=0; i<size; i++){
                TreeNode p = q.poll();
                Set<TreeNode> adjs = map.get(p);
                for(TreeNode t : adjs){
                    if(!seen.contains(t)){
                        q.offer(t);
                        seen.add(t);
                        if(step%3==0){
                            cams.add(t);
                        }
                    }
                }
            }
           step++;
        }
    }
    
    
    
    private void buildMap(TreeNode parent, TreeNode root){
        
        map.putIfAbsent(root, new HashSet<>());
        
        if(parent!=null)
            map.get(root).add(parent);
        
        if(root.left==null && root.right==null){
            q.offer(root);
            seen.add(root);
        }
        
        if(root.left!=null){
            map.get(root).add(root.left);
            buildMap(root, root.left);
        }
            
        if(root.right!=null){
            map.get(root).add(root.right);
            buildMap(root, root.right);
        }
        
      
            
        
            
    }
}