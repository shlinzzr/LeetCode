// https://leetcode.com/problems/valid-word-square

class Solution {
    public boolean validWordSquare(List<String> words) {
        
        
        int siz = words.size();
        
        for(int i=0; i<siz; i++){
            
            
            
            for(int j=0; j<words.get(i).length(); j++){
                
                
                if(words.get(i).charAt(j)!=words.get(j).charAt(i))
                    return false;
            }
        }
        
        return true;
    }
}

/*
[
"abcd",
"bnrt",
"crm",
"dt"]*/