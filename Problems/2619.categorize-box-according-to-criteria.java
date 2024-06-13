// https://leetcode.com/problems/categorize-box-according-to-criteria

class Solution {
    public String categorizeBox(int length, int width, int height, int mass) {
       long vol = (long)length*(long)width*(long)height;
        
        boolean isBulky = false;
        boolean isHeavy = false;
        
        if(vol>=(int)1e9 || length>=(int)1e4 || width>=(int)1e4 || height>=(int)1e4){
           isBulky = true;
        }
        
        if(mass >= 100)
           isHeavy = true;
        
        if(isHeavy && isBulky)
            return "Both";
        
        if(!isHeavy && !isBulky)
            return "Neither";
        
        if(isBulky && !isHeavy)
            return "Bulky";
            
        if(!isBulky && isHeavy)
            return "Heavy";
        
        return "-1";
        
    }
}