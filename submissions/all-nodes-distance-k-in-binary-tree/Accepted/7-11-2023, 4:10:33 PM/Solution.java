// https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    Queue<TreeNode> q = new LinkedList<>();
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        
        Map<TreeNode, Set<TreeNode>> map = new HashMap<>();
        genMap(null, root, map, target.val);
        
        Set<TreeNode> seen = new HashSet<>();
        seen.add(q.peek());
        
        while(!q.isEmpty() && k>0){
            
            for(int i = q.size(); i>0; i--){
                TreeNode p = q.poll();
                
                for(TreeNode next : map.get(p)){
                    
                    if(!seen.contains(next)){
                        q.offer(next);
                        seen.add(next);
                    }
                }
            }
            k--;
        }
        
        for(TreeNode p : q){
            res.add(p.val);
        }
        
        
        return res;
        
    }
    
    private void genMap(TreeNode parent, TreeNode root, Map<TreeNode, Set<TreeNode>>  map, int target ){
        
        
        map.putIfAbsent(root, new HashSet<>());
        
        if(root.val==target)
            q.offer(root);
        
        if(parent!=null) map.get(root).add(parent);          
        
        if(root.left!=null){
            map.get(root).add(root.left);          
            genMap(root, root.left, map, target);
        } 
        
        if(root.right!=null){
            map.get(root).add(root.right);          
            genMap(root, root.right, map, target);
        } 
        
            
    }
    
    
    
}