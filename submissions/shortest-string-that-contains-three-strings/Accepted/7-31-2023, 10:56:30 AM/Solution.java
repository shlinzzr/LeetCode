// https://leetcode.com/problems/shortest-string-that-contains-three-strings

class Solution {
    public String minimumString(String a, String b, String c) {
        
        // abc, acb, bac, bca, cab, cba
        List<String> list = new ArrayList<>();
        list.add(merge(merge(a, b) ,c));
        list.add(merge(merge(a, c) ,b));
        list.add(merge(merge(b, a) ,c));
        list.add(merge(merge(b, c) ,a));
        list.add(merge(merge(c, a) ,b));
        list.add(merge(merge(c, b) ,a));
        String min = list.get(0);
        
        for(String s : list){
            
            if(s.length()>min.length())
                continue;
            
            if(s.length()<min.length())
                min = s;
            
            if (s.compareTo(min) < 0) {
                min = s;
            }
        }
        
        return min;
        
        
    }
    
    
    private String merge(String a, String b){
        
        if(a.contains(b))
            return a;
        
        
        int len = Math.min(a.length(), b.length());
        
        for(int i=len; i>0; i--){
            
            if(a.endsWith(b.substring(0, i)))
                return a + b.substring(i);
        }
        
        return a+b;
        
        
        
    }
    
    
    
}