// https://leetcode.com/problems/minimum-speed-to-arrive-on-time

class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int total = 0;
        int max= 0;
        for(int d: dist){
            total+=d;
            max = Math.max(max, d);
        }
        
        int len = dist.length;
        if(len-1>Math.floor(hour)){
            return -1;
        }
        
        int st = (int) (Double.valueOf(total)/hour), ed= max;
        if(total%hour!=0)
            st+=1;
        
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            if(getTime(mid, dist)<=Math.floor(hour)){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        return st;
    }
    
    
    private int getTime(int speed, int[] dist){
        
        int sum = 0;
        
        for(int d: dist){
            
            int val = d/speed;
            if(d%speed!=0)
                val+=1;
            sum+=val;            
        }
        
        
        return sum;
        
        
    }
}