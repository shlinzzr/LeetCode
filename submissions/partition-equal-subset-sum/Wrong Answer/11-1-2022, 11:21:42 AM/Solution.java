// https://leetcode.com/problems/partition-equal-subset-sum

class Solution {
    public boolean canPartition(int[] nums) {
       
        boolean res = false;
        int sum = 0;
        for(int n : nums){
            sum+=n;
        }
        
        if(sum%2==1)
            return false;
        
        sum/=2;
        
        HashMap<Integer, Boolean> map = new HashMap<>();
        
        return dfs(nums, 0, sum, map);        
        
    }
    
    private boolean dfs(int[] nums, int curr, int target, HashMap<Integer, Boolean> map ){
        
        if(map.containsKey(curr))
            return map.get(curr);
        
        if(curr==target)
            return true;
        
        boolean ans = false;
        for(int n : nums){
            if(curr+n<=target){
                boolean rt = dfs(nums, curr+n, target, map);
                map.put(curr+n, rt);
                ans = ans || rt;
            }
        }
        
        return ans;
    }
}