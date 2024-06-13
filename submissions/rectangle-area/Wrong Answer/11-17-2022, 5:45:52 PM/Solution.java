// https://leetcode.com/problems/rectangle-area

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
         int area1 = Math.abs(ax1-ax2) * Math.abs(ay1-ay2);
         int area2 = Math.abs(bx1-bx2) * Math.abs(by1-by2);
        
        
        int area3 = Math.abs(ax2-bx1)*Math.abs(by2-ay1);
        
        return area1+area2-area3;
        
    }
}