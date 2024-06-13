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
        HashMap<TreeNode, HashSet<TreeNode>> map = new HashMap<>();
        buildMap(map, root, null, target);
        HashSet<TreeNode> seen = new HashSet<>();
        seen.add(target);
        
        while(!q.isEmpty() && k>0){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                
                TreeNode p = q.poll();
                Set<TreeNode> set = map.get(p);
                for(TreeNode node : set ){
                    if(!seen.contains(node)){
                        q.offer(node);
                        seen.add(node);
                    }
                    
                }
            }
            k--;
        }
        
        List<Integer> res = new ArrayList<>();
        for(TreeNode node : q){
            res.add(node.val);
        }
        
        return res;
        
    }
    
    
    private void buildMap(HashMap<TreeNode, HashSet<TreeNode>> map, TreeNode root, TreeNode parent, TreeNode target){
        
        if(root==null)
            return;
        
        if(root.val==target.val)
            q.offer(root);
        
        HashSet<TreeNode> set = map.getOrDefault(root, new HashSet<>());
        
        if(parent!=null)     set.add(parent);
        if(root.left!=null)  set.add(root.left);
        if(root.right!=null) set.add(root.right);
        
        map.put(root, set);
        
        buildMap(map, root.left, root, target);
        buildMap(map, root.right, root, target);
    }
}