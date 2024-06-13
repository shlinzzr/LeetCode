// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        
        int st=0, ed=len-1;
        
        int res =0;
        
        while(st<=ed){
            
            int mid = st +(ed-st)/2;
            
//             if(citations[mid]==len-mid){
//                 return len-mid;
//             }else 
                
            if(citations[mid]>=len-mid){
                res=len-mid;
                ed = mid-1;
                
            }else{
                st = mid+1;
            }
            
        }
        return res;
    }
}