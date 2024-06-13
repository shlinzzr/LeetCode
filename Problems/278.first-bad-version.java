// https://leetcode.com/problems/first-bad-version

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int st = 0, ed = Integer.MAX_VALUE;
        
        while(st<ed){ //0, 1
            int m = st+(ed-st)/2; // 0
            
            if(isBadVersion(m)){
                ed = m; //-1
                
            }else{
                st = m+1;//0
            }
        }
        
        return st;
        
    }
}