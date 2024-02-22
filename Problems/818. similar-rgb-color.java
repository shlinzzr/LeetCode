// https://leetcode.com/problems/similar-rgb-color

class Solution {
    public String similarRGB(String color) {
        String[] shorthands = {"00", "11", "22", "33", "44", "55", "66", "77", "88", "99", "aa", "bb", "cc", "dd", "ee", "ff"};
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        
        for (int i = 1 ; i<color.length(); i+=2) {
            
            String hex = color.substring(i, i+2);
            
            int num = Integer.MAX_VALUE;
            String rgb = "";
            
            for (String s : shorthands){
                int res  = Math.abs(Integer.parseInt(hex, 16) - Integer.parseInt(s, 16));
                if (res < num){
                    num = res;
                    rgb = s;
                }
            }
            sb.append(rgb);
        }
        
        
        return sb.toString();
    }
}