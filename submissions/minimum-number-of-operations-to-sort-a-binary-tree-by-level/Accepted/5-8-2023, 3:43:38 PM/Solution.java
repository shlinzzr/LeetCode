// https://leetcode.com/problems/minimum-number-of-operations-to-sort-a-binary-tree-by-level

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
    public int minimumOperations(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        
        helper(root, list, 0);
        
        int cnt=0;
        
        for(List<Integer> row : list){
            
            int st = 0, ed=row.size()-1;
            
            cnt += helper2(row);
            
        }
        
        return cnt;
        
        
    }
    
    
    private void helper(TreeNode root, List<List<Integer>> list, int lv){
        if(root==null)
            return;
        
        if(list.size()<lv+1)
            list.add(new ArrayList<>());
        
        list.get(lv).add(root.val);
        
        helper(root.left, list, lv+1);
        helper(root.right, list, lv+1);
    
        
    }
    
    
    private int  helper2(List<Integer> list) {
        int swaps = 0;
        int[] sorted = new int[list.size()];
        for(int i=0; i<sorted.length; i++) sorted[i] = list.get(i);
        Arrays.sort(sorted);
        Map<Integer, Integer> ind = new HashMap<>();
        for(int i=0; i<list.size(); i++) ind.put(list.get(i), i);
        
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) != sorted[i]) {
                swaps++;
                ind.put(list.get(i), ind.get(sorted[i]));
                list.set(ind.get(sorted[i]), list.get(i));
            }
        }
        return swaps;
    }
}
