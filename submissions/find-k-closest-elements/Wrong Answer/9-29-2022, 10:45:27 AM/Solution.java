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
        
        
        if(st>0 && Math.abs(arr[st]-x) > Math.abs(arr[st-1]-x))
            st -= 1;
        
        int left=st, right=st+1;
        
        
        
        for(int i=0; i<k; i++){
            
            if(right>=arr.length || left>=0 && (Math.abs(arr[left]-x)<Math.abs(arr[right]-x) || (Math.abs(arr[left]-x)==Math.abs(arr[right]-x)&&arr[left]<=arr[right]))){
                    res.add(arr[left]);
                    left--;
            }else {
                res.add(arr[right]);
                right++;
            }
        }
            
            
        
        
        
        
        
        Collections.sort(res);
        
        return res;
            
    }
    
}