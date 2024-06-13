// https://leetcode.com/problems/maximum-number-of-consecutive-values-you-can-make

class Solution {
    public int getMaximumConsecutive(int[] coins) {
        
        int total=0;
        TreeMap<Integer, Integer> temp = new TreeMap<>(); 
        int len = coins.length;
        for(int i=0; i<len; i++){
            total+=coins[i];
            temp.put(coins[i], temp.getOrDefault(coins[i], 0)+1);
        }
        
        
       
        
        
        int max =1;
        for(int i=1; i<=total; i++){
            
            TreeMap<Integer, Integer> map = new TreeMap<>(temp);
            
            int sum = i ;
            
            boolean succ = true;
            while(sum>0){
                Integer key = map.floorKey(sum);
                
                System.out.println(i +" "  +sum + " " +key);
                System.out.println(i +" "  +sum + " " + (map.get(key)>0));
                if(key!=null && map.get(key)>0){
                    map.put(key, map.get(key)-1);
                    System.out.println(map.get(key));
                    sum-=key;
                    
                }else{
                    succ=false;
                    break;
                }   
                
               
            }
            
            if(succ==false)
                break;
            
             max=Math.max(max,i+1);
            
        }
        
        return max;
        
    }
}