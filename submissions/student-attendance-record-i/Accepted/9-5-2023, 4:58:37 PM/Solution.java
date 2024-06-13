// https://leetcode.com/problems/student-attendance-record-i

class Solution {
    public boolean checkRecord(String s) {
        int late = 0;
        int absent = 0;
        
        for(char ch : s.toCharArray()){
            
            if(ch=='L'){
                late++;
                if(late >=3)
                    return false;
            }else{
                late = 0;
            }
            
            if(ch=='A')
                absent++;
            
            if(absent>=2)
                return false;
        }
        
        return true;
    }
}