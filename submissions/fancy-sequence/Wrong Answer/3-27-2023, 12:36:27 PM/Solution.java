// https://leetcode.com/problems/fancy-sequence

class Fancy {

    private long fastPow(long a, long b, long m){
        long ans = 1;
        while(b>0){
            if(b % 2 == 1)
                ans = (ans * a)%m;;
            
            a =  (a*a)%m;
            b >>= 1;
        }
        return ans;
    }
    
    
    // private int quickPow(int x, int y) 
    // {
    //     int ret = 1;
    //     int cur = x;
    //     while (y>0) 
    //     {
    //         if (y&1>0) 
    //         {
    //             ret = (long)ret * cur % M;
    //         }
    //         cur = (long)cur * cur % M;
    //         y >>= 1;
    //     }
    //     return ret;
    // }
    
    private long inv(int x) 
    {
        return fastPow(x, M - 2, M);
    }
    
    
    ArrayList<Long> list = new ArrayList<>();
    
    int mul;
    int add;
    long M = (int) 1e9+7;
    
    
    public Fancy() {
        list = new ArrayList<>();
        mul=1;
        add=0;
    }
    
    public void append(int val) {
        val = (int) ((val-add+M)%M);
        val = (int) (val*inv(mul)%M);
        list.add((long)val);
    }
    
    public void addAll(int inc) {
        
        add=(int) ((add+inc)%M);
    }
    
    public void multAll(int m) {
        mul=(int)((mul*m)%M);
        add=(int)((add*m)%M);
    }
    
    public int getIndex(int idx) {
        if(idx>=list.size())
            return -1;
        else 
            return (int)((list.get(idx) * mul %M +add )%M);
        
        // return (nums[idx]*mul % M + add) % M;
    }
    
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */