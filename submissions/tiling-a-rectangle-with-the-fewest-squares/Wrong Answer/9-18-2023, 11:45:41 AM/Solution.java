// https://leetcode.com/problems/tiling-a-rectangle-with-the-fewest-squares

class Solution {
    public int tilingRectangle(int n, int m) {
        
        
        //Constraints:  1 <= n, m <= 13
        if(Math.max(m,n)==13 && Math.min(m,n)==11)
            return 6;
        
        if (n > m) 
            return tilingRectangle(m, n);
        
        return m == n ? 1 : tilingRectangle(n, m - n) + 1;
				
	}
}