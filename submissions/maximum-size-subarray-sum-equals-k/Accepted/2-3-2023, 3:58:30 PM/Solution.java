// https://leetcode.com/problems/maximum-size-subarray-sum-equals-k

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        
        
        //https://www.youtube.com/watch?v=RxIf_N6JiMM
        // prefix sum 可以在O(1)內 找到 sum from i to j;
         
        
        int len = nums.length;
        
        int sum=0;
        int max=0;
        
        HashMap<Integer, Integer> map = new HashMap<>();// val, idx
        for(int i=0; i<len; i++){
            
            sum+=nums[i];
            nums[i]=sum;
            if(sum==k){
                max = i+1;
            }else{
                
                if(map.containsKey(sum-k)){
                    max = Math.max(max, i-map.get(sum-k));
                }
                
            }
            
            if(!map.containsKey(sum))
                map.put(sum, i);
        }
        
        return max;
        
        
    }
}