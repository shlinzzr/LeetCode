// https://leetcode.com/problems/heaters

class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        
        int len = houses.length;
        int st = 0;
        int ed = (int) 1e9+7;
        
        TreeSet<Integer> set = new TreeSet<>();
        for(int h : heaters){
            set.add(h);
        }
        
        
        while(st<ed){
            
            int r = st+(ed-st)/2;
            
            boolean bool = isOk(houses, set, r);
            // System.out.println(r + " " + bool);
            if(bool){
                ed = r;
            }else{
                st = r+1;
            }
        }
        
        return st;
        
    }
    
    
    private boolean isOk(int[] houses, TreeSet<Integer> set, long r){
        
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