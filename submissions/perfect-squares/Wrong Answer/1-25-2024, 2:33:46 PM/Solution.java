// https://leetcode.com/problems/perfect-squares

class Solution {
    public int numSquares(int n) {
        
        
        int cnt= 0;
        while(n>0){
            
            int st=1, ed=n;
            while(st<ed){
                int mid = ed-(ed-st)/2;
                if((int)Math.pow(mid, 2)<=n){
                    st = mid;
                }else {
                    ed = mid-1;
                }
            }
            
            n-= (int) Math.pow(st, 2);
            System.out.println(st+" " + n );
            cnt++;
            
            
        }
        
        
        return cnt;
        
    }
}