// https://leetcode.com/problems/max-points-on-a-line

class Solution {
    public int maxPoints(int[][] points) {
        int len = points.length;
        
        if(len<=2)
            return len;
        
        int res =0 ;
        
        for(int i=0; i<len; i++){
            
            HashMap<String, Integer> map = new HashMap<>();
            int dulpicate = 1;
            int max = 0;
            
            for(int j=i+1; j<len; j++){
                
                int deltaX = points[i][0]-points[j][0];
                int deltaY = points[i][1]-points[j][1];
                
                if(deltaX==0 && deltaY==0){
                    dulpicate++;
                    continue;
                }
                
                int gcd = gcd(deltaX, deltaY);
                int dx = deltaX/gcd;
                int dy = deltaY/gcd;
                    
                String key = dx+","+dy;
                map.put(key, map.getOrDefault(key,0)+1);
                
                max = Math.max(max, map.get(key));
            }
            
            res = Math.max(res, max+dulpicate);
        }
        
        return res;
    }
    
    private int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}