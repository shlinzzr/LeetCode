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
            
            int n = nums[i];
            int t = k-n;
            
            // System.out.println(i + " " + nums[i]);
            
            if(map.containsKey(t) && map.containsKey(n)){
                cnt+=1;
                
                if(map.get(t)==1)
                    map.remove(t);
                else
                    map.put(t, map.get(t)-1);
                
                if(map.get(n)==1)
                    map.remove(n);
                else
                    map.put(n, map.get(n)-1);
                
                
            }
        }
        
        return cnt;
        
        
        
        
        
        
        
        
    }
}