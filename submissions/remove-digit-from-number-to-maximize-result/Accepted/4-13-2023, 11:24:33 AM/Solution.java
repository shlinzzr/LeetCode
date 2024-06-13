// https://leetcode.com/problems/remove-digit-from-number-to-maximize-result

class Solution {
    public String removeDigit(String number, char digit) {
        List<String> list = new ArrayList<>();
        
        for(int i=0; i<number.length(); i++){
            
            if(number.charAt(i)==digit){
                String s = number.substring(0, i) + number.substring(i+1, number.length());
                list.add(s);    
            }
        }
        
        Collections.sort(list);
        return list.get(list.size()-1);
        
    }
}