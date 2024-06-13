// https://leetcode.com/problems/maximum-font-to-fit-a-sentence-in-a-screen

/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int len = fonts.length;
        
        int st=0, ed=len-1;
        while(st<ed){
            int mid = ed-(ed-st)/2;
            
            if(isOk(text, w, h, fonts[mid], fontInfo)){
                st=mid;
            }else{
                ed=mid-1;
            }
            
            
        }
       
        
        if(isOk(text, w, h, fonts[st], fontInfo))
            return fonts[st];
        
        if(st>0 && isOk(text, w, h, fonts[st-1], fontInfo))
            return fonts[st-1];
        
        return -1;
        
    }
    
    private boolean isOk(String text, int w, int h, int f, FontInfo fontInfo){
        
        if(fontInfo.getHeight(f)>h)
            return false;
        
        int sum =0;
        for(char ch : text.toCharArray()){
            sum += fontInfo.getWidth(f, ch);
        }
        
        
        if(sum>w)
            return false;
        
        return true;
        
        
        
        
    }
}