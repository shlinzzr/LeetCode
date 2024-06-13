// https://leetcode.com/problems/next-closest-time

class Solution {
    public String nextClosestTime(String time) {
       
        int min = Integer.parseInt(time.substring(0, 2)) * 60;
        min += Integer.parseInt(time.substring(3, 5));
        
        Set<Integer> set = new HashSet<>();
        for(char ch : time.toCharArray()){
            if(ch!=':')
                set.add((int)ch-'0');
        }
        
        
        while(true){
            
            min = (min+1) % (60*24);
            
            int[] next = new int[]{min/60/10, min/60%10, min%60/10, min%60%10};
            
            boolean isValid = true;
            for(int digit : next){
                if(!set.contains(digit))
                    isValid=false;
            }
            
            if(isValid){
                
                char[] arr = new char[]{ (char)(next[0]+'0'), (char)(next[1]+'0'), ':', (char)(next[2]+'0'), (char)(next[3]+'0')};
                return new String(arr);
            }
            
            
            
        }
        
        
        
        
        
    }
}