// https://leetcode.com/problems/minimize-the-maximum-of-two-arrays

class Solution {
   
    public int minimizeSet(int d1, int d2, int u1, int u2) {
        long left = 1, right = Long.MAX_VALUE;
        while (left < right)
        {
            long mid = left + (right-left)/2;
            if (NotEnough(d1, d2, u1, u2, mid))
                left = mid+1;
            else
                right  = mid;
        }
        return (int)left;        
    }
        
    private long lcm(long n1, long n2) {

        // maximum number between n1 and n2 is stored in lcm
        long lcm = (n1 > n2) ? n1 : n2;

        // Always true
        while(true) {
          if( lcm % n1 == 0 && lcm % n2 == 0 ) {
            // System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
            break;
          }
          ++lcm;
        }
        return lcm;
    }
    
   

    public boolean NotEnough(long divisor1, long divisor2, long uniqueCnt1, long uniqueCnt2, long n)
    {
        long a = n - n/divisor1;
        long b = n - n/divisor2;
        long c = n - (n/divisor1 + n/divisor2 - n/lcm(divisor1,divisor2));

        if (a < uniqueCnt1) return true;
        if (b < uniqueCnt2) return true;
        if (a+b-c < uniqueCnt1 + uniqueCnt2) return true;
        return false;
    }
}
