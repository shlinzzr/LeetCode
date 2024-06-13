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
        
        int st = 0; 
        int ed = ma.length()-1;
        
        
        //find peak
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(ma.get(mid)<ma.get(mid+1)){
                st = mid+1;
            }else{
                ed= mid;
            }
        }
        
        int peak = st;
        
        st=0;
        ed = peak;
        
        while(st<ed){
            int mid = st+(ed-st)/2;
            
            if(ma.get(mid)==target)
                return mid;
            
            else if(ma.get(mid)>target){
                ed = mid-1;
            }else{
                st = mid+1;
            }            
        }
        
        if(ma.get(st)==target)
            return st;
        
        st = peak;
        ed = ma.length()-1;
        
        while(st<ed){
            
            int mid = st = (ed-st+1)/2;
            
            if(ma.get(mid)==target) 
                return mid;
            else if(ma.get(mid)>target){
                
                st = mid+1;
            }else{
                ed = mid-1;
            }            
        }
        
        if(ma.get(st)==target)
            return st;
        return -1;
        
    }
    
}