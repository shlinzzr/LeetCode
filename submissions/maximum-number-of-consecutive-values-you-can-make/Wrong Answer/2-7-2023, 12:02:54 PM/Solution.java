// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        int total=0;
        TreeMap<Integer, Integer> map = new TreeMap<>(); 
        int len = coins.length;
        for(int i=0; i<len; i++){
            total+=coins[i];
            map.put(coins[i], map.getOrDefault(coins[i], 0)+1);
            
            // System.out.println(coins[i] + " "+ map.get(coins[i]) );
            
            
        }
        
        
        int max =1;
        for(int i=1; i<=total; i++){
            
            int key = map.floorKey(i);
            // System.out.println(i + " "+ key + " " + max);
            
            if(map.floorKey(i)!=null && map.get(map.floorKey(i))>0){
                // map.put(key, map.get(map.floorKey(i))-1);
                max++;
            }else{
                break;
            }
            
        }
        
        return max;
        
    }
}