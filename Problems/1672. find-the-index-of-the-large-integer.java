// https://leetcode.com/problems/find-the-index-of-the-large-integer

/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     // Compares the sum of arr[l..r] with the sum of arr[x..y] 
 *     // return 1 if sum(arr[l..r]) > sum(arr[x..y])
 *     // return 0 if sum(arr[l..r]) == sum(arr[x..y])
 *     // return -1 if sum(arr[l..r]) < sum(arr[x..y])
 *     public int compareSub(int l, int r, int x, int y) {}
 *
 *     // Returns the length of the array
 *     public int length() {}
 * }
 */

class Solution {
    public int getIndex(ArrayReader reader) {
        
        int st=0;
        int ed = reader.length()-1;
        
        while(st<ed){
            
            int mid = st+(ed-st+1)/2;
            
            if((ed-st+1)%2==1){
                int res = reader.compareSub(st, mid-1, mid+1, ed);
                
                if(res==0)
                    return mid;
                else if(res==1){
                    ed=mid-1;
                }else{
                    st=mid+1;
                }
                
            }else{
                int res = reader.compareSub(st, mid-1, mid, ed);                
                if(res==0)
                    return -1;
                else if(res==1){
                    ed=mid-1;
                    
                }else{
                    st= mid;
                }
            }
        }
        
        return st;
        
        
        
    }
}