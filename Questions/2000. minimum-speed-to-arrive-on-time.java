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
        if(len-1>=hour){
            return -1;
        }
        
        int st = (int) (Double.valueOf(total)/hour), ed= Integer.MAX_VALUE;
        if(total%hour!=0 && len>1)
            st+=1;
        
        while(st<ed){
            int mid = st + (ed-st)/2;
            
            // System.out.println(st + " " + ed);
            
            if(getTime(mid, dist)<=hour){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        if(getTime(st, dist)<=hour){
            return st;
        }else if(getTime(st+1, dist)<=hour){
            return st +1;
        }
        
        return -1;
    }
    
    
    private double getTime(int speed, int[] dist){
        
        double sum = 0;
        
        int len = dist.length;
        
        for(int i=0; i<len-1; i++){
            int d = dist[i];
            int val = d/speed;
            if(d%speed!=0)
                val+=1;
            sum+=val;            
        }
        
        sum += Double.valueOf(dist[len-1])/Double.valueOf(speed);
        
        // System.out.println("getTime(" + speed + ")=" + sum);
        
        return sum;
        
        
    }
}