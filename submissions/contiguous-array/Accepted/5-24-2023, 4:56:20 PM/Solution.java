// https://leetcode.com/problems/contiguous-array

class Solution {
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int cnt=0;
        int max=0;
            
        int sum = 0;
        for(int i=0; i<len; i++){
            
            if(nums[i]==1)
                sum+=1;
            else
                sum-=1;
            
            if(map.containsKey(sum)){
                max = Math.max(max, i-map.get(sum));
            }else{
                map.put(sum, i);    
            }
            
        }
        return max;
    }
}