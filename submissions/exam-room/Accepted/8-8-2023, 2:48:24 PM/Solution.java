// https://leetcode.com/problems/exam-room

class ExamRoom {
    
    private PriorityQueue<int[]> pq;
    private int N;

    public ExamRoom(int N) {
        this.N = N;
        pq = new PriorityQueue<>((a, b) -> {
            if ((b[1] - b[0]) / 2 == (a[1] - a[0]) / 2) {
                return a[0] - b[0];
            }
            return (b[1] - b[0]) / 2 - (a[1] - a[0]) / 2;
        });
    }
    
    public int seat() {
        if (pq.size() == 0) {
            pq.offer(new int[]{0, 2 * (N - 1)}); // left, right 
            return 0;
        } else {
            int[] longest = pq.poll();
            int mid = longest[0] + (longest[1] - longest[0]) / 2;  // mid = left+(right-left)/2
            
            // 一次加兩個候選 (left, mid) 跟 (mid, right)
            if (mid != 0) { // mid = 0, we don't need to add the left side
                pq.offer(new int[]{longest[0], mid}); // left, mid
            }
            if (mid != N - 1) { // mid = N - 1, we don't need to add the right side
                pq.offer(new int[]{mid, longest[1]}); // mid, right 
            }
            return mid;
        }
    }
    
    public void leave(int p) {
        if (pq.size() == 1 && (pq.peek()[1] >= N || pq.peek()[0] < 0)) { // Edge cases: Only [0, 2N] or [-N , N] in pq
            pq.clear();
            return;
        }
        
        // find p1 & p2
        int[] p1 = null, p2 = null; // p1: left side, p2: right side
        for (int[] pair : pq) {
            if (pair[1] == p) {   // find p1(left, p)
                p1 = pair;
            }
            if (pair[0] == p) {   // find p2(p, right);
                p2 = pair;
            }
        }
        
        if (p1 != null) {
            pq.remove(p1);
        }
        
        if (p2 != null) {
            pq.remove(p2);
        }
        
        
        // normal case :
        // 0 1 2 3 4 5 6 7 8
        // x x x x x x x x x 
        // a   d   c       b
        // leave(c) =>  p1(2, 4), p2(4, 8)
        // 幹掉c 也要幹掉 d 跟 b
        
        // =>
        
        // pq.offer(2, 8)
        // 0 1 2 3 4 5 6 7 8
        // x x x x x x x x x 
        // a         b
        
        
        
        if (p1 == null || p1[0] < 0) { // No left side found or p is the left most position in current seats.
            p1 = new int[]{-p2[1], p}; // p1=(-right, p)
        }
        
        // no left side case:
        
        // -4 -3 -2 -1 0 1 2 3 4 5 6 7 8
        //             x x x x x x x x x 
        //                 d   c       b
        // ^^^^^^^^^^^^^^^^^
        // leave(d) =>  p1==null , p2(2, 4)
        // 幹掉d 也要幹掉c, p1=(-4, 2)
        
        
        
        
        
        
        
        if (p2 == null || p2[1] >= N) { // No right side found or p is the right most position in current seats.
            p2 = new int[]{p, p1[0] + 2 * (N - p1[0] - 1)};    // p2=(p, left+2*(len-left-1))
        }
        
        pq.offer(new int[]{p1[0], p2[1]});
    }
}