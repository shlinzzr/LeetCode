// https://leetcode.com/problems/fruit-into-baskets

class Solution {
    public int totalFruit(int[] fruits) {
        
        int len = fruits.length;
        int max = 0;
        
        if(len<2) return len;
        
        for(int st=0; st<len; st++){
            
            int cnt = 0;
            Set<Integer> set = new HashSet<>();
            
            for(int step = 0; step<len; step++){
                
                int idx= (st+step)%len;
                int type = fruits[idx];
                
                set.add(type);
                cnt++;
                if(set.size()<=2){
                    max = Math.max(max, cnt);
                }else{
                    break;
                }
            }
            
        }
        
        return max;
        
    }
}