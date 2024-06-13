// https://leetcode.com/problems/find-k-closest-elements

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        
        int st=0, ed=arr.length-1;
        while(st<ed){
            
            int mid = st+(ed-st)/2;
            
            if(arr[mid]==x){
                st=mid;
                break;
                
            }else if(arr[mid]>x){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        int idx = st;
        for(int i=0; i<k; i++){
            if(idx<0)
                break;
            res.add(arr[idx]);
            idx--;
        }
        
//         for(int r : res)
//             System.out.println(r);
        
//         System.out.println("k="+k);
//         System.out.println("s=" + res.size());
        
        if(k>res.size()){
            idx=st+1;
            for(int i=0; res.size()<k; i++){
                
                 // System.out.println("idx="+idx);
                
                if(idx>arr.length-1)
                    break;
                res.add(arr[idx]);
                idx++;
            }
        }
       // for(int r : res)
       //      System.out.println(r);
        
        
        Collections.sort(res);
        
        return res;
            
    }
    
}