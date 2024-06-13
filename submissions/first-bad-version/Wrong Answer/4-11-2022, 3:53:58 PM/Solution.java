// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int lo = 0;
        int hi = n;
        
        int max = 0;
        
        while(lo<=hi){
            
            int mid = lo + (hi-lo)/2;
            if(isBadVersion(mid)==true){
                if(mid>max)
                    max = mid;
                hi = mid-1;
            }else 
                lo = mid+1;
        }
        
        
        return max;
        
    }
}