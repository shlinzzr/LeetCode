// https://leetcode.com/problems/guess-number-higher-or-lower

/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        
        int st=0, ed=n;
        
        while(st<ed){
            
            
            int mid = st+(ed-st)/2;
            
            int rt = guess(mid);
            
            if(rt==0)
                return mid;
            else if(rt==-1){
                ed= mid-1;
                
            }else{
                st = mid+1;    
            }
            
        }
        
        return -1;
        
        
    }
}