// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        
        
        
        int st=0, ed=arr.length-k;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
//             if(arr[mid]==x){
//                 st=mid;
//                 break;
                
//             }else 
            if(x-arr[mid]>arr[mid+k]-x){
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        for(int i=0; i<k; i++){
            res.add(arr[st]);
            st++;
        }
        
        
        
        
        
        // Collections.sort(res);
        
        return res;
            
    }
    
}