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
        
        HashMap<TreeNode, Set<TreeNode>> map = new HashMap<>();
        
        buildGraph(null, root, map);
        
        // for(TreeNode t : map.keySet()){
        //     System.out.println(t.val);
        // }
           
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        
        while(!queue.isEmpty() && k>0){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(map.containsKey(curr)){

                    Set<TreeNode> set = map.get(curr);
                    for(TreeNode n : set){
                        queue.offer(n);
                    }
                }    
            }
            k--;
        }
        
        while(!queue.isEmpty()){
            TreeNode n = queue.poll();
            if(n.val!=target.val)
                res.add(n.val);
        }
        
        
        return res;
        
        
        
    }
    
    
    private void buildGraph(TreeNode parent, TreeNode root, HashMap<TreeNode, Set<TreeNode>> map){
        
        if(parent!=null){
            Set<TreeNode> setP = map.getOrDefault(parent, new HashSet<>());
            setP.add(root);
            map.put(parent, setP);
            
            Set<TreeNode> setR = map.getOrDefault(root, new HashSet<>());
            setR.add(parent);
            map.put(root, setR);
        }

        if(root.left!=null)
            buildGraph(root, root.left, map);
        
        if(root.right!=null)
            buildGraph(root, root.right, map);
        
    }
}