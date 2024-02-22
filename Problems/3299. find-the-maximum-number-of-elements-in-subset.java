// https://leetcode.com/problems/find-the-maximum-number-of-elements-in-subset

class Solution {
    public int maximumLength(int[] nums) {
         
        TreeMap<Long, Integer> map = new TreeMap<>();
        
        for(int n : nums){
            map.put((long)n, map.getOrDefault((long)n,0)+1);
        }
        
    
        
        Set<Long> set = new HashSet<>();
        
        int max= 1;
        
        
        
        if(map.containsKey(1L)){
            if(map.get(1L)%2==1)
                 max = Math.max(max, map.get(1L));
            else 
                 max = Math.max(max, map.get(1L)-1);
        }
        for(long k : map.keySet()){
            
            
            int cnt=0;
            
            while(map.getOrDefault(k,0)>=2 && !set.contains(k)){
                
                set.add(k);
                cnt+=2;
                k = k*k;
            }
           
            if(cnt>0 && map.getOrDefault(k, 0)==1){
                cnt++;
            }else
                cnt--;
            
            
          
            max = Math.max(max, cnt);
            // System.out.println(k+ " " +set+ " " +max);
            
        }
        
        return max;
        
        // 2 4 16 256 
        //[x, x^2, x^4, x^8 , x^k/2, xk,
        
        
    }
}