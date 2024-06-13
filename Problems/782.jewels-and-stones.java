// https://leetcode.com/problems/jewels-and-stones

class Solution {
    public int numJewelsInStones(String jewels, String st) {
        Set<Character> set = new HashSet<>();
        for(char ch : jewels.toCharArray()){
            set.add(ch);
        }
        
        int res = 0 ;
        for(int i=0; i<st.length(); i++){
            char ch = st.charAt(i);
            if(set.contains(ch)){
                res++;
            }
        }
        
        return res;
        
    }
}