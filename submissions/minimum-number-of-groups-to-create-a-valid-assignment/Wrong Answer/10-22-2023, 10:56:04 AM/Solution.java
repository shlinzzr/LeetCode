// https://leetcode.com/problems/minimum-number-of-groups-to-create-a-valid-assignment

class Solution {
    public int minGroupsForValidAssignment(int[] nums) {
        HashMap<Integer, Integer> map =new HashMap<>();
        for(int n : nums){
            map.put(n, map.getOrDefault(n,0)+1);
        }
        
        int min = Integer.MAX_VALUE;
        for(int k : map.keySet()){
            min = Math.min(min, map.get(k));
        }
        
        
        int g=0;
        for(int k : map.keySet()){
            int cnt = map.get(k);
            if(cnt<=min+1){
                g++;
                continue;
            }else{
                
                g+=cnt/(min+1);
                
                if(cnt%(min+1)!=0)
                    g++;
                
            }
            
        }
        
        return g;
        
    } 
}