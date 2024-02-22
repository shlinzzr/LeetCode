// https://leetcode.com/problems/sort-vowels-in-a-string

class Solution {
    public String sortVowels(String s) {
        // A41 a97 // a e i o u 
        
        // l Ee tc O d e  //  EeOe =>  EOee
        
        List<Character> conList = new ArrayList<>();
        List<Character> vowList = new ArrayList<>();
        
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                vowList.add(ch);
            }else{
                conList.add(ch);
            }
        }
        
        Collections.sort(vowList);
        
        StringBuilder sb = new StringBuilder();
        
        int ci=0, vi=0;
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(set.contains(ch)){
                sb.append(vowList.get(vi++));
            }else{
                sb.append(conList.get(ci++));
            }
        }
        
        return sb.toString();
        
        
    }
}