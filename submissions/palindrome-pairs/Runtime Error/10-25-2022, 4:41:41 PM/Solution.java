// https://leetcode.com/problems/palindrome-pairs

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0; i<words.length; i++){
            
            for(int j=i+1; j<words.length; j++){
                
                if(words[i].charAt(0)==words[j].charAt(words[j].length()-1)
                  || words[j].charAt(0)==words[i].charAt(words[i].length()-1)){
                    
                    boolean ab = isPalindrome(words[i], words[j]);
                    boolean ba = isPalindrome(words[j], words[i]);

                    if(ab){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(j);
                        res.add(list);
                    }
                        
                    if(ba){
                        List<Integer> list = new ArrayList<>();
                        list.add(j);
                        list.add(i);
                        res.add(list);
                    }
                }
                    
                
            }
        }
        
        return res;
    }
    
    private boolean isPalindrome(String a, String b){
        if(a.length()==b.length())
            return new StringBuilder(a).reverse().toString().equals(b);
        
        String ab = a+b;
        for(int i=0; i<ab.length()/2; i++){
            if(ab.charAt(i)!=ab.charAt(ab.length()-1-i))
                return false;
        }
        
        return true;
        
    }
}