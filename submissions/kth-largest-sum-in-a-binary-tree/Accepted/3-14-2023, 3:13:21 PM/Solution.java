// https://leetcode.com/problems/kth-largest-sum-in-a-binary-tree

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
    public long kthLargestLevelSum(TreeNode root, int k) {
        
        if(root==null)
            return -1;
        
        
        List<List<Integer>> list = new ArrayList<>();
        
        helper(root, k, 0, list);

        PriorityQueue<Long> pq = new PriorityQueue<>(
            // (a,b) -> Long.compare(a,b)
        );
        
        for(List<Integer> l : list){
            long sum = 0;
            for(int n: l){
                System.out.print(n+ ",");
                sum+=n;
            }
            System.out.println();
            System.out.println(sum);
            
            pq.offer(sum);
            
        }
        
        if(pq.size()<k)
            return -1;
        
        while(pq.size()>k)
            pq.poll();
        
        
        return pq.isEmpty()? -1 : pq.poll();
        
        
    }
    
    private void helper(TreeNode root, int k, int lv, List<List<Integer>> list){
        if(root==null)
            return;
        
        if(list.size()<lv+1){
            list.add(new ArrayList<>());
        }
        
        list.get(lv).add(root.val);

        helper(root.left, k, lv+1, list);
        helper(root.right, k, lv+1, list);
    }
}
