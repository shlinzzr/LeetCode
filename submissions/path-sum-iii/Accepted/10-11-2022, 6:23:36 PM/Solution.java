// https://leetcode.com/problems/path-sum-iii

class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        // copied from solution
        
        Map<Long, Integer> map = new HashMap<>();

        pathSum(root, 0L, targetSum, map);
        
        return count;
    }
    
    private void pathSum(TreeNode root, long curr, int t, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        curr += root.val;
        
        if (curr == t) {
            count++;
        }
        
        count += map.getOrDefault(curr - t, 0);
        
        map.put(curr, map.getOrDefault(curr, 0) + 1);

        //  for(Map.Entry<Long, Integer> en :frequencyMap.entrySet() ){
        //     System.out.println(en.getKey() + " " + en.getValue()+ " count="+count);
        // }
        //  System.out.println();
        
        pathSum(root.left, curr, t, map);
        
        pathSum(root.right, curr, t, map);
        
        map.put(curr, map.get(curr) - 1);
        
       
        
        
        
    }
}