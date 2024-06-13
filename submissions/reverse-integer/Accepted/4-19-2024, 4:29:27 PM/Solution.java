// https://leetcode.com/problems/reverse-integer

class Solution {
    public int reverse(int x) {

        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        boolean sign=false;
        if(x<0){
            x=-x;
            sign=true;
        }

        int rev = 0;

        while(x>0){
            if(rev>max/10 || (rev==max/10 && x%10 > max%10)) return 0;
            rev = rev*10+ x%10;
            x/=10;
        }

        return sign ? -rev : rev;
        
    }
}