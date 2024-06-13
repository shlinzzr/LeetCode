// https://leetcode.com/problems/longest-harmonious-subsequence

class Solution {
    public int findLHS(int[] nums) {
        
        Arrays.sort(nums);
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int len = nums.length;
        
        int max = 0;
        
        for(int i=0; i<len; i++){
            
            int n = nums[i];
            
            if(map.containsKey(n+1)){
                max = Math.max(max, i-map.get(n+1)+1);
            }
            
            if(map.containsKey(n-1)){
                max = Math.max(max, i-map.get(n-1)+1);
            }
            
            if(!map.containsKey(n))
                map.put(n, i);
            
            
              // System.out.println(i + " max="+max);
        }
        
      
        
        return max;
        
    }
}