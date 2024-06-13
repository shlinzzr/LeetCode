// https://leetcode.com/problems/subarrays-with-k-different-integers

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res=0;
        
        int ed=0;
        for(int st=0; st<len; st++){
            
            ed=st;
            map = new HashMap<>();
            
            while(ed<len && map.size()<=k){
                
                // System.out.println(st + " " + ed + " r="+res );
                
                int n = nums[ed];
                map.put(n, map.getOrDefault(n, 0)+1);
                ed++;
                
                if(map.size()==k)
                    res++;
            }
        }
        
        
        
        
        
        
        return res;
        
    }
}