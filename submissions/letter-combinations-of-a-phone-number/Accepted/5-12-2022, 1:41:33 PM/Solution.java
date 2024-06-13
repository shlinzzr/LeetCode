// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        
        
        
       List<String> ans = new ArrayList<String>(); 
        
         if(digits.isEmpty()) 
            return ans;
        
       String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        
       ans.add("");
       for (char digit : digits.toCharArray()) {
            String curLetters = getLetters(digit);
            List<String> newRes = new ArrayList<>();

            for (String item : ans) {
                for (char curDigit : curLetters.toCharArray()) {
                    newRes.add(item + curDigit);
                }
            }

            ans = newRes;
        }

        
        return ans;
    }
    
     private String getLetters(char num){
        if(num == '2'){
            return "abc"; 
        }else if(num == '3'){
            return "def";  
        }else if(num == '4'){
            return "ghi"; 
        }else if(num == '5'){
            return "jkl";
        }else if(num == '6'){
            return "mno";
        }else if(num == '7'){
            return "pqrs";
        }else if(num == '8'){
            return "tuv";
        }else{
            return "wxyz"; 
        }
    }
}