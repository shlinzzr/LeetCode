// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        int st =1, ed=maxSum;
        
        while(st<ed){
            int mid = st + (ed-st+1)/2;
            
            if(getSum(mid, n, index)<=maxSum){
                st = mid;
            }else{
                ed = mid-1;
            }
        }
        
        if(getSum(st, n, index)<=maxSum){
            return st;
        }else{
            if(getSum(st-1, n, index)<=maxSum)
                return st-1;
        }
        
        
        return -1;
    }
    
    private long getSum(long h, long n, long index){
         // return n * mid /2;
        
        long sum = 0;
        if (h > index)
        {
            sum += (h-index + h)*(index+1)/2;
        }
        else
        {
            sum += (1+h)*h/2;
            sum += index+1-h;
        }
        if (h > n-index)
        {
            sum += (h + h-(n-index)+1)*(n-index)/2;
        }
        else
        {
            sum += (h + 1)*h/2;
            sum += (n - (index+h));
        }
        return sum-h;
       
    }
}