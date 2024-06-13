// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        
        int st=0, ed=len-1;
        int mid=0;
        
        while(st<ed){
            
            mid = st +(ed-st)/2;
            
            
            
            if(citations[mid]==len-mid){
                return len-mid;
            }else 
                
            if(citations[mid]>len-mid){
                ed = mid-1;
                
            }else{
                
                st = mid+1;
            }
            
        }
        
        if(citations[0]==0)
            return 0;
        
        return len-ed;
    }
}