// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        
        int minFail=n;
        int st =0, ed = n;
        
        while(st<ed){
            
            int mid =st + (ed-st)/2;
            
            if(isBadVersion(mid)==true){
               
               ed = mid;
                if(mid<minFail)
                    minFail = mid;
                
            } else{
               
                 st = mid+1;
            }
                
            
        }
        
        return minFail;
    }
}