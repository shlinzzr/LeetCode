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

         HashMap<Integer, List<Integer>> map = new HashMap<>();

         helper(map,null,  root);

         HashSet<Integer> seen = new HashSet<>();
         Queue<Integer> q = new LinkedList<>();
         q.offer(target.val);
         seen.add(target.val);

         while(!q.isEmpty() && k>=0){
             int siz = q.size();
             while(siz-->0){

                 int p = q.poll();

                 if(k==0){
                     res.add(p);
                 }else{
                     for(int next : map.getOrDefault(p, new ArrayList<>())){
                        if(!seen.contains(next)){
                            seen.add(next);
                            q.offer(next);
                        }
                    }
                 }
             }
             k--;
         }

         return res;
         
    }

    private void helper( HashMap<Integer, List<Integer>> map, TreeNode parent, TreeNode root){

        if(root==null) return ;

        map.putIfAbsent(root.val, new ArrayList<>());

        if(parent!=null) map.get(root.val).add(parent.val);
        if(root.left!=null) map.get(root.val).add(root.left.val);
        if(root.right!=null) map.get(root.val).add(root.right.val);

        helper(map, root, root.left);
        helper(map, root, root.right);
    }
}