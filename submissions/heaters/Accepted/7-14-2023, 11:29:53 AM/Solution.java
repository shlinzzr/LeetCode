// https://leetcode.com/problems/heaters

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        int len = houses.length;
        int st = 0;
        int ed = (int) 1e9+7;
        
        while(st<ed){
            
            int r = st+(ed-st)/2;
            
            boolean bool = isOk(houses, heaters, r);
            // System.out.println(r + " " + bool);
            if(bool){
                ed = r;
            }else{
                st = r+1;
            }
        }
        
        return st;
        
    }
    
    
    private boolean isOk(int[] houses, int[] heaters, long r){
        
        int hlen = houses.length;
        int helen = heaters.length;
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int h : heaters){
            set.add(h);
        }
        
        for(int h  : houses){
            
            if(set.ceiling(h)==null && set.floor(h)==null)
                return false;
            
            // System.out.println("r="+r + " h="+h + " set.ceiling(h)="+set.ceiling(h) + " set.floor(h)="+set.floor(h));
            
            if((set.ceiling(h)!=null && set.ceiling(h)-h<=r )|| (set.floor(h)!=null && h-set.floor(h)<=r))
                continue;
            
            
            
            return false;
        }
        
        return true;
        
        
        
    }
}