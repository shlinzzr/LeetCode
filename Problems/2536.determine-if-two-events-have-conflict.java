// https://leetcode.com/problems/determine-if-two-events-have-conflict

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        
        String st1 = event1[0];
        String st2 = event2[0];
        if(st1.compareTo(st2)<=0){
            // 1<=2
            String ed1 = event1[1];
            return ed1.compareTo(st2)>=0;
            
            
        }else{
            // 2<1
            String ed2 = event2[1];
            return ed2.compareTo(st1)>=0;
        }
        
        
    }
}