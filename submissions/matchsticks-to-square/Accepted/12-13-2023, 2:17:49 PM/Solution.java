// https://leetcode.com/problems/matchsticks-to-square

class Solution {
    public boolean makesquare(int[] matchsticks) {
        int len = matchsticks.length;

        int sum = 0;
        for(int m : matchsticks){
            sum+=m;
        }

        if(sum%4!=0) return false;

        int target = sum/4;

        Arrays.sort(matchsticks);

        return match(matchsticks, len-1, 0,0,0,0,target);

        // int[] arr = new int[4];

        // for(int i=len-1; i>=0; i--;){

        //     int m = matchsticks[i];

        //     for()

        // }
    }

     public boolean match(int[] matchsticks, int index, int top, int bottom, int left, int right, int target) {
        
        if (top == target && bottom == target && left == target && right == target) return true;

        if (top > target || bottom > target || left > target || right > target) return false;
                        
        int val = matchsticks[index];
        
        boolean t = match(matchsticks, index - 1, top + val, bottom, left, right, target);
        if (t) return true;
        boolean b = match(matchsticks, index - 1, top, bottom + val, left, right, target);
        if (b) return true;
        boolean l = match(matchsticks, index - 1, top, bottom, left + val, right, target);
        if (l) return true;
        boolean r = match(matchsticks, index - 1, top, bottom, left, right + val, target);
        if (r) return true;
        
        return false;
    }
}