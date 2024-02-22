// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table

class Solution {
    
    
    public int findKthNumber(int m, int n, int k) {
    	int st = 1 , ed = m * n + 1;
        
    	while (st < ed) {
    	    int mid = st + (ed - st) / 2;
    	    if ( count(mid, m, n) < k) 
                st = mid +1;
            else
                ed = mid;
    	}
        
    	return st;
    }
    
    private int count(int v, int m, int n) {
        int count = 0;
        for (int i = 1; i <= m; i++) {
            count += Math.min(v / i , n);
        }
        return count;
    }
    
    
    // TLE
//     public int findKthNumber(int m, int n, int k) {
//         PriorityQueue<int[]> pq = new PriorityQueue<>(
//             (a,b) -> a[0]-b[0]
//         );
            
        
//         for(int i=1; i<=m; i++){
//             pq.offer(new int[]{i, i, 1});
//         }
        
//         while(!pq.isEmpty()&& k>1){
            
//             int[] p = pq.poll();
//             int val = p[0];
//             int i = p[1];
//             int j = p[2];
            
//             // System.out.println(val+ " " + i + " " + j);            
            
//             if(j+1<=n){
//                 pq.offer(new int[]{i*(j+1), i, j+1});
//             }
            
//             k--;
//         }
        
//         return pq.peek()[0];
//     }
}