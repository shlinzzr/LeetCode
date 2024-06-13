// https://leetcode.com/problems/categorize-box-according-to-criteria

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
        String cate = "";
        
        boolean cat1=false, cat2=false;
        
        long lg = length*width*height;
        
        if(length>=10000 || width>=10000 || height>=10000 || lg>=1000000000){
            cat1 = true;
        }
        
        // If the mass of the box is greater or equal to 100, it is "Heavy".
        if(mass>=100)
            cat2= true;
        
        if(cat1){
            
            if(cat2){
                return "Both";
            }else{
                return "Bulky";
            }
            
            
        }else{
            
            if(cat2){
                return "Heavy";
            }else{
                return "Neither";
            }
        }
        
        
        
        
    }
}