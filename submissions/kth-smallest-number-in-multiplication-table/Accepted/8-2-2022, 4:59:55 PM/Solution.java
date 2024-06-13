// https://leetcode.com/problems/kth-smallest-number-in-multiplication-table

// TLE

// class Solution {
//     public int findKthNumber(int m, int n, int k) {
        
//         PriorityQueue<Tuple> pq = new PriorityQueue<>();
//         for(int i=1; i<=m; i++){
//             pq.offer(new Tuple(i, 1, i));
//         }
//         int res = 0;
        
//         while(k>0 && !pq.isEmpty()){
//             Tuple t = pq.poll();
            
//             res = t.val;
//             k--;
            
//             if(t.y==n)
//                 continue;
//             pq.offer(new Tuple(t.x, t.y+1, t.x*(t.y+1)));
//         }
        
//         return res;
    
//     }
// }


// class Tuple implements Comparable<Tuple>{
    
//     int x, y, val;
//     public Tuple(int x, int y, int val){
//         this.x = x;
//         this.y = y;
//         this.val = val;
        
//     }
    
//     @Override 
//     public int compareTo(Tuple that){
//         return this.val - that.val;
//     }
// }

// Sol: binary search
class Solution {
    public int findKthNumber(int m, int n, int k) {
    	int low = 1 , high = m * n + 1;
        
    	while (low < high) {
    	    int mid = low + (high - low) / 2;
    	    int c = count(mid, m, n);
    	    if (c >= k) high = mid;
            else low = mid + 1;
    	}
        
    	return high;
    }
    
    private int count(int v, int m, int n) {
	int count = 0;
	for (int i = 1; i <= m; i++) {
	    int temp = Math.min(v / i , n);
	    count += temp;
	}
	return count;
    }
}


