// https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array

class Solution {
    public int maxValue(int n, int index, int maxSum) {
        
        // huifeng woadge https://www.youtube.com/watch?v=VH1UevGQ4KQ
        
        
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
        // 前半
        if (h > index)
        {
            sum += (h-index + h)*(index+1)/2;
        }
        else
        {
            sum += (1+h)*h/2;
            sum += index+1-h;
        }
       
        //後半
        if (h > n-index)
        {
            sum += (h + h-(n-index)+1)*(n-index)/2;
        }
        else
        {
            sum += (h + 1)*h/2;
            sum += (n - (index+h));
        }
        return sum-h; //中間算了兩次 所以要剪掉
       
    }
}