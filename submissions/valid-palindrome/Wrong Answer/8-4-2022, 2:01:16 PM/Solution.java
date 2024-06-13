// https://leetcode.com/problems/valid-palindrome

class Solution {
    public boolean isPalindrome(String s) {
        
        List<Character> list =new ArrayList<>();
        
        for(char c : s.toCharArray()){
            if((c>='a' && c<='z') || (c>='A' && c<='Z')){
                
                if (c>='A' && c<='Z'){
                    c = (char) (c-'A' + 'a');
                }
                
                
                list.add(c);
            }
        }
            
        for(int i=0; i<list.size()/2; i++){
            
            if(list.get(i)!=list.get(list.size()-1-i))
                return false;
            
        }
        
        return true;
        
    }
}
