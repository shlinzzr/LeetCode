// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        
        // solution 1 : priorityQueue
        
        //solutions 2 : binarySearch
        
        List<Integer> res = new ArrayList<>();
        
        int st=0, ed=arr.length-k;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(x-arr[mid]>arr[mid+k]-x){  // 前半段比較大 => window往後移
                st = mid+1;
            }else{
                ed = mid;
            }
        }
        
        for(int i=0; i<k; i++){
            res.add(arr[st]);
            st++;
        }
        
        return res;
        
        
        
    }
}