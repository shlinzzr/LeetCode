// https://leetcode.com/problems/read-n-characters-given-read4-ii-call-multiple-times

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
    
    char[] tmp = new char[4];
    
    int idx=0;
    int size = 0;
    
        
    public int read(char[] buf, int n) {
        
        int cnt = 0;
        
        while(cnt<n){
            if(idx<size){
                buf[cnt++] = tmp[idx++];
            }else{
                size = read4(tmp);
                idx = 0;
                if(size==0)
                    break;
            }
        }
        
        
        return cnt;
    }
}