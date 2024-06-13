// https://leetcode.com/problems/apply-operations-to-maximize-score

class Solution {
    
    int M = (int) 1e9+7;
    
    public int maximumScore(List<Integer> nums, int k) {
        int len = nums.size();
        
        int max = 0;
        for(int n: nums){
            max = Math.max(max, n);
        }
        int[] distinctPrimeFactors = sieveOfEratosthenes(max);
        
        long[] scores = new long[len];
        for(int i=0; i<len; i++){
            scores[i] = distinctPrimeFactors[nums.get(i)];
        }
        
        int[] prevLarger = new int[len];
        Arrays.fill(prevLarger, -1);
        
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<len; i++){
            
            while(!st.isEmpty() && scores[st.peek()] < scores[i]){
                st.pop();
            }
            if(!st.isEmpty())
                prevLarger[i] = st.peek();
            st.push(i);
        }
        
        int[] nextLarger = new int[len];
        Arrays.fill(nextLarger, len);
        
        
        st.clear();
        for(int i=len-1; i>=0; i--){
            
            while(!st.isEmpty() && scores[st.peek()]<=scores[i]){
                st.pop();
            }
            if(!st.isEmpty())
                nextLarger[i] = st.peek();
            st.push(i);
        }
        
        
        
        Tuple[] temp = new Tuple[len];
        for(int i=0;i<len; i++){
            long t = (long)(i-prevLarger[i]+1)*(nextLarger[i]-i+1);
            temp[i] = new Tuple(nums.get(i), t);
        }
        
        
        Arrays.sort(temp, (a,b)-> Long.compare(b.n, a.n));
        
        
        long res = 1;
        for(Tuple tmp : temp){
            
            long n = tmp.n;
            long t = tmp.t;
            
            if((long)k >= t){
                res = res * quickMul(n, t)%M;
                k-=t;
            }else{
                res = res * quickMul(n, k)%M;
                k=0;
            }
            
            if(k==0)
                break;
        }
        
        return (int)res;
        
    }
    
    class Tuple{
        long n;
        long t;
        public Tuple(long n, long t){
            this.n=n;
            this.t=t;
        }
    }
    
    private long quickMul(long x, long n){   
        if (n == 0) {
            return 1;
        }
        
        long y = quickMul(x, n / 2) % M;
        
        return n % 2 == 0 ? (y * y % M) : (y * y % M * x % M);
    }
    
    
    
    public int[] sieveOfEratosthenes(int n) {
    
        int[] factors = new int[n+1];
        for (int i=2; i<=n; i++){
            if (factors[i]>0) 
                continue;
            
            factors[i] = 1;
            for(int j=i*2; j<=n; j+=i){
                factors[i]++;
            }
        }        
        return factors;
    }
}