// https://leetcode.com/problems/find-the-longest-semi-repetitive-substring

class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
      
        List<Integer> list = new ArrayList<>();
        List<Integer> rev = new ArrayList<>();
        int len = s.length();
        
        list.add(-1);
        
        for(int i = 0; i<len-1; i++){
            
            if(s.charAt(i)==s.charAt(i+1)){
                list.add(i);
                rev.add(i+1);
            }
                
        }
        
        rev.add(len);
        
        int max = 2;
        
        for(int i=0; i<list.size()-2; i++){
              // System.out.println(list.get(i));
            max = Math.max(max, list.get(i+2)-list.get(i));
        }
        //52233
        // 0 1 3 4
        
        for(int i=0; i<rev.size()-2; i++){
            // System.out.println(rev.get(i));
            max = Math.max(max,  rev.get(i+2)-rev.get(i));
        }
        
        
        if(list.size()==1 && rev.size()==1)
            return len;
        //111111
        //01234
        //225335/
        // -1  0  3 
        // 22335
        // 0 , 2  4
        
        return max;
    }
}