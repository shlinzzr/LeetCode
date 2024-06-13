// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    

    
    char[] prevBuf = new char[4]; // 宣告一個 char[4]來接資料
    int prevSize = 0;
    int prevIndex = 0;
    
    public int read(char[] buf, int n) {
        
        int counter = 0;
        
        while (counter < n) {
            if (prevIndex < prevSize) {
                buf[counter++] = prevBuf[prevIndex++];
            } else {
                prevSize = read4(prevBuf);
                prevIndex = 0;
                if (prevSize == 0) {
                    // no more data to consume from stream
                    break;
                }
            }
        }
        return counter;
    }
}