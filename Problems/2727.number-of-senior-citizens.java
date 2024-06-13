// https://leetcode.com/problems/number-of-senior-citizens

class Solution {
    public int countSeniors(String[] details) {
        
        int res = 0; 
        for(String s : details){
            String sub = s.substring(11, 13);
            int age = Integer.valueOf(sub);
            if(age>60)
                res++;
        }
        
        
        return res;
        
    }
}