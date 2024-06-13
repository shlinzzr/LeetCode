// https://leetcode.com/problems/hamming-distance

int hammingDistance(int x, int y) { //神人寫法QQ 
    
    int tmpInt=x^y;
    int dis=0;
    
    while(tmpInt)
    {
        if((tmpInt>>1)<<1 != tmpInt)
        {
            ++dis;
        }
        
        tmpInt>>=1;
    }
    
    return dis;
}

// ex after xor:  "0101" = 5 
//                "0100" = 4 
//   ....
