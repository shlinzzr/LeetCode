// https://leetcode.com/problems/number-of-flowers-in-full-bloom

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        
        for(int[] f : flowers){
            map.put(f[0], map.getOrDefault(f[0], 0) +1);
            map.put(f[1]+1, map.getOrDefault(f[1]+1, 0) -1);
        }
        
        TreeMap<Integer, Integer> new_map = new TreeMap<>();
        
        int curr=0;
        
        for(Map.Entry<Integer, Integer> en : map.entrySet()){
            
            int time = en.getKey();
            int val = en.getValue();
            
             // System.out.println(time + " " + val);
            
            curr+=val;
            new_map.put(time, curr);
        }
        
        
        
        int[] res = new int[people.length];
        
        for(int i=0; i<people.length; i++){
            
            int p = people[i];
            
            
            
            res[i] = new_map.floorEntry(p).getValue();
        }
        
        return res;
        
        
        
    }
}