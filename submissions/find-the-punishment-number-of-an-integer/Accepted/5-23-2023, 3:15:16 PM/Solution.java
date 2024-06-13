// https://leetcode.com/problems/find-the-punishment-number-of-an-integer

class Solution {
    public int punishmentNumber(int n) {
        
        int sum=0;
        for(int i=1; i<=n; i++){
            
            int sq = i*i;
            String s = String.valueOf(sq);
            if(helper(s, i))
                sum += sq;
        }
        
        return sum;
    }
    
    private boolean helper(String s, int target){
        if (s.isEmpty() && target == 0) return true;
        if (target < 0) return false;
        
        boolean ans = false;
        
        for (int i = 0; i < s.length(); i++) //try all possible pivot points
        {
            String left = s.substring(0, i + 1); //keep the left part
            String right = s.substring(i + 1); //recurse for right  part
            int leftNum = Integer.valueOf(left);
            
            boolean isPossible = helper(right, target - leftNum);
            if (isPossible) { ans = true; break; }
        }
        return ans;
        
    }
}