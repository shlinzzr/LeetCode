// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {
        
       List<String> ans = new ArrayList<String>(); 
        
       String[] letters = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        
       ans.add("");
       for (char digit : digits.toCharArray()) {
            String curLetters = letters[digit - '0'];
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
}