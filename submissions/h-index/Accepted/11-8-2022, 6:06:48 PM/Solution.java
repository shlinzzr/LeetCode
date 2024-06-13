// https://leetcode.com/problems/h-index

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int len = citations.length;
        
        int st=0, ed=len-1;
        int mid=0;
        
        int res =0;
        
        
        // st =0, ed=1
        while(st<=ed){
            
            mid = st +(ed-st)/2; //mid=0; , st=1, mid=1
            
            if(citations[mid]==len-mid){ //c=0, l-m==2
                return len-mid;
                
            }else if(citations[mid]>len-mid){
                res = len-mid;
                ed = mid-1;
                
            }else{
                st = mid+1;
            }
            
        }
        
        if(citations[len-1]==0 )
            return 0;
        
        return res;
    }
}