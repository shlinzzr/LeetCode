// https://leetcode.com/problems/valid-perfect-square

class Solution {
    public boolean isPerfectSquare(int num) {
         // return (Math.ceil(Math.sqrt(num))==(int)(Math.sqrt(num)));
    
        int low = 1, high = num;
        while (low <= high) {
            long mid = (low + high) >>> 1;
            
            System.out.println(mid);
            
            if (mid * mid == num) {
                return true;
            } else if (mid * mid < num) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        return false;
    }
    
}