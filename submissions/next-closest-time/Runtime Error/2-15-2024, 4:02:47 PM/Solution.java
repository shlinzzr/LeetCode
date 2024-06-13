// https://leetcode.com/problems/next-closest-time

class Solution {
    public String nextClosestTime(String time) {
        
        HashSet<Integer> set = new HashSet<>();
        
        set.add(time.charAt(0)-'0');
        set.add(time.charAt(1)-'0');
        set.add(time.charAt(3)-'0');
        set.add(time.charAt(4)-'0');
        
        Set<String> seen = new HashSet<>();
        
        String curr = time;
        while(!seen.contains(curr)){
            seen.add(curr);
            
            int hour = Integer.valueOf(curr.substring(0, 2));
            int min = Integer.valueOf(curr.substring(3,5))+1;
            
            if(min==60){
                hour++;
                min=0;
            }
            
            if(hour==24){
                hour=0;
            }
            
            curr = hour+":"+min;
            
            if(isValid(curr, set)){
                return curr;
            }
            
           
        }
        
        return curr;
        
        
                
    }
    
    private boolean isValid(String s, Set<Integer> set ){
        for(int i=0; i<5; i++){
            if(i==2) continue;
            if(!set.contains(s.charAt(i)-'0')) return false;
        }
        
        return true;
    }
}