// https://leetcode.com/problems/letter-combinations-of-a-phone-number

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> res= new ArrayList<>();

        if(digits.isEmpty()) 
            return res;

        Map<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");


        helper(digits, 0, new StringBuilder(), res, map);

        return res;
        
    }

    private void helper(String digits, int idx, StringBuilder sb, List<String> res, Map<Character, String> map){

        if(idx==digits.length()){
            res.add(sb.toString());
            return;
        }

        
        char key = digits.charAt(idx);
        for(char ch : map.get(key).toCharArray()){
            sb.append(ch);
            helper(digits, idx+1, sb, res, map);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}