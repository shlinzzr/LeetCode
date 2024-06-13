// https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string

class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        
        
        List<String> list = new ArrayList<>();
        int st=0;
        for(int ed=0; ed<s.length(); ed++){
            
            char ch = s.charAt(ed);
            if(ch=='1')
                k--;
            
            if(k>0)
                continue;
            
            
            
            while(st<s.length() && (k<0 || s.charAt(st)=='0')  ){
                char chst = s.charAt(st++);
                if(chst=='1')
                    k++;
            }
            
            String sub = s.substring(st, ed+1);
            if(!list.isEmpty() && list.get(0).length()>sub.length())
                list = new ArrayList<>();
            
            if(list.isEmpty() || list.get(0).length()==sub.length())
                list.add(sub);
            
        }
        
        Collections.sort(list);
        
        return list.isEmpty() ? "" : list.get(0);
        
    }
}