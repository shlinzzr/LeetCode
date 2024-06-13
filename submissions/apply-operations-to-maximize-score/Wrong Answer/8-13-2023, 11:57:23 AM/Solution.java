// https://leetcode.com/problems/apply-operations-to-maximize-score

class Solution {
    public int maximumScore(List<Integer> nums, int k) {
        int siz = nums.size();
        
        List<Integer> prime_score = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> (Integer.compare(b[0],a[0])==0?  Integer.compare(a[2],b[2]) : Integer.compare(b[0],a[0]))
        );
        
        
        for(int i=0; i<siz; i++){
            int n = nums.get(i);
            List<Integer> list = sieveOfEratosthenes(n);
            
            int cnt = 0;
            for(int j=0; j<list.size(); j++){
                
                if(n%list.get(j)==0)
                    cnt++;
            }
            prime_score.add(cnt);
            
            // System.out.println(i + " "  + list.toString());
            
            pq.offer(new int[]{n, cnt, i}); // val, primescore, idx
        }
        
        HashSet<String> set = new HashSet<>();
        
        
        int score = 1;
        
        while(k>0 && !pq.isEmpty()){
            
            int[] p = pq.poll();
            int n=p[0];
            int ps=p[1];
            int idx = p[2];
            
             // System.out.println("ps="+ps);
            
            for(int i=idx; i<siz && prime_score.get(i)<=ps && !set.contains(idx+"_"+i) && k>0; i++){
                
                set.add(idx+"_"+i);
                // System.out.println(idx+"_"+i + "   " + "prime_score.get(i)="+prime_score.get(i));
                
                
                // n = nums.get(i);
                
                score *= n;
                
                k--;
            }
            
            
        }
        
        return score;
        

        
        
            
        
        
    }
    
    
       public List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] primes = new boolean[n + 1];
        Arrays.fill(primes, true);
        primes[0]=false;
        primes[1]=false;
          
        for (int i = 2; i*i <= n; i++) {
            if (primes[i]) {
                for (int j = 2*i; j <= n; j += i) {
                    primes[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                result.add(i);
            }
        }
        return result;
    }
}