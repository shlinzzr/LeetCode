// https://leetcode.com/problems/find-the-longest-equal-subarray

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int len = nums.size();
        
        int st= 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int res =0 ;
        int max=0;
        int most = -1;
        int others=0;
        //[1,3,2,3,1,3]
            
        for(int ed=0; ed<len; ed++){
            
            int n = nums.get(ed);
            
            map.put(n, map.getOrDefault(n, 0)+1);
            
            if(map.get(n)>max){
                max = map.get(n);
                most= n;
                others = ed-st+1 - max;
            }
            
            // System.out.println(ed + " "  + others);
            
            
            
            while(others>k){
                
                int nn = nums.get(st);
                map.put(nn, map.get(nn)-1);
                if(map.get(nn)==0)
                    map.remove(nn);
                
                st++;
            }
            
            // the key is below : 
            res = Math.max(res, ed-st+1-others);   // find longest;
            // res+=(ed-st+1);                    // find total number of subarray
        }
        return res;
    }
}