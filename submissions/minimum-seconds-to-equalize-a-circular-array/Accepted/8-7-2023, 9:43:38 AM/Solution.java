// https://leetcode.com/problems/minimum-seconds-to-equalize-a-circular-array

class Solution {
    public int minimumSeconds(List<Integer> nums) {
        int siz = nums.size();
        
        HashMap<Integer, List<Integer>>  map= new HashMap<>();
        
        for(int i=0; i<siz; i++){
            map.putIfAbsent(nums.get(i), new ArrayList<>());
            map.get(nums.get(i)).add(i);
        }
        
        
        for(int k : map.keySet()){
            map.get(k).add( siz+map.get(k).get(0)  );
        }
        
        
        
        
        
        int min = Integer.MAX_VALUE;
        for(int k : map.keySet()){
            
            List<Integer> list = map.get(k);
            
            // System.out.println(k + " " + list);
            int max = 0;
            for(int i=0; i<list.size()-1; i++){
                max = Math.max(max, list.get(i+1)-list.get(i)-1);
            }
            
            min = Math.min(min, max);
        }
        
        if(min%2==0)
            return min/2;
        
        return min/2+1;
        
        
        
        
    
    }
}