// https://leetcode.com/problems/max-number-of-k-sum-pairs

class Solution {
    public int maxOperations(int[] nums, int k) {
        int len = nums.length;
        Arrays.sort(nums);
        
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) +1);
        }
        
        
        int cnt=0;
        
        for(int i=0; i<len/2; i++){
            
            map.put(nums[i], map.get(nums[i])-1);
            
            int t = k-nums[i];
            
            // System.out.println(i + " " + nums[i]);
            
            if(map.containsKey(t) && map.get(t)>0){
                cnt+=1;
                
                if(map.get(t)==1)
                    map.remove(t);
                else
                    map.put(t, map.get(t)-1);
            }
            map.put(nums[i], map.get(nums[i])+1);
        }
        
        return cnt;
        
        
        
        
        
        
        
        
    }
}