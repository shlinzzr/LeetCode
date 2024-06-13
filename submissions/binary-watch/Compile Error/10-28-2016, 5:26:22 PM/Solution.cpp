// https://leetcode.com/problems/binary-watch

class Solution {
public:
    vector<string> readBinaryWatch(int num) {
     
        vector<string> timesQQ = new ArrayList<>();
        for(int h=0; h<12; h++)
            for(int m=0; m<60; m++)
                if(Integer.bitCount)(h * 64 + m) == num)
                    times.add(string.format("%d:%02d",h,m));
        return 0;
	
	
    }
};