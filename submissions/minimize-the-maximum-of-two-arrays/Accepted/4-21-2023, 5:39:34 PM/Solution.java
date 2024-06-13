// https://leetcode.com/problems/minimize-the-maximum-of-two-arrays

class Solution {
  
    private int gcd(int a,int b){
        return b==0 ? a : gcd(b, a%b);
    }
    
    
    public int minimizeSet(int d1, int d2, int u1, int u2) {
       int st = u1+u2;
       int ed = Integer.MAX_VALUE;
       int ans = 0;
        
       long lcm=((long)d1*(long)d2)/gcd(d1,d2);
        
       while(st<ed){
           
         int m = st+(ed-st)/2;
           
         int a = m - m/d1;
         int b = m - m/d2;
         
         int c = (int) (m - m/d1 - m/d2 + m/lcm );
           
         if( a>=u1 && b>=u2 && (a+b-c >= u1+u2) ){
            ed = m;
            ans = m;
         }
         else{
           st = m+1;
         }
       }
       return ans;
    }
}