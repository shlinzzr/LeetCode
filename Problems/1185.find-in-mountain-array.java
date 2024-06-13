// https://leetcode.com/problems/find-in-mountain-array

/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int findInMountainArray(int target, MountainArray ma) {
        
        int len = ma.length();
        
        // find peak first and solve separately
        int peak = findPeak(ma);
        int st=0, ed=peak;
        
        while(st<ed){ // 0 1
            int m = st+(ed-st)/2; // 0
            
            if(ma.get(m)==target){
                return m; 
            }else if(ma.get(m)>target){
                ed = m-1; //-1
            }else{ //ma.get(m)<target
                st = m+1;// 1
            }
        }
        
        
        if(ma.get(st)==target){
            return st;
        }
        
        st=peak;
        ed=len-1;
        
        while(st<ed){ // 0, 1
            int m = st+(ed-st)/2; // 0
            
            if(ma.get(m)==target){
                return m;
            }else if(ma.get(m) > target){
                st = m+1; // 1
            }else {
                ed = m-1;// -1
            }
        }
        
        if(ma.get(st)==target) return st;
        
      
        
        return -1;
        
    }


    private int findPeak(MountainArray ma){
        int len = ma.length();
        int st =1, ed=len-2;
        
        while(st<ed){ // 0 ,1
            int m = ed- (ed-st)/2; // 1
            
            if(ma.get(m)>ma.get(m-1) && ma.get(m)>ma.get(m+1)){
                return m;
            }else if(ma.get(m)>ma.get(m-1)){
                st = m; // 1
                
            }else{ //ma.get(m)<ma.get(m-1)
                ed = m-1; // 0
                
            }
            
        }
        
        return st;
            
            
        
        
    }
}