// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range

class Solution {
    public int countOdds(int low, int high) {
        
        
        
//         int cnt = 0;
//         for(int i= low ; i<=high; i++)
//             if(i%2==1)
//                 cnt++;

        
        boolean addone = (low%2==1) && (high%2==1);
        
            int  cnt=  (high-low)/2+ (high-low)%2;
        if( addone ) cnt++;
        
        return  cnt;
        
    }
}