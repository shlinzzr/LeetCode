// https://leetcode.com/problems/binary-tree-longest-consecutive-sequence-ii

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

    Map<TreeNode, List<TreeNode>> map = new HashMap<>();

    public int longestConsecutive(TreeNode root) {

        buildMap(null, root);

        int max = 0 ;
        for(TreeNode node : map.keySet()){
            HashSet<TreeNode> seen = new HashSet<>();
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(node);
            seen.add(node);
            int cnt = 0;
            while(!q.isEmpty()){
                int siz = q.size();
                while(siz-->0){
                    TreeNode p = q.poll();
                    for(TreeNode next : map.get(p)){

                        if(!seen.contains(next) && next.val == p.val+1){
                            seen.add(next);
                            q.offer(next);
                        }
                    }
                }
                cnt++;
               
            }

            max = Math.max(max, cnt);
        }

        return max;
        
    }

    private void buildMap(TreeNode parent, TreeNode curr){

        if(curr==null) return;

        map.putIfAbsent(curr, new ArrayList<>());

        if(curr.left!=null) map.get(curr).add(curr.left);
        if(curr.right!=null) map.get(curr).add(curr.right);
        if(parent!=null) map.get(curr).add(parent);

        buildMap(curr, curr.left);
        buildMap(curr, curr.right);
    }
}