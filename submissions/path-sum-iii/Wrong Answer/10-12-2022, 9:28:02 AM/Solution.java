// https://leetcode.com/problems/path-sum-iii

class Solution {
    
    int res=0;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        helper(root, targetSum, new HashSet<>());
        return res;
    
    }
    
    private void helper(TreeNode root, long t, Set<Long> set ){
        
        if(root==null)
            return;
        
        if(root.val==t)
            res++;
        
        
        Set<Long> set2 = new HashSet<>();
        
        if(set.contains(t-root.val))
            res++;
        
        for(Long n:set){
            set2.add(n+Long.valueOf(root.val));
        }
        
        set2.add(Long.valueOf(root.val));
        helper(root.left, t, set2);
        helper(root.right, t, set2);
    }
    
}