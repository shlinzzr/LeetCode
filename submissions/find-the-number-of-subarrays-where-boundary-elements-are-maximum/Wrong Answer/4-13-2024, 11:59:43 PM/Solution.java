// https://leetcode.com/problems/find-the-number-of-subarrays-where-boundary-elements-are-maximum

class Solution {
    public long numberOfSubarrays(int[] nums) {
        Map<Integer ,List<Integer>> map = new HashMap<>();
        
        
        TreeMap<Integer, Integer>cntMap = new TreeMap<>();
        
        
        
        int len = nums.length; 
        
        for(int i=0; i<len ;i++){
            
            cntMap.put(nums[i], cntMap.getOrDefault(nums[i],0)+1);
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        } 
        
        long res = 0 ;
        
        
        
        for(int i=0; i<len; i++){
            int cur = nums[i];
            
            cntMap.put(cur, cntMap.get(cur)-1);
            if(cntMap.get(cur)==0) cntMap.remove(cur);
            
            if(!cntMap.containsKey(cur)){
                
            }
            
            List<Integer> list = new ArrayList<>();
            list.add(i);
            
            int j=i;
            while(j+1<len && nums[j+1]<=cur ){
                j++;
                
                if(nums[j]==cur)
                    list.add(j);
            }
            
            
            
            long size = (long )list.size();
            
//             n * (n-1) /2 ;
//             1 n-1
//             2 n-2
//                 ...
//             n-1 1
            
            
            res +=  size * (size+1)/2;
            System.out.println(cur + " " + res);
            i=j;
            
        }
        
        return res;
    }
    
    
}