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
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> res = new ArrayList<>();
        HashMap<TreeNode, List<TreeNode>> map = new HashMap<>();
        buildMap(root, map);

        
        Set<TreeNode> seen = new HashSet<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        seen.add(target);
        
        int step=1;
        while(!q.isEmpty()){
            
            int siz = q.size();
            for(int i=0; i<siz; i++){
                
                TreeNode p = q.poll();
                
                List<TreeNode> adjs = map.get(p);
                for(TreeNode a : adjs){
                    
                    if(step==k && !seen.contains(a)){
                        res.add(a.val);
                    }else{
                        
                        if(!seen.contains(a)){
                            q.offer(a);
                            seen.add(a);
                        }
                    }
                }
            }
            
            step++;
        }
        
        return res;
        
    }
    
    private void buildMap(TreeNode root,  HashMap<TreeNode, List<TreeNode>> map){
        
        if(root==null)
            return;
        
        map.putIfAbsent(root, new ArrayList<>());
        
        if(root.left!=null){
            map.get(root).add(root.left);
            
            map.putIfAbsent(root.left, new ArrayList<>());
            map.get(root.left).add(root);
            
            buildMap(root.left, map);
        }
                 
        if(root.right!=null){
            
            map.get(root).add(root.right);
            
            map.putIfAbsent(root.right, new ArrayList<>());
            map.get(root.right).add(root);
            
            buildMap(root.right, map);
        }
        
        
    }
}