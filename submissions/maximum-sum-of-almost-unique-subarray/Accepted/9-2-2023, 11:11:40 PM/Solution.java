// https://leetcode.com/problems/maximum-sum-of-almost-unique-subarray

class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int len = nums.size();
        
        long sum =0; 
        long max = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int st =0;
        for(int ed=0; ed<len; ed++){
            
            int n = nums.get(ed);
            sum+=n;
            map.put(n, map.getOrDefault(n,0)+1);
            
            if(map.size()<m)
                continue;
            // System.out.println(ed + " " +st + " set="+ map.keySet());
            
            while(ed-st+1>k){
                int nn = nums.get(st);
                sum-=nn;
                // System.out.println(nn + " " + map.get(nn));
                
                map.put(nn, map.get(nn)-1);
                if(map.get(nn)==0)
                    map.remove(nn);
                st++;
            }
            
            if(map.size()>=m && (ed-st+1==k)){
                max = Math.max(max, sum);
            }
        }
        
        return max;
    }
}