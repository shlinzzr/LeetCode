// https://leetcode.com/problems/sell-diminishing-valued-colored-balls

class Solution {
    
    int M =(int) 1e9+7;
    
    public int maxProfit(int[] arr, int orders) {
        int len = arr.length;
        
        Arrays.sort(arr);
        reverse(arr);
        
        long ret = 0;
        
        long st = 1, ed = arr[0];
        
        while(st<ed){
            
            long mid = st + (ed-st)/2;
            
            if(helper(arr , mid) <=orders ){
                ed = mid;
            }else{
                st = mid+1;
            }
        }
        
        long k = st;
        for(int i=0; i<len; i++){
            if(arr[i]<k) break;
            ret += (arr[i]+k) * (arr[i]-k+1)/2%M;
            ret %= M;
        }
        long r = orders- helper(arr, k);
        ret += (k-1)*r;
        return (int)ret%M;
        
        
        
//         if(isOk(in, st, orders)){
//             return st;
//         }else if(isOk(in, st, orders)){
//             return st +1;
//         }
//         return -1;
        
    }
    
    private void reverse(int[] arr){
        
        int len = arr.length;
        
        for(int i=0; i<len/2; i++){
            int t = arr[i];
            arr[i] = arr[len-i-1];
            arr[len-i-1] = t;
        }
        
    }
    
    
    
    private long helper(int[] arr,  long k)
    {
        long  total = 0;
        for (int i=0; i<arr.length; i++)
        {
            if (arr[i]<k) break;
            total += arr[i]-k+1;
        }
        return total;
    }
    
}