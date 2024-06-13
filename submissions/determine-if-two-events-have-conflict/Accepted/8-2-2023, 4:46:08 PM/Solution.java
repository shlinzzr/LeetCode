// https://leetcode.com/problems/determine-if-two-events-have-conflict

class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String start1 = event1[0];
        String end1 = event1[1];
        int st1  = Integer.valueOf(start1.split(":")[0]+start1.split(":")[1]);
        int ed1  = Integer.valueOf(end1.split(":")[0]+end1.split(":")[1]);
        
        
        String start2 = event2[0];
        String end2 = event2[1];
        int st2  = Integer.valueOf(start2.split(":")[0]+start2.split(":")[1]);
        int ed2  = Integer.valueOf(end2.split(":")[0]+end2.split(":")[1]);
        
        
        // st1.  ed1
        //       st2.  ed2
        
        
        if(st1<st2 && st2>ed1)
            return false;
        
        if(st2<st1 && st1>ed2)
            return false;
        
        return true;
        
        
        
        
    }
}
