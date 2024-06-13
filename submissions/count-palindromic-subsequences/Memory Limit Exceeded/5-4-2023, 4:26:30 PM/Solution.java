// https://leetcode.com/problems/count-palindromic-subsequences

class Solution {
    public int countPalindromes(String s) {
        
        List<String> list = new ArrayList<>();
        genSub(s, list, new StringBuilder(), 0);
        return list.size();
    }
    
    private void genSub(String s, List<String> list, StringBuilder sb, int st){
        
        if(sb.length()==5){
            list.add(sb.toString());
            return;
        }
        
        for(int i=st; i<s.length();i++){
            
            if(sb.length()==3 && s.charAt(i)!= sb.charAt(1))
                continue;
            
            if(sb.length()==4 && s.charAt(i)!= sb.charAt(0))
                continue;
            
            sb.append(s.charAt(i));
            genSub(s, list, sb, i+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}