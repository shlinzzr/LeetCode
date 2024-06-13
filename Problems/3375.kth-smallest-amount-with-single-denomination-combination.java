// https://leetcode.com/problems/kth-smallest-amount-with-single-denomination-combination

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        int n = coins.length;
        ArrayList<Integer> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            boolean can = true;
            for(int j = 0; j < n && can; j++) {
                if(i!=j) {
                    if(coins[i]%coins[j]==0) can = false;
                }
            }
            if(can) temp.add(coins[i]);
        }
        n = temp.size();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) arr[i] = temp.get(i);
        long l = 0;
        long r = Long.MAX_VALUE;
        boolean qwe = false;
        while(l <= r) {
            long m = (r-l)/2l+l;
            while(!check(m, arr)) {
                if(qwe) m++;
                else m--;
            }
            qwe = !qwe;
            
            long cnt = 0;
            for(int i = 1; i < (1<<arr.length); i++) {
                long LCM = 1;
                int bits = 0;
                for(int j = 0; j < arr.length; j++) {
                    if((i&(1<<j))==(1<<j)) {
                        bits++;
                        LCM = lcm(LCM, arr[j]);
                    }
                }
                if(bits%2==1) cnt += m/LCM;
                else cnt -= m/LCM;
            }
            
            if(cnt > k) r = m-1;
            else if(cnt < k) l = m+1;
            else return m;
        }
        
        return l;
    }
    
    public long gcd(long a, long b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }
    
    public long lcm(long a, long b) {
        return (a/gcd(a, b)) * b;
    }
    
    public boolean check(long x, int[] arr) {
        for(int y : arr) if(x%((long)y)==0) return true;
        return false;
    }
}