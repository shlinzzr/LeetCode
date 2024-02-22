// https://leetcode.com/problems/read-n-characters-given-read4

/**
 * The read4 API is defined in the parent class Reader4.
 *     int read4(char[] buf4);
 */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Number of characters to read
     * @return    The number of actual characters read
     */
    
    
    char[] prevBuf = new char[4];
    int prevIndex = 0;
    int prevSize = 0;
    
    
    public int read(char[] buf, int n) {
        
        int counter = 0;

        while (counter < n) {
            
            if(prevIndex<prevSize){
                
                buf[counter++] = prevBuf[prevIndex++];
                
            }else{
                prevIndex = 0;
                prevSize = read4(prevBuf);
                
                if(prevSize==0)
                    break;
            }
            
        }

        return counter;
    }
}