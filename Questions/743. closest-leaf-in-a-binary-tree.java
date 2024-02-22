// https://leetcode.com/problems/closest-leaf-in-a-binary-tree

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
    Map<TreeNode, List<TreeNode>> g = new HashMap<>();
    public int findClosestLeaf(TreeNode root, int k) {

        
        List<TreeNode> leaves = new ArrayList<>();
        findAllLeaves(null, root, leaves);
        HashSet<TreeNode> seen = new HashSet<>();
        Queue<TreeNode[]> q = new LinkedList<>();
        for(TreeNode t : leaves){
            q.offer(new TreeNode[]{t, t}); // org, cur
            seen.add(t);
        }

        // System.out.println()


        

        int step = 0;
        while(!q.isEmpty()){
            int siz = q.size();
            while(siz-->0){

                TreeNode[] p = q.poll();
                if(p[1].val==k) {
                    return p[0].val;
                }

                for(TreeNode next : g.get(p[1])){
                    if(seen.contains(next)) continue;
                    q.offer(new TreeNode[]{p[0], next});
                    seen.add(next);
                }
            }
        }

        return -1;
        
    }

    private void findAllLeaves(TreeNode parent, TreeNode node, List<TreeNode> leaves){
        if(node==null) return;

        g.putIfAbsent(node, new ArrayList<>());
        if(parent!=null) g.get(node).add(parent);
        if(node.left!=null) g.get(node).add(node.left);
        if(node.right!=null) g.get(node).add(node.right);

        if(node.left==null && node.right==null)
            leaves.add(node);
        else{
            findAllLeaves(node, node.left, leaves);
            findAllLeaves(node ,node.right, leaves);
        }
    }
}