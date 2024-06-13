// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int minFail=n;
        int st =1, ed = n;
        
        while(st<ed){
            
            int mid = (st+ed)/2;
            
            if(isBadVersion(mid)==false){
                st = mid+1;
              
                
            } else{
                ed = mid-1;
                if(mid<minFail)
                    minFail = mid;
            
            }
                
            
        }
        
        return minFail;
    }
}