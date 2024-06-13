// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset

class Solution {
    public int maximumLength(int[] nums) {
         
        TreeMap<Long, Integer> map = new TreeMap<>();
        
        for(int n : nums){
            map.put((long)n, map.getOrDefault((long)n,0)+1);
        }
        
        
        int max= 1;
        for(long k : map.keySet()){
            
            int cnt=0;
            
            while(map.getOrDefault(k, 0)>=2){
                cnt+=2;
                k = k*k;
            }
           
            
            if(cnt!=0 && map.getOrDefault(k,0)==1)
                cnt++;
            else 
                cnt--;
            
            max = Math.max(max, cnt);
            
        }
        
        return max;
        
        
    }
}