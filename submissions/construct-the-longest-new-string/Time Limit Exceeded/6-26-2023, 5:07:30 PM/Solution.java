// https://leetcode.com/problems/construct-the-longest-new-string

class Solution {
    
    
    int max = 0;
    
    public int longestString(int x, int y, int z) {
        
        // x =AA, y=BB, z=AB, not allow AAA, BBB,
        // find max len
        
        // xx, xz, yy, zy, not allow
        
        helper(x,y,z,-1, "");
        
        
        return max;
    }
    
    private void helper(int x, int y, int z, int prev, String curr){
        
        if(x==0 && y==0 && z==0){
            max = Math.max(max, curr.length());
            
            // System.out.println(1+ " " + curr);
            return;
        }
        
        if(prev==0 && y==0){
            max = Math.max(max, curr.length());
            // System.out.println(2+ " " + curr);
            return;
        }
        
        if(prev==1 && x==0 && z==0){
            max = Math.max(max, curr.length());
            // System.out.println(3+ " " + curr);
            return;
        }
        
        if(prev==2 && x==0 && z==0){
            max = Math.max(max, curr.length());
            // System.out.println(4+ " " + curr);
            return;
        }
        
        if(x>0 && prev!=0)
            helper(x-1, y, z, 0, curr+"AA");
        
        if(y>0 && prev!=1 && prev!=2)
            helper(x, y-1, z, 1, curr+"BB");
        
        if(z>0 && prev!=0)
            helper(x, y, z-1, 2, curr+"AB");
            
        
        
        
        
    }
    
}